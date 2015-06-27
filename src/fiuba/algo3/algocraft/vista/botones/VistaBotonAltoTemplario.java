package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.vista.VistaAcciones;
import fiuba.algo3.algocraft.vista.VistaAccionesAltoTemplario;
import fiuba.algo3.algocraft.vista.VistaAccionesUnidadAgresora;

public class VistaBotonAltoTemplario extends VistaBotonInteractuable {
	private AltoTemplario representado;

	public VistaBotonAltoTemplario(AltoTemplario templario){
		super();
		this.setText("AlT");
		this.representado = templario;
	}

    @Override
    public VistaAcciones getVistaDeAcciones(Juego modelo) {
    	VistaAccionesAltoTemplario vistaAcciones = new VistaAccionesAltoTemplario(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}

