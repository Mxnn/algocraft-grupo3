package fiuba.algo3.algocraft.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.razas.terran.unidades.NaveCiencia;

public class NaveCienciaTest {
	//ya esta en los tests de integracion
	@Test
	public void quitaEscudoAProtoss() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion, ExcepcionNoEsElTurnoDelJugador, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible {
		Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
		 Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Protoss.getInstance());
		 juego.agregarJugador(unJugador);
		 juego.agregarJugador(unJugador2);
		 Mapa mapa = new Mapa(2, 10, 10);
		 unJugador.sumarMinerales(999);
	     unJugador.sumarGasVespeno(999);
	     unJugador2.sumarMinerales(999);
	     unJugador2.sumarGasVespeno(999);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	     for(int i= 0; i<=7; i++){
	        	
	    	 unJugador.terminarTurno(juego);
	    	 unJugador2.terminarTurno(juego);
	        }
	        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(7, 7));
	        while(!barraca.estaCreado()) {
	            unJugador.terminarTurno(juego);
	            unJugador2.terminarTurno(juego);
	        }

	        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(8, 8));
	        while(!fabrica.estaCreado()) {
	            unJugador.terminarTurno(juego);
	            unJugador2.terminarTurno(juego);
	        }

	        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(3, 6));
	        while(!puerto.estaCreado()) {
	            unJugador.terminarTurno(juego);
	            unJugador2.terminarTurno(juego);
	        }
	     Interactuable dragon = new Dragon(unJugador);
	     mapa.ubicarElementoEnParcela(new Coordenada (1,1), dragon);

	     NaveCiencia naveCiencia = puerto.crearNaveCiencia(mapa);
	     
	     while(!naveCiencia.estaCreado()) {
	            unJugador.terminarTurno(juego);
	            unJugador2.terminarTurno(juego);
	        }
//	     
//	     
	     for (int i = 0; i < 6; i++) 
	    	 naveCiencia.regenerarEnergia();	   
//	     
	     naveCiencia.lanzarEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
//	     
	     unJugador.terminarTurno(juego);
//	     
	   
//	     
	     assertEquals(0, ((VitalidadProtoss) dragon.getVitalidad()).getEscudo());
	}
	
	@Test(expected = ExcepcionEnergiaInsuficiente.class)
	public void lanzarEMPlanzaExcepcionSiEnergiaInsuficiente() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = juego.getMapa();
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(7, 7));
        while(!barraca.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(8, 8));
        while(!fabrica.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(3, 6));
        while(!puerto.estaCreado()) {
            unJugador.terminarTurno(juego);
        }

        NaveCiencia naveCiencia = puerto.crearNaveCiencia(mapa);
        while(!naveCiencia.estaCreado()) {
            unJugador.terminarTurno(juego);
        }
	     
	    naveCiencia.lanzarEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
        unJugador.terminarTurno(juego);
	}
	
	/*@Test
	public void noQuitaEscudoAConstruccionProtoss() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion {
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
	}*/
	
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
	/*@Test
	public void quitaEscudoAUnidadMagicaProtoss() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion {
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
	}*/
	
