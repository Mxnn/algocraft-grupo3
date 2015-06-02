package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.RazaTerran.Golliat;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import org.junit.Assert;
import org.junit.Test;

public class MapaTest {

	@Test
	public void devolverElementoEnParcelaDevuelveElementoGuardado() throws ExcepcionElementoNoAdmitidoEnParcela {
		Mapa mapa = new Mapa("basico", 5, 5);
		Interactuable marine = new Marine();
		mapa.ubicarElementoEnParcela(0, 0, marine);

		Assert.assertSame(marine, mapa.devolverElementoEnParcela(0, 0));
	}

    @Test
    public void ubicarGolliatEnParcelaLanzaExcepcionSiElElementoNoEsAdmitidoEnLaParcela() throws ExcepcionElementoNoAdmitidoEnParcela {
        Mapa mapa = new Mapa("basico", 5, 5);
        Interactuable golliat = new Golliat();
        mapa.ubicarElementoEnParcela(0, 0, golliat);

        Assert.assertSame(golliat, mapa.devolverElementoEnParcela(0,0));
    }
}
