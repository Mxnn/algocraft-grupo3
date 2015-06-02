package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import org.junit.Test;
import org.junit.Assert;

public class ParcelaVolcanTest {
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaVolcan();
        Interactuable unidad = new Marine();

        parcela.guardarElemento(unidad);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadVoladora() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaVolcan();
        Interactuable unidad = new Espectro();

        parcela.guardarElemento(unidad);
    }
    
    @Test
    public void guardarExtractorGasGuardaCorrectamente() throws ExcepcionElementoNoAdmitidoEnParcela{
        Parcela parcela = new ParcelaVolcan();
        Interactuable extractor = new Refineria(1,1);
        parcela.guardarElemento(extractor);
        Assert.assertSame(parcela.devolverElemento(),extractor);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractorDeMineral() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaVolcan();
        Interactuable extractor = new CentroDeMineral();

        parcela.guardarElemento(extractor);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaConstruccionParaUnidades() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaVolcan();
        Interactuable construccion = new Barraca();

        parcela.guardarElemento(construccion);
    }
}
