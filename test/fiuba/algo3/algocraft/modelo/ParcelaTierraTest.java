package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;

public class ParcelaTierraTest {


	@Test
    public void parcelaEmpiezaVacia(){
        Parcela parcela = new ParcelaTierra(new Coordenada(0,0));

        Assert.assertTrue(parcela.estaVacia());
    }

    @Test
    public void devolverElementoDevuelveInteractuableGuardado() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {
        Mapa mapa = new Mapa(2, 5, 5);
        Coordenada coordenada = new Coordenada(3, 3);
        Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);         
		unJugador.crearAdicionalDeSuministro(mapa, coordenada);
		for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        Parcela parcela = new ParcelaTierra(new Coordenada(0,0));
        Interactuable marine = new Marine(unJugador);
        parcela.guardarElemento(marine);

        Assert.assertSame(marine, parcela.devolverElemento());
    }

    @Test
    public void estaVaciaDevuelveFalseCuandoEstaOcupada() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {
        Mapa mapa = new Mapa(2, 5, 5);
        Coordenada coordenada = new Coordenada(3, 3);
        Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);   

	
		Parcela parcela = new ParcelaTierra(new Coordenada(0,0));

        unJugador.crearAdicionalDeSuministro(mapa, coordenada);
    	for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        Interactuable marine = new Marine(unJugador);
        parcela.guardarElemento(marine);

        Assert.assertFalse(parcela.estaVacia());
    }

    @Test(expected = ExcepcionParcelaOcupada.class)
    public void guardarElementoSobreUnaParcelaYaOcupdaLanzaExcepcion() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Mapa mapa = new Mapa(2, 5, 5);
        Coordenada coordenada = new Coordenada(3, 3);
        Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);         
		unJugador.crearAdicionalDeSuministro(mapa, coordenada);
		for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        Parcela parcela = new ParcelaTierra(new Coordenada(0,0));
        Interactuable marine = new Marine(unJugador);
        Interactuable golliat = new Golliat(unJugador);

        parcela.guardarElemento(marine);
        parcela.guardarElemento(golliat);
    }
    
    @Test
    public void parcelaGuardaUnidadesVoladoras() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Mapa mapa = new Mapa(2, 5, 5);
        Coordenada coordenada = new Coordenada(3, 3);
        Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		
		juego.agregarJugador(unJugador);         
		unJugador.crearAdicionalDeSuministro(mapa, coordenada);
		for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
    	Parcela parcela = new ParcelaTierra(new Coordenada(0,0));
    	Interactuable espectro = new Espectro(unJugador);

    	parcela.guardarElemento(espectro);

    	Assert.assertSame(espectro, parcela.devolverElemento());
    }
    
    @Test
    public void parcelaGuardaConstruccion() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {
        Mapa mapa = new Mapa(2, 5, 5);
        Coordenada coordenada = new Coordenada(3, 3);
        Parcela parcela = new ParcelaTierra(new Coordenada(0,0));
        Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);         unJugador.crearAdicionalDeSuministro(mapa, coordenada);
    	Interactuable construccion = new Barraca(unJugador);

    	parcela.guardarElemento(construccion);

    	Assert.assertSame(construccion, parcela.devolverElemento());
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractor() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Parcela parcela = new ParcelaTierra(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable construccion = new CentroDeMineral(unJugador);

        parcela.guardarElemento(construccion);
    }
}










