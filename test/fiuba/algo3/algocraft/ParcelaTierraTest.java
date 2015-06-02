package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.RazaTerran.*;

import org.junit.Assert;
import org.junit.Test;

public class ParcelaTierraTest {

    @Test
    public void parcelaEmpiezaVacia(){
        Parcela parcela = new ParcelaTierra();

        Assert.assertTrue(parcela.estaVacia());
    }

    @Test
    public void devolverElementoDevuelveInteractuableGuardado() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaTierra();
        Interactuable marine = new Marine();
        parcela.guardarElemento(marine);

        Assert.assertSame(marine, parcela.devolverElemento());
    }

    @Test
    public void estaVaciaDevuelveFalseCuandoEstaOcupada() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaTierra();
        Interactuable marine = new Marine();
        parcela.guardarElemento(marine);

        Assert.assertFalse(parcela.estaVacia());
    }

    @Test
    public void guardarNoSobreEscribeElementoYaGuardado() throws ExcepcionElementoNoAdmitidoEnParcela {
        Parcela parcela = new ParcelaTierra();
        Interactuable marine = new Marine();
        Interactuable golliat = new Golliat();
        parcela.guardarElemento(marine);
        parcela.guardarElemento(golliat);

        Assert.assertSame(marine, parcela.devolverElemento());
    }
    
    @Test
    public void parcelaGuardaUnidadesVoladoras() throws ExcepcionElementoNoAdmitidoEnParcela {
    	Parcela parcela = new ParcelaTierra();
    	Interactuable espectro = new Espectro();
    	parcela.guardarElemento(espectro);
    	Assert.assertSame(espectro, parcela.devolverElemento());
    }
    
//    @Test
//    public void parcelaGuardaConstruccion() throws ExcepcionElementoNoAdmitidoEnParcela {
//    	Parcela parcela = new ParcelaTierra();
//    	Interactuable construccion = new Barraca();
//    	parcela.guardarElemento(construccion);
//    	Assert.assertSame(construccion, parcela.devolverElemento());
//    }
    
//  @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
//  public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractor() throws ExcepcionElementoNoAdmitidoEnParcela {
//      Parcela parcela = new ParcelaTierra();
//      Interactuable construccion = new CentroDeMineral();
//
//      parcela.guardarElemento(construccion);
//  }
    
}










