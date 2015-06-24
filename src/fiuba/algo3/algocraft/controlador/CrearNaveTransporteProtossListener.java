

package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearNaveTransporteProtossListener implements ActionListener {
	Controlador controlador;
	public CrearNaveTransporteProtossListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		controlador.crearNaveTransporteProtoss();
	}

}
