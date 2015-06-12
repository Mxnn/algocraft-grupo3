package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.terran.unidades.Espectro;
import fiuba.algo3.algocraft.terran.unidades.Marine;

import org.junit.Assert;
import org.junit.Test;

public class ParcelaMineralTest {
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Parcela parcela = new ParcelaMineral(new Coordenada(0,0));
        Interactuable unidad = new Marine(unJugador);

        parcela.guardarElemento(unidad);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadVoladora() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
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
