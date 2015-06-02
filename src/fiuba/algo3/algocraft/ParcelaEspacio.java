package fiuba.algo3.algocraft;

public class ParcelaEspacio extends Parcela {
    public void guardarElemento(UnidadVoladora unidadVoladora) throws ExcepcionElementoNoAdmitidoEnParcela {
        this.elemento = unidadVoladora;
    }

    public void guardarElemento(Unidad unidad) throws ExcepcionElementoNoAdmitidoEnParcela {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarElemento(ConstruccionParaUnidades construccion) throws ExcepcionElementoNoAdmitidoEnParcela{
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarElemento(ExtractorGas extractor) throws ExcepcionElementoNoAdmitidoEnParcela{
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarElemento(ExtractorMineral extractor) throws ExcepcionElementoNoAdmitidoEnParcela{
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
}
