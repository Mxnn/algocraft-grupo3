package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;

public class DestinacionListener implements ActionListener {
	Controlador controlador;
	public DestinacionListener(Controlador elControlador){
		this.controlador=elControlador;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			controlador.ponerDestinacion();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
