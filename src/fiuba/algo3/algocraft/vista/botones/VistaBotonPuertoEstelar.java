package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesPuertoEstelar;

public class VistaBotonPuertoEstelar extends VistaBotonRepresentante {

	public VistaBotonPuertoEstelar(PuertoEstelar puertoEstelar){
		super(puertoEstelar);
		this.setText("PET");
	}

    @Override
    public VistaAccionesPuertoEstelar getVistaDeAcciones(Juego modelo) {
    	VistaAccionesPuertoEstelar vistaAcciones = new VistaAccionesPuertoEstelar(modelo, (PuertoEstelar) this.elementoRepresentado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
