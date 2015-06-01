package fiuba.algo3.algocraft;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
@RunWith(JUnit4.class)

public class ParcelaTest {

	@Test
	public void devolverItemDevuelveInteractuableGuardado() {
		Parcela parcela = new Parcela();
		Interactuable recurso = new Recurso();
		parcela.guardar(recurso);
		Assert.assertSame(recurso,parcela.devolverItem());
	}
	
	@Test
	public void estaVaciaDevuelveTrueCuandoLoEsta(){
		Parcela parcela = new Parcela();
		Assert.assertTrue(parcela.estaVacia());
	}
	
	@Test
	public void estaVaciaDevuelveFalseCuandoEstaOcupada(){
		Parcela parcela = new Parcela();
		Interactuable recurso = new Recurso();
		parcela.guardar(recurso);
		Assert.assertFalse(parcela.estaVacia());
	}
	
	@Test
	public void guardarNoSobreEscribeItemYaGuardado() {
		Parcela parcela = new Parcela();
		Interactuable recurso = new Recurso();
		Interactuable recurso2 = new Recurso();
		parcela.guardar(recurso);
		parcela.guardar(recurso2);
		Assert.assertSame(recurso,parcela.devolverItem());
	}
	

}
