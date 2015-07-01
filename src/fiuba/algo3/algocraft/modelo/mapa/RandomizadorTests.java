package fiuba.algo3.algocraft.modelo.mapa;

import java.util.ArrayList;
import java.util.List;


public class RandomizadorTests extends Randomizador {

	private List<Integer> numeros;
	public RandomizadorTests(){
		this.numeros = new ArrayList<Integer>();
		numeros.add(3);
		
		numeros.add(6);
		numeros.add(18);
		numeros.add(3);
		numeros.add(15);
		numeros.add(1);
		numeros.add(13);
		
		numeros.add(6);
		
		numeros.add(0);
		numeros.add(19);
		numeros.add(1);
		numeros.add(19);
		numeros.add(0);
		numeros.add(18);
		
		numeros.add(19);
		numeros.add(0);
		numeros.add(19);
		numeros.add(1);
		numeros.add(18);
		numeros.add(0);
		
		numeros.add(0);
		numeros.add(0);
		
	}
	@Override
	public int randInt(int min, int max) {
		int num = numeros.get(0);
		numeros.remove(0);
		return num;
	}
	

}
