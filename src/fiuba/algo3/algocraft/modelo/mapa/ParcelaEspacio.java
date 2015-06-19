package fiuba.algo3.algocraft.modelo.mapa;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.utilidades.Interactuable;

public class ParcelaEspacio extends Parcela {
	public ParcelaEspacio(Coordenada coordenada) {
        this.elemento = null;
        this.coordenada = coordenada;
    }

    @Override
	public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        elemento.guardarEnParcela(this);
    }
}
