package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Refineria;


public class VistaBotonRefineria extends VistaBotonInteractuable {
	private Refineria representador;

	public VistaBotonRefineria(Refineria refineria){
		super();
		this.setText("Re");
		this.representador = refineria;
	}
}
