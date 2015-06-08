package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public class ParcelaMineral extends Parcela {

    public void darMinerales() {
        if (!this.estaVacia()) {
            ((ExtractorMineral) (this.elemento)).recolectarMinerales();
        }
    }
    
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela {
        elemento.guardarEnParcela(this);
    }

}
