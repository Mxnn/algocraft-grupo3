package fiuba.algo3.algocraft.controlador.comandos;

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
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public abstract class ComandoAccionPorTurno {
	
	public Parcela getParcela(Mapa mapa, Coordenada coordenada){
		return mapa.obtenerParcelaEnCoordenada(coordenada);
	}

	public abstract void ejecutar(Unidad unidad, Mapa mapa, Coordenada coordenadaObjetivo) throws ExcepcionEstadoMuerto, ExcepcionEnergiaInsuficiente, ExcepcionParcelaVacia, ExcepcionEntidadEnConstruccion, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadEnemiga, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles, ExcepcionUnidadNoClonable, ExcepcionRecursosInsuficientes;
}
