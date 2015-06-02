package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import org.junit.Test;

public class ParcelaVolcanTest {
    @Test(expected = ExcepcionElementoInvalidoParaParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaVolcan();
        Interactuable unidad = new Marine();

        parcela.guardarElemento(unidad);
    }

    @Test(expected = ExcepcionElementoInvalidoParaParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadVoladora() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaVolcan();
        Interactuable unidad = new Espectro();

        parcela.guardarElemento(unidad);
    }
}
