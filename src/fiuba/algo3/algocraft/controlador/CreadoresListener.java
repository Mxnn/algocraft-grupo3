package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.CreadoresVista;
import fiuba.algo3.algocraft.vista.IngresoJugadoresVista;
import fiuba.algo3.algocraft.vista.VistaJuego;

public class CreadoresListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		new CreadoresVista();

	}

}
