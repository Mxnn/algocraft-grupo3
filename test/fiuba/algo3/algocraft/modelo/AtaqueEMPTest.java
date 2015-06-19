package fiuba.algo3.algocraft.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Ataque;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.AtaqueEMP;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.unidades.Dragon;

public class AtaqueEMPTest {

	@Test
	public void sacaEscudoAProtoss() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Juego juego = new Juego();
		juego.agregarJugador(unJugador);
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     for(int i= 0; i<=7; i++){
	        	
	    	 unJugador.terminarTurno(juego);
	        }
	     
	     Interactuable dragon = new Dragon(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), dragon);

	     Ataque emp = new AtaqueEMP(dragon.getParcela());
	     emp.tareaDeEntreTurno(mapa);
	     

	     
	     assertEquals(0, ((VitalidadProtoss)dragon.getVitalidad()).getEscudo());
	     
	}
	@Test
	public void noRestaVidaAProtoss() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Juego juego = new Juego();
		juego.agregarJugador(unJugador);
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     for(int i= 0; i<=7; i++){
	        	
	    	 unJugador.terminarTurno(juego);
	        }
	     Interactuable dragon = new Dragon(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), dragon);


	     
	     Ataque emp = new AtaqueEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     emp.tareaDeEntreTurno(mapa);
	     
	     assertEquals(100, (dragon.getVitalidad()).getVida());
	     
	}
	
	@Test
	public void noHaceNadaATerran() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionNoEsElTurnoDelJugador, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {

		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
			Juego juego = new Juego();
			juego.agregarJugador(unJugador2);
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     for(int i= 0; i<=7; i++){
	        	
	    	 unJugador2.terminarTurno(juego);
	        }

	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), marine);



	     
	     Ataque emp = new AtaqueEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     emp.tareaDeEntreTurno(mapa);
	     
	     
	     assertEquals(40, (marine.getVitalidad()).getVida());
	     
	}
	
	@Test
	public void despuesDeUnAtaqueEsDescartable() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionNoEsElTurnoDelJugador, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {
		 
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		Juego juego = new Juego();
		juego.agregarJugador(unJugador2);
		 Mapa mapa = new Mapa(2, 5, 5);
	     
		 unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     for(int i= 0; i<=7; i++){
	        	
	    	 unJugador2.terminarTurno(juego);
	        }
	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), marine);
	     

	     
	     Ataque emp = new AtaqueEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     emp.tareaDeEntreTurno(mapa);
	     

	     assertTrue(emp.esDescartable());
	     
	}



}
