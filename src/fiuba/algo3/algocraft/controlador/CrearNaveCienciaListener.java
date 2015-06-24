
package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearNaveCienciaListener implements ActionListener {
	Controlador controlador;
	public CrearNaveCienciaListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		controlador.crearNaveCiencia();
	}

}
