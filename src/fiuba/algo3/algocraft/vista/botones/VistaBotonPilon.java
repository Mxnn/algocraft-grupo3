package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Pilon;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

public class VistaBotonPilon extends VistaBotonRepresentante {
    public static final String CODIGO = "Pi";
    public static final String NOMBRE = "Pilon";

	public VistaBotonPilon(Pilon pilon){
		super(pilon, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesInteractuable getVistaDeAcciones(Juego modelo) {
        VistaAccionesInteractuable vistaAcciones = new VistaAccionesInteractuable(modelo, this.elementoRepresentado);

        vistaAcciones.setTitulo(NOMBRE);
        vistaAcciones.setVida(Pilon.VIDA_INICIAL, this.elementoRepresentado.getVida());
        vistaAcciones.setEscudo(Pilon.ESCUDO_INICIAL, ((VitalidadProtoss) (this.elementoRepresentado.getVitalidad())).getEscudo());

        return vistaAcciones;
    }
}