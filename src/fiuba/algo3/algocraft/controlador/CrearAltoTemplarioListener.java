


package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearAltoTemplarioListener implements ActionListener {
	Controlador controlador;
	public CrearAltoTemplarioListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		controlador.crearAltoTemplario();
	}

}

