package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;

public abstract class ExtractorGas extends Construccion {
    public static final int CANTIDAD_DE_GAS_ABSORBIDO_POR_TURNO = 10;

    public void collectarRecursos() {
        (this.propietario).sumarGasVespeno(CANTIDAD_DE_GAS_ABSORBIDO_POR_TURNO);
    }

    public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }
    

}
