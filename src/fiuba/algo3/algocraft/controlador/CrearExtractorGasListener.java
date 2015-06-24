package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearExtractorGasListener implements ActionListener {
	private Controlador controlador;
	public CrearExtractorGasListener(Controlador controlador) {
		this.controlador = controlador;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		controlador.crearExtractorGas();

}

}
