package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearDepositoDeSumnistroListener implements ActionListener {
	Controlador controlador;
	public CrearDepositoDeSumnistroListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		controlador.clickYCrearDeposito();
	}

}
