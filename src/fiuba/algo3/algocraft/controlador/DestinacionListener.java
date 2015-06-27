package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class DestinacionListener implements ActionListener {
	private Juego modelo;

	public DestinacionListener(Juego modelo){
		this.modelo = modelo;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		/*try {
			controlador.ponerDestinacion();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
