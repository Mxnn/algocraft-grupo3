package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesBarraca;

public class VistaBotonBarraca extends VistaBotonRepresentante {

	public VistaBotonBarraca(Barraca barraca){
		super(barraca);
		this.setText("Ba");
	}

    @Override
    public VistaAccionesBarraca getVistaDeAcciones(Juego modelo) {
    	VistaAccionesBarraca vistaAcciones = new VistaAccionesBarraca(modelo,(Barraca) this.elementoRepresentado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
