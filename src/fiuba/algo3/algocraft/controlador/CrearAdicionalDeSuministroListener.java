package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearAdicionalDeSuministroListener implements ActionListener {
	Controlador controlador;
	public CrearAdicionalDeSuministroListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		controlador.crearAdicionalSuministros();
	}

}
