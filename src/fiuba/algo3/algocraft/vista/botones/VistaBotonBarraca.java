package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesBarraca;

public class VistaBotonBarraca extends VistaBotonInteractuable {
	public VistaBotonBarraca(){
		super();
		this.setText("Ba");
	}

    @Override
    public VistaAccionesBarraca getVistaDeAcciones(Juego modelo) {
    	VistaAccionesBarraca vistaAcciones = new VistaAccionesBarraca(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
