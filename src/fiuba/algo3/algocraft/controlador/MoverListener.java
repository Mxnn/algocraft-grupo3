package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class MoverListener implements ActionListener {
//    private Juego modelo;
    private Unidad representado;
	private ControladorMover controladorMover;

	public MoverListener(Juego modelo,Unidad representado){
//		this.modelo = modelo;
		this.representado = representado;
		this.controladorMover = ControladorMover.createInstance(modelo);
	}

	public void actionPerformed(ActionEvent arg0) {
//			this.representado.moverHasta(new Coordenada(13,13));
		this.controladorMover.setUnidad(this.representado);
		
	}
}
