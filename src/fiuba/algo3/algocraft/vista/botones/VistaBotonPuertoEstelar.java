package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesPuertoEstelar;

public class VistaBotonPuertoEstelar extends VistaBotonInteractuable {
	public VistaBotonPuertoEstelar(){
		super();
		this.setText("Ma");
	}

    @Override
    public VistaAccionesPuertoEstelar getVistaDeAcciones(Juego modelo) {
    	VistaAccionesPuertoEstelar vistaAcciones = new VistaAccionesPuertoEstelar(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
