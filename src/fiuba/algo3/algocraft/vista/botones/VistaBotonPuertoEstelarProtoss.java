package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.vista.VistaAccionesPuertoEstelar;
import fiuba.algo3.algocraft.vista.VistaAccionesPuertoEstelarProtoss;

public class VistaBotonPuertoEstelarProtoss extends VistaBotonInteractuable {
	private PuertoEstelarProtoss representador;

	public VistaBotonPuertoEstelarProtoss(PuertoEstelarProtoss puerto){
		super();
		this.setText("PEP");
		this.representador = puerto;
	}

    @Override
    public VistaAccionesPuertoEstelarProtoss getVistaDeAcciones(Juego modelo) {
    	VistaAccionesPuertoEstelarProtoss vistaAcciones = new VistaAccionesPuertoEstelarProtoss(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
