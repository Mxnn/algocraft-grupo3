package fiuba.algo3.algocraft;

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
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.unidades.Clon;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;

import org.junit.Test;

import fiuba.algo3.algocraft.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;

public class ClonTest {

	@Test
	public void alAgotarseElEscudoMuere() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance {
		Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		clon.recibirDanyo(Dragon.VIDA_INICIAL);
		
		assertEquals(unJugador.getCantidadDeUnidades(), 1); //se espera una porque se murio el clon pero el dragon sigue
	}
	@Test
	public void clonTieneEscudoCorrecto() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {
		Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		assertEquals(80,((VitalidadProtoss) clon.getVitalidad()).getEscudo());
	}
	@Test
	public void clonTieneCeroVida() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEnemigoFueraDeAlcance {
		Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);
		Mapa mapa = new Mapa(2, 6, 6);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
		UnidadAgresora dragon = new Dragon(unJugador);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		
		assertEquals(0,clon.getVitalidad().getVida());
	}
	
	@Test
	public void elDanyoDelAtaqueEsCero() throws ExcepcionEstadoMuerto, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionEnemigoFueraDeAlcance, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador {
		Juego juego = new Juego();
		Mapa mapa = new Mapa(2, 6, 6);
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
	    juego.agregarJugador(unJugador2);
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));
	    for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
	    
		UnidadAgresora dragon = new Dragon(unJugador);
		mapa.ubicarElementoEnParcela(new Coordenada(0,0), dragon);
		
		UnidadAgresora clon = new Clon(dragon, unJugador);
		mapa.ubicarElementoEnParcela(new Coordenada(0,1), clon);
		
		Interactuable marine = new Marine(unJugador2);
		mapa.ubicarElementoEnParcela(new Coordenada(1,0), marine);
		
		clon.atacar(marine.getParcela());
		
		assertEquals(marine.getVida(),40);
	}
}
