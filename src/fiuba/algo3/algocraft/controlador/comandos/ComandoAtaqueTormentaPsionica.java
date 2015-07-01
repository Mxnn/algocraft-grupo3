package fiuba.algo3.algocraft.controlador.comandos;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class ComandoAtaqueTormentaPsionica extends ComandoAccionPorTurno {
	
	@Override
	public void ejecutar(Unidad unidad, Mapa mapa, Coordenada coordenadaObjetivo)throws ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionEnergiaInsuficiente{
		Parcela parcelaObjetivo = this.getParcela(mapa, coordenadaObjetivo);
		((AltoTemplario) unidad).lanzarTormentaPsionica(parcelaObjetivo);
		
	}

}
