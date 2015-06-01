package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

public class ParcelaTest {

	@Test
	public void devolverItemDevuelveInteractuableGuardado() {
		Parcela parcela = new Parcela();
		Interactuable recurso = new Recurso();
		parcela.guardarElemento(recurso);

		Assert.assertSame(recurso, parcela.devolverElemento());
	}
	
	@Test
	public void estaVaciaDevuelveTrueCuandoLoEsta(){
		Parcela parcela = new Parcela();

		Assert.assertTrue(parcela.estaVacia());
	}
	
	@Test
	public void estaVaciaDevuelveFalseCuandoEstaOcupada() {
		Parcela parcela = new Parcela();
		Interactuable recurso = new Recurso();
		parcela.guardarElemento(recurso);

		Assert.assertFalse(parcela.estaVacia());
	}
	
	@Test
	public void guardarNoSobreEscribeItemYaGuardado() {
		Parcela parcela = new Parcela();
		Interactuable recurso = new Recurso();
		Interactuable recurso2 = new Recurso();
		parcela.guardarElemento(recurso);
		parcela.guardarElemento(recurso2);

		Assert.assertSame(recurso, parcela.devolverElemento());
	}
	

}
