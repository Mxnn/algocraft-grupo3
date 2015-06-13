package fiuba.algo3.algocraft;

import static org.junit.Assert.*;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import org.junit.Test;

import fiuba.algo3.algocraft.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.terran.unidades.Marine;

public class ClonTest {

	@Test
	public void alAgotarseElEscudoMuere() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		clon.recibirDanyo(Dragon.VIDA_INICIAL);
		
		assertEquals(unJugador.getCantidadDeUnidades(), 1); //se espera una porque se murio el clon pero el dragon sigue
	}
	@Test
	public void clonTieneEscudoCorrecto() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		assertEquals(80,((VitalidadProtoss) clon.getVitalidad()).getEscudo());
	}
	@Test
	public void clonTieneCeroVida() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		assertEquals(0,clon.getVitalidad().getVida());
	}
	
	@Test
	public void elDanyoDelAtaqueEsCero() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionNombreCorto {
		Mapa mapa = new Mapa(2, 6, 6);
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));
	    
		UnidadAgresora dragon = new Dragon(unJugador);
		mapa.ubicarElementoEnParcela(new Coordenada(0,0), dragon);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		mapa.ubicarElementoEnParcela(new Coordenada(0,1), clon);
		
		Interactuable marine = new Marine(unJugador2);
		mapa.ubicarElementoEnParcela(new Coordenada(1,0), marine);
		
		clon.atacar(marine);
		
		assertEquals(marine.getVida(),40);
	}
}
