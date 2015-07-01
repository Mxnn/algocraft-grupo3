package fiuba.algo3.algocraft.controlador.accionesDeUnidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.controlador.comandos.AccionPorTurnoListener;
import fiuba.algo3.algocraft.controlador.comandos.ComandoMover;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class MoverListener implements ActionListener {
//    private Juego modelo;
    private Unidad representado;
	private AccionPorTurnoListener controladorMover;

	public MoverListener(Unidad representado){
//		this.modelo = modelo;
		this.representado = representado;
		this.controladorMover = AccionPorTurnoListener.createInstance();
	}

	public void actionPerformed(ActionEvent arg0) {
//			this.representado.moverHasta(new Coordenada(13,13));
		this.controladorMover.setUnidad(this.representado);
		this.controladorMover.setComando(new ComandoMover());
		
	}
}
