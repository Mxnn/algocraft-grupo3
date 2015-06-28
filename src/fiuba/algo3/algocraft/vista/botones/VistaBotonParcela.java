package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesParcela;

public class VistaBotonParcela extends VistaBotonInteractuable {
	private Coordenada ubicacion;
	
    public VistaBotonParcela(Coordenada ubicacion) {
        super();
        this.setEnabled(true);
        this.ubicacion = ubicacion;
    }

    public VistaAccionesParcela getVistaDeAcciones(Juego modelo) {
    	VistaAccionesParcela vistaAcciones = new VistaAccionesParcela(modelo, this.ubicacion);
    	this.vistaAcciones = vistaAcciones;

    	return vistaAcciones;
    }
}
