package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesArchivosTemplarios;

public class VistaBotonArchivosTemplarios extends VistaBotonRepresentante {
	public VistaBotonArchivosTemplarios(ArchivosTemplarios archivos){
		super(archivos);
		this.setText("ArT");
	}

    @Override
    public VistaAccionesArchivosTemplarios getVistaDeAcciones(Juego modelo) {
    	VistaAccionesArchivosTemplarios vistaAcciones = new VistaAccionesArchivosTemplarios(modelo, (ArchivosTemplarios) this.elementoRepresentado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
