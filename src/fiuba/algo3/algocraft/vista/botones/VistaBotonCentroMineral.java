package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.CentroDeMineral;

public class VistaBotonCentroMineral extends VistaBotonInteractuable {
	private CentroDeMineral representador;

	public VistaBotonCentroMineral(CentroDeMineral centroDeMineral){
		super();
		this.setText("CM");
		this.representador = centroDeMineral;
	}
}
