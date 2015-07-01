package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

public class VistaBotonRefineria extends VistaBotonRepresentante {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CODIGO = "Re";
    private static final String NOMBRE = "Refineria";

	public VistaBotonRefineria(Refineria refineria) {
		super(refineria, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesInteractuable getVistaDeAcciones(Juego modelo) {
        VistaAccionesInteractuable vistaAcciones = new VistaAccionesInteractuable(modelo, this.elementoRepresentado);

        vistaAcciones.setTitulo(NOMBRE);
        vistaAcciones.setVida(Refineria.VIDA_INICIAL, this.elementoRepresentado.getVida());

        return vistaAcciones;
    }
}
