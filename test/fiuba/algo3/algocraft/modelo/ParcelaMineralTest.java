package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.razas.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.utilidades.Interactuable;

import org.junit.Assert;
import org.junit.Test;

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
