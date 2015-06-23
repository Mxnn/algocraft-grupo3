package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.vista.VistaJuego;

public class ParcelaListener implements ActionListener {
	Controlador controlador;
	int x;
	int y;

	public ParcelaListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		//sacar esta excepcion despues
		try {
			controlador.clickEnParcela(this.x, this.y);
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setCoordenadasBoton(int x2, int y2) {
		this.x = x2;
		this.y = y2;
		
	}
	

 
}
