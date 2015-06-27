package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.vista.VistaAccionesArchivosTemplarios;

public class VistaBotonArchivosTemplarios extends VistaBotonInteractuable {
	private ArchivosTemplarios representado;

	public VistaBotonArchivosTemplarios(ArchivosTemplarios archivo){
		super();
		this.setText("ArT");
		this.representado = archivo;
	}

    @Override
    public VistaAccionesArchivosTemplarios getVistaDeAcciones(Juego modelo) {
    	VistaAccionesArchivosTemplarios vistaAcciones = new VistaAccionesArchivosTemplarios(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
