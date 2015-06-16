package fiuba.algo3.algocraft;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

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
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;

public class AtaqueEMPTest {

	@Test
	public void sacaEscudoAProtoss() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
//		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
//	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     Interactuable dragon = new Dragon(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), dragon);
//	     Interactuable marine = new Marine(unJugador2);
	     
//	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
//	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     Ataque emp = new AtaqueEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     emp.tareaDeEntreTurno(mapa);
	     
//	     dragon.recibirAtaque(emp);
	     
	     assertEquals(0, ((VitalidadProtoss)dragon.getVitalidad()).getEscudo());
	     
	}
	@Test
	public void noRestaVidaAProtoss() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     
	     Interactuable dragon = new Dragon(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), dragon);
//	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();

	     
	     Ataque emp = new AtaqueEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     emp.tareaDeEntreTurno(mapa);
	     
	     assertEquals(100, (dragon.getVitalidad()).getVida());
	     
	}
	
	@Test
	public void noHaceNadaATerran() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
//		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
//	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
//	     Interactuable dragon = new Dragon(unJugador);
	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), marine);

//	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();

	     
	     Ataque emp = new AtaqueEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     emp.tareaDeEntreTurno(mapa);
	     
	     
	     assertEquals(40, (marine.getVitalidad()).getVida());
	     
	}
	
	@Test
	public void despuesDeUnAtaqueEsDescartable() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), marine);
	     
//	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
//	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada(1,1)));
	     
	     Ataque emp = new AtaqueEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     emp.tareaDeEntreTurno(mapa);
	     
//	     emp.ejecutarAtaque();
	     emp.esDescartable();
	     assertTrue(emp.esDescartable());
	     
	}


}
