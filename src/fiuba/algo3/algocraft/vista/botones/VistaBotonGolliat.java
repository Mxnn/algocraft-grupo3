package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesUnidadAgresora;

public class VistaBotonGolliat extends VistaBotonInteractuable {
	public VistaBotonGolliat(){
		super();
		this.setText("Go");
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}