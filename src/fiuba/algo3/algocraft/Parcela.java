package fiuba.algo3.algocraft;

public abstract class Parcela {
	
	protected Interactuable elemento;

    public Parcela() {
        this.elemento = null;
    }
	
	public boolean estaVacia(){
		return (this.elemento == null);
	}

	public void guardarElemento(Interactuable elemento) throws ExcepcionElementoInvalidoParaParcela {
		if (this.estaVacia()) {
			elemento.guardarEnParcela(this);
		}
	}

    /*public abstract void guardarElemento(Construccion construccion);*/

    public abstract void guardarElemento(Unidad unidad) throws ExcepcionElementoInvalidoParaParcela;

    public abstract void guardarElemento(UnidadVoladora unidadVoladora) throws ExcepcionElementoInvalidoParaParcela;
	
	public Interactuable devolverElemento(){
		return this.elemento;
	}
}
