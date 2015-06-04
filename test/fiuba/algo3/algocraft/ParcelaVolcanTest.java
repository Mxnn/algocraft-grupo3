package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import org.junit.Test;
import org.junit.Assert;

public class ParcelaVolcanTest {
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoNoAdmitidoEnParcela {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Parcela parcela = new ParcelaVolcan();
        Interactuable unidad = new Marine(unJugador);

        parcela.guardarElemento(unidad);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadVoladora() throws ExcepcionElementoNoAdmitidoEnParcela {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Parcela parcela = new ParcelaVolcan();
        Interactuable unidad = new Espectro(unJugador);

        parcela.guardarElemento(unidad);
    }
    
    @Test
    public void guardarExtractorGasGuardaCorrectamente() throws ExcepcionElementoNoAdmitidoEnParcela{
        Parcela parcela = new ParcelaVolcan();
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable extractor = new Refineria(unJugador);

        parcela.guardarElemento(extractor);

        Assert.assertSame(parcela.devolverElemento(),extractor);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractorDeMineral() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaVolcan();
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable extractor = new CentroDeMineral(unJugador);

        parcela.guardarElemento(extractor);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaConstruccionParaUnidades() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaVolcan();
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable construccion = new Barraca(unJugador);

        parcela.guardarElemento(construccion);
    }

    @Test
    public void despedirGasSumaGasVespenoAlJugadorSiEnLaParcelaHayUnExtractorDeGas() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionRecursosInsuficientes {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ParcelaVolcan parcela = new ParcelaVolcan();

        parcela.guardarElemento(unJugadorPropietario.crearExtractorGas());
        parcela.despedirGas();

        Assert.assertEquals(unJugadorPropietario.obtenerGasVespeno(), Jugador.GAS_VESPENO_INICIAL + 10);
    }
}
