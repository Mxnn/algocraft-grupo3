package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCreadorUnidadesAvanzadasListener implements ActionListener {
	Controlador controlador;
	public CrearCreadorUnidadesAvanzadasListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		controlador.crearCreadorUnidadesAvanzadas();
	}
}
