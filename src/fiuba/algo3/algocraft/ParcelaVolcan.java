package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public class ParcelaVolcan extends Parcela {

    public void despedirGas() {
        if (!this.estaVacia()) {
            ((ExtractorGas) (this.elemento)).absorberGasVespeno();
        }
    }
    
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        elemento.guardarEnParcela(this);
    }

}
