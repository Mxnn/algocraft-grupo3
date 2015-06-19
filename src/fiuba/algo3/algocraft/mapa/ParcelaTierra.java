package fiuba.algo3.algocraft.mapa;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.utilidades.Interactuable;

public class ParcelaTierra extends Parcela {
	public ParcelaTierra(Coordenada coordenada) {
        this.elemento = null;
        this.coordenada = coordenada;
    }

    @Override
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        elemento.guardarEnParcela(this);
    }
}
