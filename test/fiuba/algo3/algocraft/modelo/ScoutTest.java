package fiuba.algo3.algocraft.modelo;

import static org.junit.Assert.*;
import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;

import org.junit.Test;

import fiuba.algo3.algocraft.razas.protoss.unidades.Scout;
import fiuba.algo3.algocraft.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;

public class ScoutTest {

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
	    UnidadAgresora scout = new Scout(unJugador);
        while(!scout.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
        unJugador.terminarTurno(juego);

	    Interactuable marine = new Marine(unJugador2);
        while(!marine.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(1,0), marine);
        unJugador2.terminarTurno(juego);

	    scout.atacar(marine.getParcela());
        unJugador.terminarTurno(juego);

	    assertEquals(marine.getVida(), 40-8);
	}

	@Test
	public void atacarRestaVidaAVolador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador {
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
	    UnidadAgresora scout = new Scout(unJugador);
        while(!scout.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
        unJugador.terminarTurno(juego);

	    Interactuable espectro = new Espectro(unJugador2);
        while(!espectro.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(1,0), espectro);
        unJugador2.terminarTurno(juego);

	    scout.atacar(espectro.getParcela());
        unJugador.terminarTurno(juego);

	    assertEquals(espectro.getVida(), 120-14);
	}

	@Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
	public void atacarFueraDeRangoEnTierraLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador {
		Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	    Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
	    UnidadAgresora scout = new Scout(unJugador);
        while(!scout.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
        unJugador.terminarTurno(juego);

	    Interactuable marine = new Marine(unJugador2);
        while(!marine.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(5,0), marine);
        unJugador2.terminarTurno(juego);

	    scout.atacar(marine.getParcela());
        unJugador.terminarTurno(juego);
	}

    @Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
    public void atacarFueraDeRangoEnAireLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        Mapa mapa = new Mapa(2, 6, 6);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        UnidadAgresora scout = new Scout(unJugador);
        while(!scout.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
        unJugador.terminarTurno(juego);

        Interactuable espectro = new Espectro(unJugador2);
        while(!espectro.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(0,5), espectro);
        unJugador2.terminarTurno(juego);

        scout.atacar(espectro.getParcela());
        unJugador.terminarTurno(juego);
//        ataque.ejecutarAtaque();
    }

//	@Test
//	public void atacarRestaVidaAConstruccion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador {
//		Juego juego = new Juego();
//        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
//		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
//        juego.agregarJugador(unJugador);
//        juego.agregarJugador(unJugador2);
//		Mapa mapa = new Mapa(2, 5, 5);
//	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
//	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
//	    for(int i= 0; i<=7; i++){
//        	unJugador.terminarTurno(juego);
//        	unJugador2.terminarTurno(juego);
//        }
//	    UnidadAgresora scout = new Scout(unJugador);
//        while(!scout.estaCreado()) {
//            unJugador.terminarTurno(juego);
//            unJugador2.terminarTurno(juego);
//        }
//	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
//        unJugador.terminarTurno(juego);
//
//	    Interactuable barraca = new Barraca(unJugador2);
//        while(!barraca.estaCreado()) {
//            unJugador2.terminarTurno(juego);
//            unJugador.terminarTurno(juego);
//        }
//	    mapa.ubicarElementoEnParcela(new Coordenada(1,1), barraca);
//        unJugador2.terminarTurno(juego);
//
//	    Ataque ataque = scout.atacar(barraca.getParcela());
//	    ataque.ejecutarAtaque();
//
//	    assertEquals(barraca.getVida(), 1000-8);
//	}
}
