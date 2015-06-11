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
import fiuba.algo3.algocraft.RazaTerran.Marine;

public class ClonTest {

	@Test
	public void alAgotarseElEscudoMuere() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido{
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		clon.recibirDanyo(80);
		
		assertEquals(unJugador.cantidadDeUnidades(),1); //se espera una porque se murio el clon epro el dragon sigue
	}
	@Test
	public void clonTieneEscudoCorrecto() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido{
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		assertEquals(80,((EstadoProtoss) clon.getEstado()).getEscudo()); 
	}
	@Test
	public void clonTieneCeroVida() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido{
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		assertEquals(0,clon.getEstado().getVida()); 
	}
	
	@Test
	public void elDanyoDelAtaqueEsCero() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance{
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
