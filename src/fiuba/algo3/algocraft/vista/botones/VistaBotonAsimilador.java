package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Asimilador;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

public class VistaBotonAsimilador extends VistaBotonRepresentante {

    private static final String CODIGO = "As";
    private static final String NOMBRE = "Asimilador";

	public VistaBotonAsimilador(Asimilador asimilador){
		super(asimilador, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesInteractuable getVistaDeAcciones(Juego modelo) {
        VistaAccionesInteractuable vistaAcciones = new VistaAccionesInteractuable(modelo, this.elementoRepresentado);

        vistaAcciones.setTitulo(NOMBRE);
        vistaAcciones.setVida(Asimilador.VIDA_INICIAL, this.elementoRepresentado.getVida());
        vistaAcciones.setEscudo(Asimilador.ESCUDO_INICIAL, ((VitalidadProtoss) (this.elementoRepresentado.getVitalidad())).getEscudo());

        return vistaAcciones;
    }
}
