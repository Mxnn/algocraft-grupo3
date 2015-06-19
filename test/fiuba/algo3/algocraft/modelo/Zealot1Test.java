package fiuba.algo3.algocraft.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
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
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Zealot;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

public class Zealot1Test {

    @Test
    public void atacarRestaVidaATerrestre() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        UnidadAgresora zealot = new Zealot(unJugador);
        while(!zealot.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(0,0) , zealot);
        unJugador.terminarTurno(juego);

        Interactuable marine = new Marine(unJugador2);
        while(!marine.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(1,0) , marine);
        unJugador2.terminarTurno(juego);

        zealot.atacar(marine.getParcela());
//        ataque.ejecutarAtaque();
        unJugador.terminarTurno(juego);
        
        assertEquals(marine.getVida(), 40-8);
    }

    @Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
    public void atacarAVoladorLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(2, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        UnidadAgresora zealot = new Zealot(unJugador);
        while(!zealot.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(0,0) , zealot);
        unJugador.terminarTurno(juego);

        Interactuable espectro = new Espectro(unJugador2);
        while(!espectro.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(1,0), espectro);

        unJugador2.terminarTurno(juego);
        zealot.atacar(espectro.getParcela());
        unJugador.terminarTurno(juego);
//        ataque.ejecutarAtaque();
    }

    @Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
    public void atacarFueraDeRangoLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        UnidadAgresora zealot = new Zealot(unJugador);
        while(!zealot.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(0,0) , zealot);
        unJugador.terminarTurno(juego);

        Interactuable marine = new Marine(unJugador2);
        while(!marine.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(2,0) , marine);
        unJugador2.terminarTurno(juego);

        zealot.atacar(marine.getParcela());
        unJugador.terminarTurno(juego);
//        ataque.ejecutarAtaque();
    }

    @Test
    public void atacarRestaVidaAConstruccion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionNoHayLugarDisponible {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        Mapa mapa = juego.getMapa();
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(4, 4));
        while(!acceso.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        Zealot zealot = acceso.crearZealot(mapa); //Creado en (3, 4)
        while(!zealot.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        unJugador.terminarTurno(juego);

        Barraca barraca = (Barraca) unJugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 5));
        while(!barraca.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
        unJugador2.terminarTurno(juego);

        zealot.atacar(barraca.getParcela());
        unJugador.terminarTurno(juego);
//        ataque.ejecutarAtaque();

        assertEquals(barraca.getVida(), 1000-8);
    }
}