package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesNaveCiencia;

public class VistaBotonNaveCiencia extends VistaBotonInteractuable {
	public VistaBotonNaveCiencia(){
		super();
		this.setText("NC");
	}

    @Override
    public VistaAccionesNaveCiencia getVistaDeAcciones(Juego modelo) {
    	VistaAccionesNaveCiencia vistaAcciones = new VistaAccionesNaveCiencia(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
