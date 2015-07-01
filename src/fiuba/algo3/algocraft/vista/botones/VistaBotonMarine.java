package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.vista.acciones.unidades.VistaAccionesUnidadAgresora;

public class VistaBotonMarine extends VistaBotonRepresentante {
	private static final String NOMBRE = "Marine";
	private static final String CODIGO = "Ma";

	public VistaBotonMarine(Marine marine) {
		super(marine, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	Marine representado = (Marine) this.elementoRepresentado;
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	vistaAcciones.setVida(Marine.VIDA_INICIAL, this.elementoRepresentado.getVida());
        return vistaAcciones;
    }
}
