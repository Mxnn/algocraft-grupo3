package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Asimilador;

public class VistaBotonAsimilador extends VistaBotonInteractuable {
	private Asimilador representador;

	public VistaBotonAsimilador(Asimilador asimilador){
		super();
		this.setText("As");
		this.representador = asimilador;
	}
}
