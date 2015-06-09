package fiuba.algo3.algocraft;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;


public class CoordenadaTest {

	@Test
	public void nuevaCoordenadaDevuelveCoordenadasCorrectas() {
		Coordenada coordenada = new Coordenada(1,2);
		Assert.assertTrue(coordenada.getY()==2 &&coordenada.getX()==1);
	}
	
	@Test
	public void coordenadasConXYIgualesSonIguales(){
		Coordenada coordenada1 = new Coordenada(1,2);
		Coordenada coordenada2 = new Coordenada(1,2);
		Assert.assertTrue(coordenada1.equals(coordenada2));
	}
	
	@Test
	public void coordenadasConXYDistintasSonDistintas(){
		Coordenada coordenada1 = new Coordenada(1,2);
		Coordenada coordenada2 = new Coordenada(2,1);
		Assert.assertFalse(coordenada1.equals(coordenada2));
	}
	
	@Test
	public void nuevaCoordenadaEsEncontradaEnHashMap(){
		Coordenada coordenada1 = new Coordenada(1,2);
		Coordenada coordenada2 = new Coordenada(1,2);
		HashMap<Coordenada, String> hash = new HashMap<Coordenada, String>();
		hash.put(coordenada1,"coord(1,2)");
		Assert.assertTrue("coord(1,2)" == hash.get(coordenada2));
	}
	
    @Test
    public void distanciaConCoordenadaDevuelveDistanciaDeAlgoAIzquierda(){
    	Coordenada coord1 = new Coordenada(3,3);
    	Coordenada coord2 = new Coordenada(0,2);
    	Assert.assertEquals(coord1.distanciaConCoordenada(coord2), 3);
    }
    
    @Test
    public void distanciaConCoordenadaDevuelveDistanciaDeAlgoADerecha(){
    	Coordenada coord1 = new Coordenada(3,3);
    	Coordenada coord2 = new Coordenada(5,3);
    	Assert.assertEquals(coord1.distanciaConCoordenada(coord2), 2);
    }
    
    @Test
    public void distanciaConCoordenadaDevuelveDistanciaDeAlgoArriba(){
    	Coordenada coord1 = new Coordenada(3,3);
    	Coordenada coord2 = new Coordenada(3,1);
    	Assert.assertEquals(coord1.distanciaConCoordenada(coord2), 2);
    }
    
    @Test
    public void distanciaConCoordenadaDevuelveDistanciaDeAlgoAbajo(){
    	Coordenada coord1 = new Coordenada(3,3);
    	Coordenada coord2 = new Coordenada(3,7);
    	Assert.assertEquals(coord1.distanciaConCoordenada(coord2), 4);
    }
    
    @Test
    public void distanciaConCoordenadaCuandoSonIgualesDaCero(){
    	Coordenada coord1 = new Coordenada(3,3);
    	Coordenada coord2 = new Coordenada(3,3);
    	Assert.assertEquals(coord1.distanciaConCoordenada(coord2), 0);
    }

}
