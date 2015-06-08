package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public abstract class Parcela {
	
	protected Interactuable elemento;

    public Parcela() {
        this.elemento = null;
    }
	
	public boolean estaVacia(){
		return (this.elemento == null);
	}
	
	public void setElemento(Interactuable elemento) throws ExcepcionParcelaOcupada {
		if (this.estaVacia()) {
			this.elemento = elemento;
		}
        else {
            throw new ExcepcionParcelaOcupada();
        }
	}

	public abstract void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;
	
	public Interactuable devolverElemento(){
		return this.elemento;
	}
}
