package fiuba.algo3.algocraft.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;

public class MarineTest {

    @Test
    public void atacarRestaVidaATerrestre() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionNoHayLugarDisponible, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso {
        Juego juego = new Juego();
        juego.setMapaParaTests();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        Mapa mapa = juego.getMapa();
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 2));
        while(!barraca.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        Marine marine = barraca.crearMarine(mapa); //Creado en la (3,4)
        while(!marine.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        unJugador.terminarTurno(juego);

        //Construcciones jugador 2
        Barraca barracaJugador2 = (Barraca) unJugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(5, 3));
        while(!barracaJugador2.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        Marine marineJugador2 = barracaJugador2.crearMarine(mapa);

        marine.atacar(marineJugador2.getParcela());
        unJugador2.terminarTurno(juego);

        assertEquals(marineJugador2.getVida(), 40-6);
    }

    @Test
    public void atacarRestaVidaAVolador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoHayLugarDisponible, ExcepcionConstruccionesRequeridasNoCreadas {
        Juego juego = new Juego();
        juego.setMapaParaTests();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        Mapa mapa = juego.getMapa();
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 2));
        while(!barraca.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        Marine marine = barraca.crearMarine(mapa); //Creado en la (3,4)
        while(!marine.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        unJugador.terminarTurno(juego);

        //Construcciones jugador 2
        Barraca barracaJugador2 = (Barraca) unJugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(7, 7));
        while(!barracaJugador2.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        Fabrica fabricaJugador2 = (Fabrica) unJugador2.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(8, 8));
        while(!fabricaJugador2.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        PuertoEstelar puerto = (PuertoEstelar) unJugador2.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(3, 6));
        while(!puerto.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        Espectro espectro = puerto.crearEspectro(mapa);
        unJugador2.terminarTurno(juego);

        marine.atacar(espectro.getParcela());
        
        unJugador.terminarTurno(juego);
        assertEquals(espectro.getVida(), 120-6);
    }

    @Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
    public void atacarFueraDeRangoLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoHayLugarDisponible {
        Juego juego = new Juego();
        juego.setMapaParaTests();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        Mapa mapa = juego.getMapa();
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 2));
        while(!barraca.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        Marine marine = barraca.crearMarine(mapa);
        while(!marine.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        unJugador.terminarTurno(juego);

        Barraca barracaJugador2 = (Barraca) unJugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(18, 18));
        while(!barracaJugador2.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
        unJugador2.terminarTurno(juego);

        marine.atacar(barracaJugador2.getParcela());
        unJugador.terminarTurno(juego);
    }
    @Test
    public void atacarRestaVidaAConstruccion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible {
        Juego juego = new Juego();
        juego.setMapaParaTests();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        Mapa mapa = juego.getMapa();
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 2));
        while(!barraca.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        Marine marine = barraca.crearMarine(mapa); //Creado en la (2,1)
        while(!marine.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        unJugador.terminarTurno(juego);

        Barraca barracaJugador2 = (Barraca) unJugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 5));
        while(!barracaJugador2.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        unJugador2.terminarTurno(juego);

        marine.atacar(barracaJugador2.getParcela());
        unJugador.terminarTurno(juego);

        assertEquals(barracaJugador2.getVida(), 1000-6);
    }
}
