package fiuba.algo3.algocraft.mapa;

import fiuba.algo3.algocraft.Interactuable;
import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;

public class ParcelaTierra extends Parcela {
	public ParcelaTierra(Coordenada coordenada) {
        this.elemento = null;
        this.coordenada = coordenada;
    }
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        elemento.guardarEnParcela(this);
    }
    
}
