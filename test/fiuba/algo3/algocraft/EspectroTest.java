package fiuba.algo3.algocraft;

import static org.junit.Assert.*;
import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.unidades.Ataque;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;

import org.junit.Test;

import fiuba.algo3.algocraft.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;

public class EspectroTest {

	@Test
	public void atacarRestaVidaATerrestre() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Mapa mapa = new Mapa(2, 5, 5);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    UnidadAgresora espectro = new Espectro(unJugador);
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), espectro);

	    Interactuable marine = new Marine(unJugador2);
	    mapa.ubicarElementoEnParcela(new Coordenada(1,0), marine);
	    Ataque ataque = espectro.atacar(marine.getParcela());
	    
	    ataque.ejecutarAtaque();
	     
	    assertEquals(marine.getVida(), 40-8);
	}
	
	@Test
	public void atacarRestaVidaAVolador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Mapa mapa = new Mapa(2, 5, 5);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    UnidadAgresora espectro = new Espectro(unJugador);
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), espectro);

	    Interactuable espectro2 = new Espectro(unJugador2);
	    mapa.ubicarElementoEnParcela(new Coordenada(1,0), espectro2);
	    Ataque ataque = espectro.atacar(espectro2.getParcela());
	    
	    ataque.ejecutarAtaque();
	     
	    assertEquals(espectro2.getVida(), 120-20);
	}
	
	@Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
	public void atacarFueraDeRangoEnTierraLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Mapa mapa = new Mapa(2, 8, 8);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    UnidadAgresora espectro = new Espectro(unJugador);
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), espectro);

	    Interactuable marine = new Marine(unJugador2);
	    mapa.ubicarElementoEnParcela(new Coordenada(7,0), marine);

	    Ataque ataque = espectro.atacar(marine.getParcela());
	    
	    ataque.ejecutarAtaque();
	}
	
	@Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
	public void atacarFueraDeRangoEnAireLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Mapa mapa = new Mapa(2, 7, 7);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    UnidadAgresora espectro = new Espectro(unJugador);
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), espectro);
	     
	    Interactuable espectro2 = new Espectro(unJugador2);
	    mapa.ubicarElementoEnParcela(new Coordenada(6,0), espectro2);

	    Ataque ataque = espectro.atacar(espectro2.getParcela());
	    
	    ataque.ejecutarAtaque();
	}

	@Test
	public void atacarRestaVidaAConstruccion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Mapa mapa = new Mapa(2, 5, 5);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    UnidadAgresora espectro = new Espectro(unJugador);
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), espectro);
	     
	    Interactuable barraca = new Barraca(unJugador2);
	    mapa.ubicarElementoEnParcela(new Coordenada(1,1), barraca);
	    Ataque ataque = espectro.atacar(barraca.getParcela());
	    
	    ataque.ejecutarAtaque();
	     
	    assertEquals(barraca.getVida(), 1000-8);
	}
}
