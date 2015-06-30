package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveTransporteTerran;

public class NaveTransporteTerranTest {
    @Test
    public void insertarUnidadInsertaLaUnidadEnLaNave() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave, ExcepcionUnidadParaDeMover, ExcepcionUnidadMuyLejos, ExcepcionNoHayLugarDisponible, ExcepcionConstruccionesRequeridasNoCreadas {
        Juego juego = new Juego();
        juego.setMapaParaTests();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = juego.getMapa();
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(7, 8));
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(5, 5));
        while(!barraca.estaCreado()) {
            unJugador.terminarTurno(juego);
        }
        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(6, 6));
        while(!fabrica.estaCreado()) {
            unJugador.terminarTurno(juego);
        }
        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(5, 6));
        while(!puerto.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        NaveTransporteTerran nave = puerto.crearNaveTransporte(mapa);//Creada en (4, 5)
        while(!nave.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        Marine marine = barraca.crearMarine(mapa); //Creado en (4,4)
        while(!marine.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        nave.insertarUnidad(marine);

        Assert.assertEquals(nave.cantidadDeUnidades(), 1);
    }

    @Test(expected = ExcepcionNoEsUnidadTerrestre.class)
    public void ingresarUnEspectroLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave, ExcepcionUnidadParaDeMover, ExcepcionUnidadMuyLejos {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);
        while(!nave.estaCreado()) {
            unJugador.terminarTurno(juego);
        }
        Espectro espectro = new Espectro(unJugador);
        while(!espectro.estaCreado()) {
            
        	unJugador.terminarTurno(juego);
        }

        nave.insertarUnidad(espectro);
    }

    @Test(expected = ExcepcionNoEsUnidadTerrestre.class)
    public void ingresarUnaNaveCienciaLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave, ExcepcionUnidadParaDeMover, ExcepcionUnidadMuyLejos {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);
        while(!nave.estaCreado()) {
            unJugador.terminarTurno(juego);
        }
        NaveCiencia nave2 = new NaveCiencia(unJugador);
        while(!nave2.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        nave.insertarUnidad(nave2);
    }

    @Test(expected = ExcepcionNoEsUnidadTerrestre.class)
    public void ingresarUnaNaveTransporteLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave, ExcepcionUnidadParaDeMover, ExcepcionUnidadMuyLejos {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);
        while(!nave.estaCreado()) {
            unJugador.terminarTurno(juego);
        }
        NaveTransporteTerran nave2 = new NaveTransporteTerran(unJugador);
        while(!nave2.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        nave.insertarUnidad(nave2);
    }
}
