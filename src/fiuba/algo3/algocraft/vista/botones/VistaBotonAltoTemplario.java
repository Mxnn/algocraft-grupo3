package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAcciones;
import fiuba.algo3.algocraft.vista.VistaAccionesAltoTemplario;
import fiuba.algo3.algocraft.vista.VistaAccionesUnidadAgresora;

public class VistaBotonAltoTemplario extends VistaBotonInteractuable {
	public VistaBotonAltoTemplario(){
		super();
		this.setText("AlT");
	}

    @Override
    public VistaAcciones getVistaDeAcciones(Juego modelo) {
    	VistaAccionesAltoTemplario vistaAcciones = new VistaAccionesAltoTemplario(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}

