package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesAcceso;

public class VistaBotonAcceso extends VistaBotonInteractuable {
	public VistaBotonAcceso(){
		super();
		this.setText("Ac");
	}

    @Override
    public VistaAccionesAcceso getVistaDeAcciones(Juego modelo) {
    	VistaAccionesAcceso vistaAcciones = new VistaAccionesAcceso(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
