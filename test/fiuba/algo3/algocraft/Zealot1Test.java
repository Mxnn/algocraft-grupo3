package fiuba.algo3.algocraft;

import static org.junit.Assert.*;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;
import org.junit.Test;

import fiuba.algo3.algocraft.razas.protoss.unidades.Zealot;
import fiuba.algo3.algocraft.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;

public class Zealot1Test {

	@Test
	public void atacarRestaVidaATerrestre() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Mapa mapa = new Mapa(2, 5, 5);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    UnidadAgresora zealot = new Zealot(unJugador);
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0) , zealot);
	    Interactuable marine = new Marine(unJugador2);
	    mapa.ubicarElementoEnParcela(new Coordenada(1,0) , marine);
	    zealot.atacar(marine);
	     
	    assertEquals(marine.getVida(), 40-8);
	}
	
	@Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
	public void atacarAVoladorLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Mapa mapa = new Mapa(2, 5, 5);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(2, 1));
	    UnidadAgresora zealot = new Zealot(unJugador);
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0) , zealot);
	    Interactuable espectro = new Espectro(unJugador2);
	    mapa.ubicarElementoEnParcela(new Coordenada(1,0), espectro);

        zealot.atacar(espectro);
	}
	
	@Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
	public void atacarFueraDeRangoLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Mapa mapa = new Mapa(2, 5, 5);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    UnidadAgresora zealot = new Zealot(unJugador);
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0) , zealot);
	    Interactuable marine = new Marine(unJugador2);
	    mapa.ubicarElementoEnParcela(new Coordenada(2,0) , marine);

        zealot.atacar(marine);
	}

	@Test
	public void atacarRestaVidaAConstruccion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Mapa mapa = new Mapa(2, 5, 5);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    UnidadAgresora zealot = new Zealot(unJugador);
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0) , zealot);
	    Interactuable barraca = new Barraca(unJugador2);
	    mapa.ubicarElementoEnParcela(new Coordenada(1,1), barraca);
	    zealot.atacar(barraca);
	     
	    assertEquals(barraca.getVida(), 1000-8);
	}
}