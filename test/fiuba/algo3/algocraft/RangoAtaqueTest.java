package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

public class RangoAtaqueTest {
    @Test
    public void obtenerRangoDeAtaqueAlAireDevuelveElRangoDeAtaqueAlAire() {
        RangoAtaque rango = new RangoAtaque(5, 6);

        Assert.assertEquals(rango.obtenerRangoDeAtaqueAlAire(), 5);
    }

    @Test
    public void obtenerRangoDeAtaqueEnTierraDevuelveElRangoDeAtaqueEnTierra() {
        RangoAtaque rango = new RangoAtaque(5, 6);

        Assert.assertEquals(rango.obtenerRangoDeAtaqueEnTierra(), 6);
    }
}
