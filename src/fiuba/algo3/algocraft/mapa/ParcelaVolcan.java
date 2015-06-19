package fiuba.algo3.algocraft.mapa;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.utilidades.Interactuable;

public class ParcelaVolcan extends Parcela {
	public ParcelaVolcan(Coordenada coordenada) {
        this.elemento = null;
        this.coordenada = coordenada;
    }

    public void despedirGas() {
        if (!this.estaVacia()) {
            ((ExtractorGas) (this.elemento)).recolectarRecursos();
        }
    }

    @Override
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        elemento.guardarEnParcela(this);
    }
}
