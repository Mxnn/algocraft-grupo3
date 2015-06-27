package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesPuertoEstelar;
import fiuba.algo3.algocraft.vista.VistaAccionesPuertoEstelarProtoss;

public class VistaBotonPuertoEstelarProtoss extends VistaBotonInteractuable {
	public VistaBotonPuertoEstelarProtoss(){
		super();
		this.setText("PEP");
	}

    @Override
    public VistaAccionesPuertoEstelarProtoss getVistaDeAcciones(Juego modelo) {
    	VistaAccionesPuertoEstelarProtoss vistaAcciones = new VistaAccionesPuertoEstelarProtoss(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
