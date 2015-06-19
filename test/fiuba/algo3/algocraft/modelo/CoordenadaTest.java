package fiuba.algo3.algocraft.modelo;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;


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
		Assert.assertTrue("coord(1,2)".equals(hash.get(coordenada2)));
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

    @Test
    public void obtenerCoordenadasVecinasDevuelveLas8CoordenadasVecinasEnUnArray() throws ExcepcionNumeroDeBasesInvalido {
        Coordenada coord = new Coordenada(3, 3);

        ArrayList<Coordenada> lista = coord.obtenerCoordenadasVecinas();

        Assert.assertEquals(lista.size(), 8);
        Assert.assertTrue(lista.contains(new Coordenada(2, 2)));
        Assert.assertTrue(lista.contains(new Coordenada(2, 3)));
        Assert.assertTrue(lista.contains(new Coordenada(2, 4)));
        Assert.assertTrue(lista.contains(new Coordenada(3, 2)));
        Assert.assertTrue(lista.contains(new Coordenada(3, 4)));
        Assert.assertTrue(lista.contains(new Coordenada(4, 2)));
        Assert.assertTrue(lista.contains(new Coordenada(4, 3)));
        Assert.assertTrue(lista.contains(new Coordenada(4, 4)));
    }
    
    @Test
    public void llamandoACalcularCoordenadaSiguienteSePuedeConseguirLaCoordenadaVecinaMasCercaDeLaDestinacion(){
    	Coordenada coordenadaPartida = new Coordenada(2,2);
    	Coordenada coordenadaDeDestinacion = new Coordenada(2,5);

    	Coordenada coordenadaSiguiente=coordenadaPartida.calcularCoordenadaSiguiente(coordenadaDeDestinacion);
    	
    	Assert.assertTrue(coordenadaSiguiente.equals(new Coordenada(2,3)));
    }
}
