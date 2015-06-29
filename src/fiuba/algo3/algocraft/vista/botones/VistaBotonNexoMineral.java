package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.NexoMineral;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

public class VistaBotonNexoMineral extends VistaBotonRepresentante {
    public static final String CODIGO = "NM";
    public static final String NOMBRE = "Nexo Mineral";

	public VistaBotonNexoMineral(NexoMineral nexoMineral){
		super(nexoMineral);
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
