package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.NaveTransporteProtoss;
import fiuba.algo3.algocraft.vista.VistaAccionesNaveTransporte;

public class VistaBotonNaveTransporteProtoss extends VistaBotonRepresentante {

	public VistaBotonNaveTransporteProtoss(NaveTransporteProtoss nave){
		super(nave);
		this.setText("NTP");
	}

    @Override
    public VistaAccionesNaveTransporte getVistaDeAcciones(Juego modelo) {
    	VistaAccionesNaveTransporte vistaAcciones = new VistaAccionesNaveTransporte(modelo, (NaveTransporteProtoss) this.elementoRepresentado);
    	this.vistaAcciones = vistaAcciones;
    	return vistaAcciones;
    }
}