//	@Test
//	public void quitaEnergiaAUnidadMagicaProtoss() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoHayLugarDisponible {
//        Juego juego = new Juego();
//        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
//        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Protoss.getInstance());
//        juego.agregarJugador(unJugador);
//        juego.agregarJugador(unJugador2);
//        Mapa mapa = juego.getMapa();
//        unJugador.sumarMinerales(999);
//        unJugador.sumarGasVespeno(999);
//        unJugador2.sumarMinerales(999);
//        unJugador2.sumarGasVespeno(999);
//        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
//        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
//
//        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 2));
//        while(!barraca.estaCreado()) {
//            unJugador.terminarTurno(juego);
//            unJugador2.terminarTurno(juego);
//        }
//
//        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(5, 3));
//        while(!fabrica.estaCreado()) {
//            unJugador.terminarTurno(juego);
//            unJugador2.terminarTurno(juego);
//        }
//
//        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(4, 3));
//        while(!puerto.estaCreado()) {
//            unJugador.terminarTurno(juego);
//            unJugador2.terminarTurno(juego);
//        }
//
//        NaveCiencia naveCiencia = puerto.crearNaveCiencia(mapa); //Creado en la (3,4)
//        while(!naveCiencia.estaCreado()) {
//            unJugador.terminarTurno(juego);
//            unJugador2.terminarTurno(juego);
//        }
//        unJugador.terminarTurno(juego);
//
//        //Construcciones jugador 2
//        Acceso acceso = (Acceso) unJugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(7, 7));
//        while(!acceso.estaCreado()) {
//            unJugador2.terminarTurno(juego);
//            unJugador.terminarTurno(juego);
//        }
//
//        PuertoEstelarProtoss puertoProtoss = (PuertoEstelarProtoss) unJugador2.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(7, 8));
//        while(!puertoProtoss.estaCreado()) {
//            unJugador2.terminarTurno(juego);
//            unJugador.terminarTurno(juego);
//        }
//
//        ArchivosTemplarios archivos = (ArchivosTemplarios) unJugador2.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(3, 6));
//        while(!archivos.estaCreado()) {
//            unJugador2.terminarTurno(juego);
//            unJugador.terminarTurno(juego);
//        }
//
//        AltoTemplario templario = archivos.crearAltoTemplario(mapa); //Creado en (2,5)
//        while(!templario.estaCreado()) {
//            unJugador2.terminarTurno(juego);
//            unJugador.terminarTurno(juego);
//        }
//	    unJugador2.terminarTurno(juego);
//	     
//	    for (int i = 0; i < 6; i++)
//	        naveCiencia.regenerarEnergia();
//	     
////	    ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
////	    listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (2, 5)));
//	     
//	    Ataque ataque = naveCiencia.lanzarEMP(mapa.obtenerParcelaEnCoordenada(new Coordenada (2, 5)));
//	    ataque.ejecutarAtaque();
//	     
//	    assertEquals(0, (templario.getEnergia()));
//	}
	
	/*@Test
	public void quitaEnergiaAUnidadMagicaTerran() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion {
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
	}*/
	
//	@Test
//	public void quitaEnergiaARadioConUnidadesMagicas() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionNoHayLugarDisponible {
//		Juego juego = new Juego();
//        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
//		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
//        juego.agregarJugador(unJugador);
//        juego.agregarJugador(unJugador2);
//		Mapa mapa = juego.getMapa();
//        unJugador.sumarMinerales(999);
//        unJugador.sumarGasVespeno(999);
//        unJugador2.sumarMinerales(999);
//        unJugador2.sumarGasVespeno(999);
//	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
//	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
//	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
//
//	    UnidadMagica templario1 = new AltoTemplario(unJugador);
//	    UnidadMagica templario2 = new AltoTemplario(unJugador);
//	    UnidadMagica templario3 = new AltoTemplario(unJugador);
//	    UnidadMagica templario4 = new AltoTemplario(unJugador);
//	    mapa.ubicarElementoEnParcela(new Coordenada (1,1), templario1);
//	    mapa.ubicarElementoEnParcela(new Coordenada (1,2), templario2);
//	    mapa.ubicarElementoEnParcela(new Coordenada (1,3), templario3);
//	    mapa.ubicarElementoEnParcela(new Coordenada (2,1), templario4);
//
//        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(7, 7));
//        while(!barraca.estaCreado()) {
//            unJugador.terminarTurno(juego);
//            unJugador2.terminarTurno(juego);
//        }
//
//        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(8, 8));
//        while(!fabrica.estaCreado()) {
//            unJugador.terminarTurno(juego);
//            unJugador2.terminarTurno(juego);
//        }
//
//        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(3, 6));
//        while(!puerto.estaCreado()) {
//            unJugador.terminarTurno(juego);
//            unJugador2.terminarTurno(juego);
//        }
//
//        NaveCiencia naveCiencia = puerto.crearNaveCiencia(mapa);
//        while(!naveCiencia.estaCreado()) {
//            unJugador.terminarTurno(juego);
//            unJugador2.terminarTurno(juego);
//        }
//
//        for (int i = 0; i <= 10; i++)
//            naveCiencia.regenerarEnergia();
//
//	    ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
//	    listaParcelas.add(templario1.getParcela());
//	    listaParcelas.add(templario2.getParcela());
//	    listaParcelas.add(templario3.getParcela());
//	    listaParcelas.add(templario4.getParcela());
//
//	    Ataque ataque = naveCiencia.lanzarEMP(listaParcelas);
//	    ataque.ejecutarAtaque();
//
//	    Assert.assertEquals(templario1.getEnergia(), 0);
//        Assert.assertEquals(templario2.getEnergia(), 0);
//        Assert.assertEquals(templario3.getEnergia(), 0);
//        Assert.assertEquals(templario4.getEnergia(), 0);
//	}

}
