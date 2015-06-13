package fiuba.algo3.algocraft.utilidades;

public class Costo {
	private int costoMineral;
	private int costoGas;
	
	public Costo(int elCostoMineral, int elCostoGas){
		this.costoMineral= elCostoMineral;
		this.costoGas= elCostoGas;
	}

	public int getCostoMineral() {
		return costoMineral;
	}

	public int getCostoGas() {
		return costoGas;
	}

}
