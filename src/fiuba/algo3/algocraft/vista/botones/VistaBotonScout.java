package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Scout;
import fiuba.algo3.algocraft.vista.VistaAccionesUnidadAgresora;

public class VistaBotonScout extends VistaBotonInteractuable {
	private Scout representado;

	public VistaBotonScout(Scout scout){
		super();
		this.setText("Sc");
		this.representado = scout;
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
