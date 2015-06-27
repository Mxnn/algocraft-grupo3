package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveTransporteTerran;
import fiuba.algo3.algocraft.vista.VistaAccionesNaveTransporte;

public class VistaBotonNaveTransporteTerran extends VistaBotonRepresentante {

	public VistaBotonNaveTransporteTerran(NaveTransporteTerran nave){
		super(nave);
		this.setText("NTT");
	}

    @Override
    public VistaAccionesNaveTransporte getVistaDeAcciones(Juego modelo) {
    	VistaAccionesNaveTransporte vistaAcciones = new VistaAccionesNaveTransporte(modelo, (NaveTransporteTerran) this.elementoRepresentado);
    	this.vistaAcciones = vistaAcciones;
    	return vistaAcciones;
    }
}
