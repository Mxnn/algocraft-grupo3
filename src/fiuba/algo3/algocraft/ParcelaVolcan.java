package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public class ParcelaVolcan extends Parcela {

    public void despedirGas() {
        if (!this.estaVacia()) {
            ((ExtractorGas) (this.elemento)).absorberGasVespeno();
        }
    }
    
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela {
        elemento.guardarEnParcela(this);
    }

}
