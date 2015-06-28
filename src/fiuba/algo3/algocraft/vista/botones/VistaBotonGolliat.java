package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesUnidadAgresora;

public class VistaBotonGolliat extends VistaBotonRepresentante {

	public VistaBotonGolliat(Golliat golliat){
		super(golliat);
		this.setText("Go");
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, (Golliat) this.elementoRepresentado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}