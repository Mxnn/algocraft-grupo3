package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.construcciones.VistaAccionesArchivosTemplarios;

public class VistaBotonArchivosTemplarios extends VistaBotonRepresentante {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CODIGO = "ArT";
	private static final String NOMBRE = "Archivos Templarios";
	
	public VistaBotonArchivosTemplarios(ArchivosTemplarios archivos){
		super(archivos, CODIGO, NOMBRE);
		this.setText("ArT");
	}

    @Override
    public VistaAccionesArchivosTemplarios getVistaDeAcciones(Juego modelo) {
    	ArchivosTemplarios representado = (ArchivosTemplarios) this.elementoRepresentado;

    	VistaAccionesArchivosTemplarios vistaAcciones = new VistaAccionesArchivosTemplarios(modelo,representado);
    	vistaAcciones.setTitulo(NOMBRE);

    	vistaAcciones.setVida(ArchivosTemplarios.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(ArchivosTemplarios.ESCUDO_INICIAL, escudoActual);
    	
        return vistaAcciones;
    }
}
