package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public abstract class ExtractorGas extends ConstruccionExtractora {
    private static final int CANTIDAD_DE_GAS_ABSORBIDO_POR_TURNO = 10;

    public void absorberGasVespeno() {
        (this.propietario).sumarGasVespeno(CANTIDAD_DE_GAS_ABSORBIDO_POR_TURNO);
    }

    public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
    	parcela.setElemento(this);
    }
}
