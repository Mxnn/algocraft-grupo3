package fiuba.algo3.algocraft.mapa;

import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;

public abstract class Parcela {
	
	protected Coordenada coordenada;
	protected Interactuable elemento;
    
    public void ubicarEnCoordenada(Coordenada coordenada){
    	this.coordenada = coordenada;
    }
    
    public Coordenada getCoordenada(){
    	return this.coordenada;
    }
    
    public int devolverDistanciaConParcela(Parcela otra){
    	return (this.coordenada).distanciaConCoordenada(otra.getCoordenada());
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

    public void vaciarParcela() {
        this.elemento = null;
    }

	public abstract void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;
	
	public Interactuable devolverElemento(){
		return this.elemento;
	}


}
