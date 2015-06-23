package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.IngresoJugadoresVista;

public class NuevoJuegoListener implements ActionListener {
    private Juego modelo;
	
	public NuevoJuegoListener(Juego modelo){
        this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new IngresoJugadoresVista(this.modelo);
	}

}
