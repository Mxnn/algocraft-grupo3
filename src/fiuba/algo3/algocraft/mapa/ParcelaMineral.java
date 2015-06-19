package fiuba.algo3.algocraft.mapa;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.utilidades.Interactuable;

public class ParcelaMineral extends Parcela {
	public ParcelaMineral(Coordenada coordenada) {
        this.elemento = null;
        this.coordenada = coordenada;
    }

    public void darMinerales() {
        if (!this.estaVacia()) {
            ((ExtractorMineral) (this.elemento)).recolectarRecursos();
        }
    }

    @Override
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        elemento.guardarEnParcela(this);
    }
}
