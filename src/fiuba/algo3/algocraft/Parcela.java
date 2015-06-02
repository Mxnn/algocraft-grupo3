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

	public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela {
		if (this.estaVacia()) {
			elemento.guardarEnParcela(this);
		}
	}

    public abstract void guardarElemento(ConstruccionParaUnidades construccionUnidades) throws ExcepcionElementoNoAdmitidoEnParcela;
    //en el juego los extractores solo pueden ir sobre volcanes o minas
    public abstract void guardarElemento(ExtractorGas extractor) throws ExcepcionElementoNoAdmitidoEnParcela;
    
    public abstract void guardarElemento(ExtractorMineral extractor) throws ExcepcionElementoNoAdmitidoEnParcela;
    
    public abstract void guardarElemento(Unidad unidad) throws ExcepcionElementoNoAdmitidoEnParcela;

    public abstract void guardarElemento(UnidadVoladora unidadVoladora) throws ExcepcionElementoNoAdmitidoEnParcela;
	
	public Interactuable devolverElemento(){
		return this.elemento;
	}
}
