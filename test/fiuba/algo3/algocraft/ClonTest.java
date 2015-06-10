package fiuba.algo3.algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.Excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.RazaProtoss.Dragon;

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
	
	public void clonTieneEscudoCorrecto() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido{
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		assertEquals(80,((EstadoProtoss) clon.obtenerEstado()).obtenerEscudo()); //se espera una porque se murio el clon epro el dragon sigue
	}
	public void clonTieneCeroVida() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido{
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		assertEquals(0,clon.obtenerEstado().obtenerVida()); //se espera una porque se murio el clon epro el dragon sigue
	}
	
	
}
