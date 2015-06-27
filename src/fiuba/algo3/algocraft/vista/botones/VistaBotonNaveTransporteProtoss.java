package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesNaveTransporte;

public class VistaBotonNaveTransporteProtoss extends VistaBotonInteractuable {
	public VistaBotonNaveTransporteProtoss(){
		super();
		this.setText("NTP");
	}

    @Override
    public VistaAccionesNaveTransporte getVistaDeAcciones(Juego modelo) {
    	VistaAccionesNaveTransporte vistaAcciones = new VistaAccionesNaveTransporte(modelo);
    	this.vistaAcciones = vistaAcciones;
    	return vistaAcciones;
    }
}