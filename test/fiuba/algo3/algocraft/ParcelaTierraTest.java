package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

public class ParcelaTierraTest {

    @Test
    public void parcelaEmpiezaVacia(){
        Parcela parcela = new ParcelaTierra();

        Assert.assertTrue(parcela.estaVacia());
    }

    @Test
    public void devolverElementoDevuelveInteractuableGuardado() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaTierra();
        Interactuable recurso = new Recurso();
        parcela.guardarElemento(recurso);

        Assert.assertSame(recurso, parcela.devolverElemento());
    }

    @Test
    public void estaVaciaDevuelveFalseCuandoEstaOcupada() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaTierra();
        Interactuable recurso = new Recurso();
        parcela.guardarElemento(recurso);

        Assert.assertFalse(parcela.estaVacia());
    }

    @Test
    public void guardarNoSobreEscribeElementoYaGuardado() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaTierra();
        Interactuable recurso = new Recurso();
        Interactuable recurso2 = new Recurso();
        parcela.guardarElemento(recurso);
        parcela.guardarElemento(recurso2);

        Assert.assertSame(recurso, parcela.devolverElemento());
    }
}
