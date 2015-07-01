package fiuba.algo3.algocraft.controlador.comandos;

import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class AccionPorTurnoListener {
	private static AccionPorTurnoListener INSTANCIA = null;

	private Unidad unidad;
	private ComandoAccionPorTurno comando;
	
    public AccionPorTurnoListener() {
    	

	}

	public static AccionPorTurnoListener createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new AccionPorTurnoListener();
        }

        return INSTANCIA;
    }
	
    public static AccionPorTurnoListener getInstance() {
        return INSTANCIA;
    }
    
    public void setComando(ComandoAccionPorTurno comando){
    	this.comando = comando;
    }
    
    public void setUnidad(Unidad representado){
    	this.unidad = representado;
    }
    
    public void resetControlador(){
    	this.unidad = null;
    }
    
    public void ejecutarAccionDeTurno(Mapa mapa, Coordenada target) throws ExcepcionEnergiaInsuficiente, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionParcelaVacia, ExcepcionUnidadEnemiga, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles, ExcepcionUnidadNoClonable, ExcepcionRecursosInsuficientes{
    	this.comando.ejecutar(this.unidad, mapa, target);
    	this.unidad = null;	
   	}
}
