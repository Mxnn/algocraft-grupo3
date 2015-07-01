package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.NexoMineral;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

public class VistaBotonNexoMineral extends VistaBotonRepresentante {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CODIGO = "NM";
    private static final String NOMBRE = "Nexo Mineral";

	public VistaBotonNexoMineral(NexoMineral nexoMineral){
		super(nexoMineral, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesInteractuable getVistaDeAcciones(Juego modelo) {
        VistaAccionesInteractuable vistaAcciones = new VistaAccionesInteractuable(modelo, this.elementoRepresentado);

        vistaAcciones.setTitulo(NOMBRE);
        vistaAcciones.setVida(NexoMineral.VIDA_INICIAL, this.elementoRepresentado.getVida());
        vistaAcciones.setEscudo(NexoMineral.ESCUDO_INICIAL, ((VitalidadProtoss) (this.elementoRepresentado.getVitalidad())).getEscudo());

        return vistaAcciones;
    }
}
