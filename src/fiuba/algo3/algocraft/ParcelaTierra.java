package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public class ParcelaTierra extends Parcela {
	public ParcelaTierra(Coordenada coordenada) {
        this.elemento = null;
        this.coordenada = coordenada;
    }
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        elemento.guardarEnParcela(this);
    }
    
}
