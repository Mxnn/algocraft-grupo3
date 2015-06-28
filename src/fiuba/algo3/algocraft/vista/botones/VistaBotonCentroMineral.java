package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.CentroDeMineral;

public class VistaBotonCentroMineral extends VistaBotonRepresentante {
	public VistaBotonCentroMineral(CentroDeMineral centroDeMineral){
		super(centroDeMineral);
		this.setText("CM");
	}
}
