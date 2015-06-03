package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import org.junit.Assert;

import org.junit.Test;

public class ParcelaMineralTest {
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaMineral();
        Interactuable unidad = new Marine();

        parcela.guardarElemento(unidad);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadVoladora() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaMineral();
        Interactuable unidad = new Espectro();

        parcela.guardarElemento(unidad);
    }

    @Test
    public void guardarElementoGuardaElElementoSiEsDeTipoExtractorMineral() throws ExcepcionElementoNoAdmitidoEnParcela {
    	Parcela parcela = new ParcelaMineral();
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
    	Interactuable extractorMineral = new CentroDeMineral(unJugador);

    	parcela.guardarElemento(extractorMineral);

    	Assert.assertSame(parcela.devolverElemento(), extractorMineral);
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractorDeGas() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaMineral();
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable construccion = new Refineria(unJugador);

        parcela.guardarElemento(construccion);
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaConstruccionParaUnidades() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaMineral();
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable construccion = new Barraca(unJugador);

        parcela.guardarElemento(construccion);
    }

    @Test
    public void darMineralesSumaMineralesAlJugadorSiEnLaParcelaHayUnExtractorDeMineral() throws ExcepcionElementoNoAdmitidoEnParcela {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ParcelaMineral parcela = new ParcelaMineral();

        parcela.guardarElemento(unJugadorPropietario.crearExtractorMineral());
        parcela.darMinerales();

        Assert.assertEquals(unJugadorPropietario.obtenerMineral(), Jugador.MINERAL_INICIAL + 10);
    }
}
