package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParcelaListener implements ActionListener {
	Controlador controlador;
	int x;
	int y;
	public ParcelaListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		controlador.clickEnParcela(this.x, this.y);
	}
	public void setCoordenadasBoton(int x2, int y2) {
		this.x = x2;
		this.y = y2;
		
	}
 
}
