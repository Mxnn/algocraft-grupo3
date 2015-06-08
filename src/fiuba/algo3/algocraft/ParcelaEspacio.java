package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public class ParcelaEspacio extends Parcela {
	
	public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela {
        elemento.guardarEnParcela(this);
    }

}
