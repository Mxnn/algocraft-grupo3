package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.vista.VistaJuego;

public class ControladorMover {
	private static ControladorMover INSTANCIA = null;
	private Juego juego;
	private Unidad unidad;
    public ControladorMover(Juego juego) {
		this.juego = juego;
	}

	public static ControladorMover createInstance(Juego juego) {
        if (INSTANCIA == null) {
            INSTANCIA = new ControladorMover(juego);
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
