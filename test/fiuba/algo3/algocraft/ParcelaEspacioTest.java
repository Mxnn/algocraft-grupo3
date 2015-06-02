package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import org.junit.Assert;
import org.junit.Test;

public class ParcelaEspacioTest {

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaEspacio();
        Interactuable unidad = new Marine();

        parcela.guardarElemento(unidad);
    }

    @Test
    public void guardarElementoGuardaElElementoSiEsUnaUnidadVoladora() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaEspacio();
        Interactuable unidadVoladora = new Espectro();

        parcela.guardarElemento(unidadVoladora);

        Assert.assertSame(parcela.devolverElemento(), unidadVoladora);
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractorDeMineral() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaEspacio();
        Interactuable extractor = new CentroDeMineral();

        parcela.guardarElemento(extractor);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractorDeGas() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaEspacio();
        Interactuable extractor = new Refineria(400, 2);

        parcela.guardarElemento(extractor);
    }
    
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaConstruccion() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaEspacio();
         Interactuable construccion = new Barraca();

         parcela.guardarElemento(construccion);
    }
}
