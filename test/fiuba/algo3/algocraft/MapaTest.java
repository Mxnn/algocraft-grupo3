package tpalgo3;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MapaTest {

	@Test
	public void devolverElementoEnCoordenadaDevuelveElemetoGuardado() {
		Mapa mapa = new mapa("basico",5,5);
		Interactuabe recurso = new Recurso();
		mapa.ubicarEnCoordenada(0,0,recurso);
		Assert.assertSame(recurso, mapa.devolverElementoEnCoordenada(0,0));
	}

}
