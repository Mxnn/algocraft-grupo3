package fiuba.algo3.algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.Excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.RazaProtoss.Dragon;
import fiuba.algo3.algocraft.RazaProtoss.Scout;
import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.Marine;

public class ScoutTest {

	@Test
	public void atacarRestaVidaATerrestre() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     UnidadAgresora scout = new Scout(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,0), marine);
	     scout.atacar(marine);
	     
	     assertEquals(marine.obtenerVida(), 40-8);
	}
	
	@Test
	public void atacarRestaVidaAVolador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     UnidadAgresora scout = new Scout(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
	     
	     Interactuable espectro = new Espectro(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,0), espectro);
	     scout.atacar(espectro);
	     
	     assertEquals(espectro.obtenerVida(), 120-14);
	     
	}
	
	@Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
	public void atacarFueraDeRangoEnTierraLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 6, 6);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     UnidadAgresora scout = new Scout(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
	     
	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(5,0), marine);
	     scout.atacar(marine);
	     
	}
	
	@Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
	public void atacarFueraDeRangoEnAireLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 6, 6);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     UnidadAgresora scout = new Scout(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
	     
	     Interactuable espectro = new Espectro(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(0,5), espectro);
	     
	     scout.atacar(espectro);
	     
	}
	@Test
	public void atacarRestaVidaAConstruccion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     UnidadAgresora scout = new Scout(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
	     
	     Interactuable barraca = new Barraca(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), barraca);
	     scout.atacar(barraca);
	     
	     assertEquals(barraca.obtenerVida(), 1000-8);
	}

}