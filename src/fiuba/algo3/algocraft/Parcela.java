package fiuba.algo3.algocraft;

public class Parcela {
	private Interactuable elemento;
	
	public boolean estaVacia(){
		return (this.elemento == null);
	}
	
	public void guardarElemento(Interactuable elemento) {
		if (this.estaVacia()) {
			this.elemento = elemento;
		}
	}
	
	public Interactuable devolverElemento(){
		return this.elemento;
	}
}
