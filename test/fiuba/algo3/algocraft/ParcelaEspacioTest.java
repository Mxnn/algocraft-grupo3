package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import org.junit.Assert;
import org.junit.Test;

public class ParcelaEspacioTest {

    @Test(expected = ExcepcionElementoInvalidoParaParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaEspacio();
        Interactuable unidad = new Marine();

        parcela.guardarElemento(unidad);
    }

    @Test
    public void guardarElementoGuardaElElementoSiEsUnaUnidadVoladora() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaEspacio();
        Interactuable unidadVoladora = new Espectro();

        parcela.guardarElemento(unidadVoladora);

        Assert.assertSame(parcela.devolverElemento(), unidadVoladora);
    }
}
