package fiuba.algo3.algocraft;

public class Parcela {
	private Interactuable item;
	
	public estaVacia(){
		return this.item == null; 
	}
	
	public guardar(Interactuable item){
		if this.estaVacia(){
			this.item = item;
		}
	}
	
	public devolverItem(){
		return this.item;
	}

}
