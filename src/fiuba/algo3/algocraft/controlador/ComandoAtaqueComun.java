package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaVacia;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

public class ComandoAtaqueComun extends ComandoAccionPorTurno {

	@Override
	public void ejectutar(Unidad unidad, Mapa mapa,Coordenada coordenadaObjetivo) throws ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionParcelaVacia {
		Parcela parcela = this.getParcela(mapa, coordenadaObjetivo);
		((UnidadAgresora) unidad).atacar(parcela);	
	}

}
