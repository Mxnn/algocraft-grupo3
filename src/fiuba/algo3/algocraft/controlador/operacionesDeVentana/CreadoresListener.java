package fiuba.algo3.algocraft.controlador.operacionesDeVentana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fiuba.algo3.algocraft.vista.ventanas.creadores.CreadoresVista;
public class CreadoresListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		new CreadoresVista();

	}

}
