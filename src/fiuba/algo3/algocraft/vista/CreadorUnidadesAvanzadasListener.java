package fiuba.algo3.algocraft.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.controlador.Controlador;

public class CreadorUnidadesAvanzadasListener implements ActionListener {
	Controlador controlador;
	public CreadorUnidadesAvanzadasListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		controlador.crearCreadorUnidadesAvanzadas();
	}
}
