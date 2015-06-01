package fiuba.algo3.algocraft;

import junit.framework.Assert;

import org.junit.Test;

public class MapaTest {

	@Test
	public void devolverElementoEnCoordenadaDevuelveElementoGuardado() {
		Mapa mapa = new Mapa("basico", 5, 5);
		Interactuable recurso = new Recurso();
		mapa.ubicarElementoEnCoordenada(0, 0, recurso);

		Assert.assertSame(recurso, mapa.devolverElementoEnCoordenada(0,0));
	}

}
