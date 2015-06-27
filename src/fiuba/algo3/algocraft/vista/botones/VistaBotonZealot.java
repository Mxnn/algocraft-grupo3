package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesUnidadAgresora;

public class VistaBotonZealot extends VistaBotonInteractuable {
	public VistaBotonZealot(){
		super();
		this.setText("Ze");
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
