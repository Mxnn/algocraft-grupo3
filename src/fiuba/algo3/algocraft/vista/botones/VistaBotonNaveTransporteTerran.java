package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesNaveTransporte;

public class VistaBotonNaveTransporteTerran extends VistaBotonInteractuable {
	public VistaBotonNaveTransporteTerran(){
		super();
		this.setText("NTT");
	}

    @Override
    public VistaAccionesNaveTransporte getVistaDeAcciones(Juego modelo) {
    	VistaAccionesNaveTransporte vistaAcciones = new VistaAccionesNaveTransporte(modelo);
    	this.vistaAcciones = vistaAcciones;
    	return vistaAcciones;
    }
}
