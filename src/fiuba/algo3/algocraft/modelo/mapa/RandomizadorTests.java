package fiuba.algo3.algocraft.modelo.mapa;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algocraft.modelo.utilidades.Costo;

public class RandomizadorTests extends Randomizador {
//	public static int CANT_ESPACIOS = 3;
//    public static int COSTO_GAS = 50;
//    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
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
