package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;

public class DestinacionListener implements ActionListener {
	private Juego modelo;
	private ControladorAccionPorTurno controladorMover;
	private Coordenada ubicacion;

	public DestinacionListener(Juego modelo, Coordenada ubicacionParcela){
		this.modelo = modelo;
		this.ubicacion = ubicacionParcela;
		this.controladorMover = ControladorAccionPorTurno.createInstance();
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
			this.controladorMover.ejecutarAccionDeTurno(modelo.getMapa(), ubicacion);
		} catch (ExcepcionEnergiaInsuficiente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			controlador.ponerDestinacion();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
