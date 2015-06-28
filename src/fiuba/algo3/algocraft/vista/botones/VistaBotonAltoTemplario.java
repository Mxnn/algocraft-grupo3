package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.vista.acciones.VistaAcciones;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesAltoTemplario;

public class VistaBotonAltoTemplario extends VistaBotonRepresentante {

	public VistaBotonAltoTemplario(AltoTemplario templario){
		super(templario);
		this.setText("AlT");
	}

    @Override
    public VistaAcciones getVistaDeAcciones(Juego modelo) {
    	VistaAccionesAltoTemplario vistaAcciones = new VistaAccionesAltoTemplario(modelo, (AltoTemplario) this.elementoRepresentado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}

