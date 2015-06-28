package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesUnidadAgresora;

public class VistaBotonGolliat extends VistaBotonRepresentante {

	private static final String NOMBRE = "Golliat";
	private static final String CODIGO = "Go";

	public VistaBotonGolliat(Golliat golliat){
		super(golliat);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	Golliat representado = (Golliat) this.elementoRepresentado;
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	vistaAcciones.setVida(representado.VIDA_INICIAL, this.elementoRepresentado.getVida());
        return vistaAcciones;
    }
}