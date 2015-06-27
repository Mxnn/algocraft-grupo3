package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.NaveTransporteProtoss;
import fiuba.algo3.algocraft.vista.VistaAccionesNaveTransporte;

public class VistaBotonNaveTransporteProtoss extends VistaBotonInteractuable {
	private NaveTransporteProtoss representado;

	public VistaBotonNaveTransporteProtoss(NaveTransporteProtoss nave){
		super();
		this.setText("NTP");
		this.representado = nave;
	}

    @Override
    public VistaAccionesNaveTransporte getVistaDeAcciones(Juego modelo) {
    	VistaAccionesNaveTransporte vistaAcciones = new VistaAccionesNaveTransporte(modelo);
    	this.vistaAcciones = vistaAcciones;
    	return vistaAcciones;
    }
}