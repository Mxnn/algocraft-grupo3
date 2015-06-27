package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearEspectroListener implements ActionListener {
    private Juego modelo;

	public CrearEspectroListener(Juego modelo){
		this.modelo = modelo;
	}

	public void actionPerformed(ActionEvent arg0) {
		//controlador.crearEspectro();
	}
}
