package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.vista.VistaJuego;

public class ControladorMover {
	private static ControladorMover INSTANCIA = null;
	private Unidad unidad;
    public ControladorMover() {
	}

	public static ControladorMover createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new ControladorMover();
        }

        return INSTANCIA;
    }
	
    public static ControladorMover getInstance() {
        return INSTANCIA;
    }
    
    public void setUnidad(Unidad unidad){
    	this.unidad = unidad;
    }
    
    public void mover(Coordenada destino){
    	this.unidad.moverHasta(destino);
    }
}
