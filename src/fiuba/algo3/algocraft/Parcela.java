package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public abstract class Parcela {
	
	protected Interactuable elemento;

    public Parcela() {
        this.elemento = null;
    }
	
	public boolean estaVacia(){
		return (this.elemento == null);
	}
	
	public void setElemento(Interactuable elemento){
		if (this.estaVacia()) {
			this.elemento = elemento;
		}
	}

	public abstract void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela ;
	
	public Interactuable devolverElemento(){
		return this.elemento;
	}
}
