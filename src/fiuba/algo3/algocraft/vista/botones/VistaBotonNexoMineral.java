package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.NexoMineral;


public class VistaBotonNexoMineral extends VistaBotonInteractuable {
	private NexoMineral representador;

	public VistaBotonNexoMineral(NexoMineral nexoMineral){
		super();
		this.setText("NM");
		this.representador = nexoMineral;
	}
}
