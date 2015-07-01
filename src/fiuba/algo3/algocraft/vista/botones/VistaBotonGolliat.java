package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesUnidadAgresora;

public class VistaBotonGolliat extends VistaBotonRepresentante {
	public static final String NOMBRE = "Golliat";
	public static final String CODIGO = "Go";

	public VistaBotonGolliat(Golliat golliat){
		super(golliat, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	Golliat representado = (Golliat) this.elementoRepresentado;
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	vistaAcciones.setVida(Golliat.VIDA_INICIAL, this.elementoRepresentado.getVida());
        return vistaAcciones;
    }

}