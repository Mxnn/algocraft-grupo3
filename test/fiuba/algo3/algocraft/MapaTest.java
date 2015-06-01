package fiuba.algo3.algocraft;

import junit.framework.Assert;
import org.junit.Test;

public class MapaTest {

	@Test
	public void devolverElementoEnParcelaDevuelveElementoGuardado() throws ExcepcionElementoInvalidoParaParcela {
		Mapa mapa = new Mapa("basico", 5, 5);
		Interactuable recurso = new Recurso();
		mapa.ubicarElementoEnParcela(0, 0, recurso);

		Assert.assertSame(recurso, mapa.devolverElementoEnParcela(0,0));
	}

    @Test
    public void ubicarElementoEnParcelaLanzaExcepcionSiElElementoNoCorrespondeALaParcela() throws ExcepcionElementoInvalidoParaParcela {
        Mapa mapa = new Mapa("basico", 5, 5);
        Interactuable recurso = new Recurso();
        mapa.ubicarElementoEnParcela(0, 0, recurso);

        Assert.assertSame(recurso, mapa.devolverElementoEnParcela(0,0));
    }
}
