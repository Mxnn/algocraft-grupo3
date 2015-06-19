package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaEspacio;
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
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.razas.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.utilidades.Interactuable;

import org.junit.Assert;
import org.junit.Test;

public class ParcelaEspacioTest {

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {
        Mapa mapa = new Mapa (2, 5 ,5);
        Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);        
		unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
		for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        Parcela parcela = new ParcelaEspacio(new Coordenada(0,0));
        Interactuable unidad = new Marine(unJugador);

        parcela.guardarElemento(unidad);
    }

    @Test
    public void guardarElementoGuardaElElementoSiEsUnaUnidadVoladora() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Mapa mapa = new Mapa(2, 5, 5);
        Juego juego = new Juego();
		Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		juego.agregarJugador(unJugador);        
		unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
		for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        Parcela parcela = new ParcelaEspacio(new Coordenada(0,0));
        Interactuable unidadVoladora = new Espectro(unJugador);

        parcela.guardarElemento(unidadVoladora);

        Assert.assertSame(parcela.devolverElemento(), unidadVoladora);
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractorDeMineral() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Parcela parcela = new ParcelaEspacio(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable extractor = new CentroDeMineral(unJugador);

        parcela.guardarElemento(extractor);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractorDeGas() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Parcela parcela = new ParcelaEspacio(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable extractor = new Refineria(unJugador);

        parcela.guardarElemento(extractor);
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaConstruccion() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Parcela parcela = new ParcelaEspacio(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
         Interactuable construccion = new Barraca(unJugador);

         parcela.guardarElemento(construccion);
    }
}
