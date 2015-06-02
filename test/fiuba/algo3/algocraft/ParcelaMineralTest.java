package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import org.junit.Test;

public class ParcelaMineralTest {
    @Test(expected = ExcepcionElementoInvalidoParaParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaMineral();
        Interactuable unidad = new Marine();

        parcela.guardarElemento(unidad);
    }

    @Test(expected = ExcepcionElementoInvalidoParaParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadVoladora() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaMineral();
        Interactuable unidad = new Espectro();

        parcela.guardarElemento(unidad);
    }
}
