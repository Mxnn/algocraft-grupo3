package fiuba.algo3.algocraft;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
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
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.unidades.Ataque;
import fiuba.algo3.algocraft.utilidades.unidades.AtaqueEMP;
import fiuba.algo3.algocraft.utilidades.unidades.AtaqueTormentaPsionica;

public class AtaqueTormentaPsionicaTest {

	@Test
	public void despuesDeDosAtaqueEsDescartable() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), marine);
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada(1,1)));
	     
	     Ataque tormenta = new AtaqueTormentaPsionica(listaParcelas);
	     
	     tormenta.ejecutarAtaque();
	     
	     tormenta.ejecutarAtaque();
	     
	     assertTrue(tormenta.esDescartable());
	     
	}
	
	@Test
	public void despuesDeUnAtaqueNoEsDescartable() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     Interactuable marine = new Marine(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), marine);
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada(1,1)));
	     
	     Ataque tormenta = new AtaqueTormentaPsionica(listaParcelas);
	     
	     tormenta.ejecutarAtaque();
	     
	     assertFalse(tormenta.esDescartable());
	     
	}
	
	@Test
	public void hace50DeDanyoEnUnAtaque() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);

	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     Interactuable golliat = new Golliat(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), golliat);
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada(1,1)));
	     
	     Ataque tormenta = new AtaqueTormentaPsionica(listaParcelas);
	     
	     tormenta.ejecutarAtaque();
	     
	     assertEquals((golliat.getVitalidad()).getVida(), 125-50);     
	}
	
	@Test
	public void hace100DeDanyoEnDosAtaques() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);

	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     Interactuable golliat = new Golliat(unJugador2);
	     mapa.ubicarElementoEnParcela(new Coordenada(1,1), golliat);
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada(1,1)));
	     
	     Ataque tormenta = new AtaqueTormentaPsionica(listaParcelas);
	     
	     tormenta.ejecutarAtaque();
	     tormenta.ejecutarAtaque();
	     
	     assertEquals((golliat.getVitalidad()).getVida(), 125-100); 
	}

}