package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

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
    
    public void ejecutarAccionDeTurno(Mapa mapa, Coordenada target) throws ExcepcionEnergiaInsuficiente, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
    			this.comando.ejectutar(this.unidad, mapa, target);
    			this.unidad = null;	
   	}
}
