package fiuba.algo3.algocraft.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.controlador.Controlador;

public class CreadorUnidadesMagicasListener implements ActionListener {
	Controlador controlador;
	public CreadorUnidadesMagicasListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		controlador.crearCreadorUnidadesMagicas();
	}

}
