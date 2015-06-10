package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public abstract class ExtractorMineral extends Construccion {
    public static final int CANTIDAD_DE_MINERALES_RECOLECTADOS_POR_TURNO = 10;

    public void collectarRecursos() {
        (this.propietario).sumarMinerales(CANTIDAD_DE_MINERALES_RECOLECTADOS_POR_TURNO);
    }

    public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }
    
 
    
}
