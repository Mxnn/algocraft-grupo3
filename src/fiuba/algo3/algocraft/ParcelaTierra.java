package fiuba.algo3.algocraft;

public class ParcelaTierra extends Parcela {
    public void guardarElemento(Unidad unidad) {
        this.elemento = unidad;
    }

    public void guardarElemento(UnidadVoladora unidadVoladora) throws ExcepcionElementoNoAdmitidoEnParcela {
        this.elemento = unidadVoladora;
    }
    
    public void guardarElemento(ConstruccionParaUnidades construccion) throws ExcepcionElementoNoAdmitidoEnParcela{
    	this.elemento = construccion;
    }
    //los extractores no pueden ir sobre una parcela comun
    public void guardarElemento(ConstruccionExtractora construccion) throws ExcepcionElementoNoAdmitidoEnParcela{
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
}
