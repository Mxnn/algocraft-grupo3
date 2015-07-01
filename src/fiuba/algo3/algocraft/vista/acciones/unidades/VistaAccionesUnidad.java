package fiuba.algo3.algocraft.vista.acciones.unidades;

import fiuba.algo3.algocraft.controlador.accionesDeUnidades.MoverListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public abstract class VistaAccionesUnidad extends VistaAccionesInteractuable {
	public VistaAccionesUnidad(Juego modelo, Unidad representado) {
		super(modelo, representado);
		JButton btnMover = new JButton("Mover");
		btnMover.addActionListener(new MoverListener(representado));
		GridBagConstraints gbc_btnMover = new GridBagConstraints();
		gbc_btnMover.insets = new Insets(0, 0, 5, 0);
		gbc_btnMover.gridx = 0;
		gbc_btnMover.gridy = 2;
		add(btnMover, gbc_btnMover);
		this.habilitarBoton(btnMover, representado);
	}
}
