package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;

public class ComandoAtaqueEMP extends ComandoAccionPorTurno {

	@Override
	public void ejectutar(Unidad unidad, Mapa mapa,Coordenada coordenadaObjetivo)throws ExcepcionEstadoMuerto, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion, ExcepcionEnemigoFueraDeAlcance{
		Parcela parcelaObjetivo = this.getParcela(mapa, coordenadaObjetivo);
		((NaveCiencia) unidad).lanzarEMP(parcelaObjetivo);
		
	}

}
