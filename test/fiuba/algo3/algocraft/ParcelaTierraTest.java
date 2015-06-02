package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.RazaTerran.Golliat;
import fiuba.algo3.algocraft.RazaTerran.Marine;
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
        Interactuable marine = new Marine();
        parcela.guardarElemento(marine);

        Assert.assertSame(marine, parcela.devolverElemento());
    }

    @Test
    public void estaVaciaDevuelveFalseCuandoEstaOcupada() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaTierra();
        Interactuable marine = new Marine();
        parcela.guardarElemento(marine);

        Assert.assertFalse(parcela.estaVacia());
    }

    @Test
    public void guardarNoSobreEscribeElementoYaGuardado() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaTierra();
        Interactuable marine = new Marine();
        Interactuable golliat = new Golliat();
        parcela.guardarElemento(marine);
        parcela.guardarElemento(golliat);

        Assert.assertSame(marine, parcela.devolverElemento());
    }
}
