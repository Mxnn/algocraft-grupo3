package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class ControladorAccionPorTurno {
	private static ControladorAccionPorTurno INSTANCIA = null;

	private Unidad unidad;
	private ComandoAccionPorTurno comando;
	
    public ControladorAccionPorTurno() {
    	

	}

	public static ControladorAccionPorTurno createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new ControladorAccionPorTurno();
        }

        return INSTANCIA;
    }
	
    public static ControladorAccionPorTurno getInstance() {
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
    	this.comando.ejectutar(this.unidad, mapa, target);
    	this.unidad = null;	
   	}
}
