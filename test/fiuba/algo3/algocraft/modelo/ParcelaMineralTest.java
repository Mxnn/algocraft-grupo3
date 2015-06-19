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
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;

public class ParcelaMineralTest {
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
    	Juego juego = new Juego();
    	Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        Parcela parcela = new ParcelaMineral(new Coordenada(0,0));
        Interactuable unidad = new Marine(unJugador);

        parcela.guardarElemento(unidad);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadVoladora() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
    	Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        }
        Parcela parcela = new ParcelaMineral(new Coordenada(0,0));
        Interactuable unidad = new Espectro(unJugador);

        parcela.guardarElemento(unidad);
    }

    @Test
    public void guardarElementoGuardaElElementoSiEsDeTipoExtractorMineral() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
    	Parcela parcela = new ParcelaMineral(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
    	Interactuable extractorMineral = new CentroDeMineral(unJugador);

    	parcela.guardarElemento(extractorMineral);

    	Assert.assertSame(parcela.devolverElemento(), extractorMineral);
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractorDeGas() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Parcela parcela = new ParcelaMineral(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable construccion = new Refineria(unJugador);

        parcela.guardarElemento(construccion);
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaConstruccionParaUnidades() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Parcela parcela = new ParcelaMineral(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable construccion = new Barraca(unJugador);

        parcela.guardarElemento(construccion);
    }

    @Test
    public void darMineralesSumaMineralesAlJugadorSiEnLaParcelaHayUnExtractorDeMineral() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Coordenada ubicacionMineral = new Coordenada(1, 1);
        ParcelaMineral parcela = new ParcelaMineral(ubicacionMineral);

        parcela.guardarElemento(new CentroDeMineral(unJugadorPropietario));
        parcela.darMinerales();

        Assert.assertEquals(unJugadorPropietario.getMinerales(), Jugador.MINERAL_INICIAL + 10);
    }
}
