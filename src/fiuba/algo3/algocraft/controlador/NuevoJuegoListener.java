package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.vista.IngresoJugadoresVista;

public class NuevoJuegoListener implements ActionListener {
	Controlador controlador;
	
	public NuevoJuegoListener(Controlador elControlador){
		this.controlador = elControlador;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new IngresoJugadoresVista();
	}

}
