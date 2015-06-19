package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.razas.terran.unidades.NaveTransporteTerran;

import org.junit.Assert;
import org.junit.Test;

public class NaveTransporteTerranTest {
    @Test
    public void insertarUnidadInsertaLaUnidadEnLaNave() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);
        while(!nave.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        Marine marine = new Marine(unJugador);
        while(!marine.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        nave.insertarUnidad(marine);

        Assert.assertEquals(nave.cantidadDeUnidades(), 1);
    }

    @Test(expected = ExcepcionNaveDeTransporteLlena.class)
    public void insertarUnidadLanzaExcepcionSiLaNaveEstaLlena() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);
        while(!nave.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        for (int i = 1; i <= 4; i++) {
            Golliat golliat = new Golliat(unJugador);
            while(!golliat.estaCreado()) {
                unJugador.terminarTurno(juego);
            }
            nave.insertarUnidad(golliat);
        }

        Marine marine = new Marine(unJugador);
        while(!marine.estaCreado()) {
            unJugador.terminarTurno(juego);
        }
        nave.insertarUnidad(marine);
    }

    @Test
    public void destruirNaveDestruyeTodasLasUnidadesQueHayEnSuInterior() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);
        while(!nave.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        for (int i = 1; i <= 4; i++) {
            Golliat golliat = new Golliat(unJugador);
            while(!golliat.estaCreado()) {
                
            	unJugador.terminarTurno(juego);
            }
            nave.insertarUnidad(golliat);
        }

        nave.recibirDanyo(NaveTransporteTerran.VIDA_INICIAL + 1);

        Assert.assertEquals(unJugador.getCantidadDeUnidades(), 0);
        Assert.assertEquals(unJugador.getPoblacion(), 0);
    }

    @Test(expected = ExcepcionNoEsUnidadTerrestre.class)
    public void ingresarUnEspectroLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave {
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
    public void ingresarUnaNaveCienciaLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave {
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
    public void ingresarUnaNaveTransporteLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave {
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
