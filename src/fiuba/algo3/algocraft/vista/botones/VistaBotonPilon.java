package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Pilon;


public class VistaBotonPilon extends VistaBotonInteractuable {
	private Pilon representador;

	public VistaBotonPilon(Pilon pilon){
		super();
		this.setText("Pi");
		this.representador = pilon;
	}
}