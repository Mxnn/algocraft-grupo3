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
import fiuba.algo3.algocraft.mapa.*;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.construcciones.Pilon;
import fiuba.algo3.algocraft.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.unidades.Ataque;
import fiuba.algo3.algocraft.utilidades.unidades.AtaqueEMP;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadMagica;

public class NaveCienciaTest {

	@Test
	public void quitaEscudoAProtoss() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     Interactuable dragon = new Dragon(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), dragon);
	     NaveCiencia naveCiencia = new NaveCiencia(unJugador2);
	     
	     
	     for (int i = 0; i < 6; i++) 
	    	 naveCiencia.regenerarEnergia();
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     Ataque ataque = naveCiencia.lanzarEMP(listaParcelas);
	     ataque.ejecutarAtaque();
	     
	     assertEquals(0, ((VitalidadProtoss)dragon.getVitalidad()).getEscudo());
	}
	
	@Test(expected = ExcepcionEnergiaInsuficiente.class)
	public void lanzaExcepcionSiEnergiaInsuficiente() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     Interactuable dragon = new Dragon(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), dragon);
	     NaveCiencia naveCiencia = new NaveCiencia(unJugador2);
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     Ataque ataque = naveCiencia.lanzarEMP(listaParcelas);
	     ataque.ejecutarAtaque();
	     
	     assertEquals(0, ((VitalidadProtoss)dragon.getVitalidad()).getEscudo());
	}
	
	@Test
	public void noQuitaEscudoAConstruccionProtoss() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     Interactuable pilon = new Pilon(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), pilon);
	     NaveCiencia naveCiencia = new NaveCiencia(unJugador2);
	     
	     
	     for (int i = 0; i < 6; i++) 
	    	 naveCiencia.regenerarEnergia();
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     Ataque ataque = naveCiencia.lanzarEMP(listaParcelas);
	     ataque.ejecutarAtaque();
	     
	     assertEquals(300, ((VitalidadProtoss)pilon.getVitalidad()).getEscudo());
	}
	
//	@Test
//	public void noQuitaEscudoAUnidadMagicaProtoss() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
//		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
//		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
//		 Mapa mapa = new Mapa(2, 5, 5);
//	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
//	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
//	     
//	     Interactuable templario = new AltoTemplario(unJugador);
//	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), templario);
//	     NaveCiencia naveCiencia = new NaveCiencia(unJugador2);
//	     
//	     
//	     for (int i = 0; i < 6; i++) 
//	    	 naveCiencia.regenerarEnergia();
//	     
//	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
//	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
//	     
//	     Ataque ataque = naveCiencia.lanzarEMP(listaParcelas);
//	     ataque.ejecutarAtaque();
//	     
//	     assertEquals(40, ((VitalidadProtoss)templario.getVitalidad()).getEscudo());
//	}
	@Test
	public void quitaEscudoAUnidadMagicaProtoss() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     Interactuable templario = new AltoTemplario(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), templario);
	     NaveCiencia naveCiencia = new NaveCiencia(unJugador2);
	     
	     
	     for (int i = 0; i < 6; i++) 
	    	 naveCiencia.regenerarEnergia();
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     Ataque ataque = naveCiencia.lanzarEMP(listaParcelas);
	     ataque.ejecutarAtaque();
	     
	     assertEquals(0, ((VitalidadProtoss)templario.getVitalidad()).getEscudo());
	}
	
	@Test
	public void quitaEnergiaAUnidadMagicaProtoss() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     UnidadMagica templario = new AltoTemplario(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), templario);
	     NaveCiencia naveCiencia = new NaveCiencia(unJugador2);
	     
	     
	     for (int i = 0; i < 6; i++) 
	    	 naveCiencia.regenerarEnergia();
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     Ataque ataque = naveCiencia.lanzarEMP(listaParcelas);
	     ataque.ejecutarAtaque();
	     
	     assertEquals(0, (templario.getEnergia()));
	}
	
	@Test
	public void quitaEnergiaAUnidadMagicaTerran() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     UnidadMagica nave2 = new NaveCiencia(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), nave2);
	     NaveCiencia naveCiencia = new NaveCiencia(unJugador2);
	     
	     
	     for (int i = 0; i < 6; i++) 
	    	 naveCiencia.regenerarEnergia();
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     Ataque ataque = naveCiencia.lanzarEMP(listaParcelas);
	     ataque.ejecutarAtaque();
	     
	     assertEquals(0, (nave2.getEnergia()));
	}
	
	@Test
	public void quitaEnergiaARadioConUnidadesMagicas() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente {
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     
	     UnidadMagica templario1 = new AltoTemplario(unJugador);
	     UnidadMagica templario2 = new AltoTemplario(unJugador);
	     UnidadMagica templario3 = new AltoTemplario(unJugador);
	     UnidadMagica templario4 = new AltoTemplario(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), templario1);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,2), templario2);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,3), templario3);
	     mapa.ubicarElementoEnParcela(new Coordenada (2,1), templario4);
	     NaveCiencia naveCiencia = new NaveCiencia(unJugador2);
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(templario1.getParcela());
	     listaParcelas.add(templario2.getParcela());
	     listaParcelas.add(templario3.getParcela());
	     listaParcelas.add(templario4.getParcela());
	     
	     for (int i = 0; i < 6; i++) 
	    	 naveCiencia.regenerarEnergia();
	     
	     Ataque ataque = naveCiencia.lanzarEMP(listaParcelas);
	     ataque.ejecutarAtaque();
	     
	     boolean energiaEsCero;
	     
	     energiaEsCero = (0 == (templario1.getEnergia()));
	     energiaEsCero = (0 == (templario2.getEnergia()));
	     energiaEsCero = (0 == (templario3.getEnergia()));
	     energiaEsCero = (0 == (templario4.getEnergia()));
	     
	     assertTrue(energiaEsCero);
	}

}
