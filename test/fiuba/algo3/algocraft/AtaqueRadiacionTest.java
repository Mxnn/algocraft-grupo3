package fiuba.algo3.algocraft;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.unidades.Ataque;
import fiuba.algo3.algocraft.utilidades.unidades.AtaqueEMP;
import fiuba.algo3.algocraft.utilidades.unidades.AtaqueRadiacion;

public class AtaqueRadiacionTest {

	@Test
	public void danya15EnUnAtaque() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     
	     Interactuable dragon = new Dragon(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), dragon);	  
	     
	     Ataque radiacion = new AtaqueRadiacion(dragon, mapa);
	     
	     radiacion.ejecutarAtaque();
	     
	     assertEquals(80-15, ((VitalidadProtoss)dragon.getVitalidad()).getEscudo());
	     
	}
	
	@Test
	public void despuesDeQueElTargetMuereEsDescartable() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), marine);
	  
	     
	     Ataque radiacion = new AtaqueRadiacion(marine, mapa);
	     
	     while(marine.getVida() > 0)
	    	 radiacion.ejecutarAtaque();
	     
	     assertTrue(radiacion.esDescartable());
	}
	
	@Test
	public void danyaALosQueEstanARangoUnoDelAfectado() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), marine);
	     Interactuable marine2 = new Marine(unJugador2);
	     Interactuable marine3 = new Marine(unJugador2);
//	     Interactuable marine4 = new Marine(unJugador2);
	     boolean ataque = true;
	     Ataque radiacion = new AtaqueRadiacion(marine, mapa);
	     
	     mapa.ubicarElementoEnParcela(new Coordenada(2,1), marine2);
	     radiacion.ejecutarAtaque();
	     ataque = (marine2.getVida() == 40-15);
	     
	     mapa.ubicarElementoEnParcela(new Coordenada(3,2), marine2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,2), marine3);
	     radiacion.ejecutarAtaque();
	     ataque = (marine2.getVida() == 40-15);
	     ataque = (marine3.getVida() == 40-15);
	     
	     radiacion.ejecutarAtaque();
	     ataque = (marine2.getVida() == 40-15);
	     ataque = (marine3.getVida() == 40-15-15);	 
	     
	     assertTrue(ataque);
	}
	
	public void danyaALosQueEstanARangoUnoDelAfectadoCuandoSeMueve() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 6, 6);
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     Interactuable marine = new Marine(unJugador2);
	     
	     Interactuable marine2 = new Marine(unJugador2);
	     Interactuable marine3 = new Marine(unJugador2);
	     boolean vidaCorrecta = true;
	     
	     mapa.ubicarElementoEnParcela(new Coordenada(6,6), marine);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), marine3);
	     mapa.ubicarElementoEnParcela(new Coordenada(3,3), marine2);
	     
	     Ataque radiacion = new AtaqueRadiacion(marine, mapa);
	     
	     radiacion.ejecutarAtaque();
	     vidaCorrecta = (marine2.getVida() == 40);
	     vidaCorrecta = (marine3.getVida() == 40);
	     
	     mapa.ubicarElementoEnParcela(new Coordenada(2,1), marine);
	     radiacion.ejecutarAtaque();
	     vidaCorrecta = (marine2.getVida() == 40-15);
	     
	     
	     mapa.ubicarElementoEnParcela(new Coordenada(4,3), marine);
	     radiacion.ejecutarAtaque();
	     vidaCorrecta = (marine2.getVida() == 40-15);
	     vidaCorrecta = (marine3.getVida() == 40-15);
	     
	     assertTrue(vidaCorrecta);
	}


}
