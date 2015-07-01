package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

public class VistaBotonCentroMineral extends VistaBotonRepresentante {
    private static final String CODIGO = "CM";
    private static final String NOMBRE = "Centro de Mineral";

	public VistaBotonCentroMineral(CentroDeMineral centroDeMineral){
		super(centroDeMineral, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesInteractuable getVistaDeAcciones(Juego modelo) {
        VistaAccionesInteractuable vistaAcciones = new VistaAccionesInteractuable(modelo, this.elementoRepresentado);

        vistaAcciones.setTitulo(NOMBRE);
        vistaAcciones.setVida(CentroDeMineral.VIDA_INICIAL, this.elementoRepresentado.getVida());

        return vistaAcciones;
    }
}
