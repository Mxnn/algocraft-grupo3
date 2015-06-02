package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

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
    public void guardarElemento(ExtractorGas extractor) throws ExcepcionElementoNoAdmitidoEnParcela{
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarElemento(ExtractorMineral extractor) throws ExcepcionElementoNoAdmitidoEnParcela{
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
}
