package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.vista.VistaAccionesBarraca;

public class VistaBotonBarraca extends VistaBotonInteractuable {
	private Barraca representador;

	public VistaBotonBarraca(Barraca barraca){
		super();
		this.setText("Ba");
		this.representador = barraca;
	}

    @Override
    public VistaAccionesBarraca getVistaDeAcciones(Juego modelo) {
    	VistaAccionesBarraca vistaAcciones = new VistaAccionesBarraca(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
