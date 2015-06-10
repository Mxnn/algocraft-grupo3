package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public class ParcelaMineral extends Parcela {
	public ParcelaMineral(Coordenada coordenada) {
        this.elemento = null;
        this.coordenada = coordenada;
    }

    public void darMinerales() {
        if (!this.estaVacia()) {
            ((ExtractorMineral) (this.elemento)).collectarRecursos();
        }
    }
    
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        elemento.guardarEnParcela(this);
    }

}
