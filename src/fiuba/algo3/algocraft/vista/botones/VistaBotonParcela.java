package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesParcelaVacia;

public class VistaBotonParcela extends VistaBotonInteractuable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Coordenada ubicacion;
	
    public VistaBotonParcela(Coordenada ubicacion) {
        super();
        this.setEnabled(true);
        this.ubicacion = ubicacion;
    }

    public VistaAccionesParcelaVacia getVistaDeAcciones(Juego modelo) {
    	VistaAccionesParcelaVacia vistaAcciones = new VistaAccionesParcelaVacia(modelo, this.ubicacion);
    	return vistaAcciones;
    }
}
