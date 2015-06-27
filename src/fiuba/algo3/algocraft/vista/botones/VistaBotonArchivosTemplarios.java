package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesArchivosTemplarios;

public class VistaBotonArchivosTemplarios extends VistaBotonInteractuable {
	public VistaBotonArchivosTemplarios(){
		super();
		this.setText("ArT");
	}

    @Override
    public VistaAccionesArchivosTemplarios getVistaDeAcciones(Juego modelo) {
    	VistaAccionesArchivosTemplarios vistaAcciones = new VistaAccionesArchivosTemplarios(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
