package fiuba.algo3.algocraft.controlador.operacionesDeVentana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.ventanas.ingresoJugadores.IngresoJugadoresVista;
import fiuba.algo3.algocraft.vista.observadores.juego.VistaJuego;

public class NuevoJuegoListener implements ActionListener {
    private Juego modelo;
    private VistaJuego vista;
	
	public NuevoJuegoListener(Juego modelo, VistaJuego vista){
        this.modelo = modelo;
        this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new IngresoJugadoresVista(this.modelo, this.vista);
	}

}
