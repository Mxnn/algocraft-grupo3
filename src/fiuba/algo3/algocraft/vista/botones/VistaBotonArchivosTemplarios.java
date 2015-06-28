package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesArchivosTemplarios;

public class VistaBotonArchivosTemplarios extends VistaBotonRepresentante {
	public static final String CODIGO = "ArT";
	public static final String NOMBRE = "Archivos Templarios";
	
	public VistaBotonArchivosTemplarios(ArchivosTemplarios archivos){
		super(archivos);
		this.setText("ArT");
	}

    @Override
    public VistaAccionesArchivosTemplarios getVistaDeAcciones(Juego modelo) {
    	ArchivosTemplarios representado = (ArchivosTemplarios) this.elementoRepresentado;

    	VistaAccionesArchivosTemplarios vistaAcciones = new VistaAccionesArchivosTemplarios(modelo,representado);
    	vistaAcciones.setTitulo(NOMBRE);

    	
    	vistaAcciones.setVida(representado.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(representado.ESCUDO_INICIAL, escudoActual);
    	
        return vistaAcciones;
    }
}
