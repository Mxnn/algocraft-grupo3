package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesUnidadAgresora;

public class VistaBotonDragon extends VistaBotonInteractuable {
	public VistaBotonDragon(){
		super();
		this.setText("Dr");
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
