package fiuba.algo3.algocraft.mapa;

import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;

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
    
    public void guardarElemento(Interactuable elemento) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        elemento.guardarEnParcela(this);
    }

    
	public boolean noEsVolcanNiMineral() {

		return false;
	}
	
}
