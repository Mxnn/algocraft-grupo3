package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Zealot;
import fiuba.algo3.algocraft.vista.VistaAccionesUnidadAgresora;

public class VistaBotonZealot extends VistaBotonInteractuable {
	private Zealot representado;

	public VistaBotonZealot(Zealot zealot){
		super();
		this.setText("Ze");
		this.representado = zealot;
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, this.representado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
