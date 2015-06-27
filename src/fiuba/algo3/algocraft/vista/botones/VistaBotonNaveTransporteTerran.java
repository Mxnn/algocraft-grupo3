package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveTransporteTerran;
import fiuba.algo3.algocraft.vista.VistaAccionesNaveTransporte;

public class VistaBotonNaveTransporteTerran extends VistaBotonInteractuable {
	private NaveTransporteTerran representado;

	public VistaBotonNaveTransporteTerran(NaveTransporteTerran nave){
		super();
		this.setText("NTT");
		this.representado = nave;
	}

    @Override
    public VistaAccionesNaveTransporte getVistaDeAcciones(Juego modelo) {
    	VistaAccionesNaveTransporte vistaAcciones = new VistaAccionesNaveTransporte(modelo, this.representado);
    	this.vistaAcciones = vistaAcciones;
    	return vistaAcciones;
    }
}
