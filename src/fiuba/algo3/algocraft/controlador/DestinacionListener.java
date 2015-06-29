package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;

public class DestinacionListener implements ActionListener {
//	private Juego modelo;
	private ControladorMover controladorMover;
	private Coordenada ubicacion;

	public DestinacionListener(Coordenada ubicacionParcela){
//		this.modelo = modelo;
		this.ubicacion = ubicacionParcela;
		this.controladorMover = ControladorMover.createInstance();
	}

	public void actionPerformed(ActionEvent arg0) {
		this.controladorMover.mover(this.ubicacion);
		/*try {
			controlador.ponerDestinacion();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
