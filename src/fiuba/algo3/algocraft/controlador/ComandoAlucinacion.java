package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaVacia;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadEnemiga;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadNoClonable;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;

public class ComandoAlucinacion extends ComandoAccionPorTurno {

	@Override
	public void ejectutar(Unidad unidad, Mapa mapa,Coordenada coordenadaObjetivo)throws ExcepcionEstadoMuerto,ExcepcionEnergiaInsuficiente, ExcepcionParcelaVacia, ExcepcionUnidadEnemiga, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles, ExcepcionUnidadNoClonable, ExcepcionRecursosInsuficientes {
		Parcela parcela = mapa.obtenerParcelaEnCoordenada(coordenadaObjetivo);
		((AltoTemplario) unidad).crearAlucinacion(parcela, mapa);

	}

}
