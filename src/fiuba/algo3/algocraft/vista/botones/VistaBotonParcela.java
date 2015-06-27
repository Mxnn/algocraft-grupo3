package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesParcelaVacia;

public class VistaBotonParcela extends VistaBotonInteractuable {
	private int x;
	private int y;
	
    public VistaBotonParcela(int x, int y) {
        super();
        this.setEnabled(true);
        this.x = x;
        this.y = y;
    }

    public VistaAccionesParcelaVacia getVistaDeAcciones(Juego modelo) {
    	VistaAccionesParcelaVacia vistaAcciones = new VistaAccionesParcelaVacia(modelo, this.x, this.y);
    	this.vistaAcciones = vistaAcciones;
    	return vistaAcciones;
        		
    }
}
