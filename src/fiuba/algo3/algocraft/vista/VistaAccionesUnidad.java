package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.controlador.MoverListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VistaAccionesUnidad extends VistaAcciones {
	public VistaAccionesUnidad(Juego modelo) {
		super(modelo);
		JButton btnMover = new JButton("Mover");
		btnMover.addActionListener(new MoverListener(modelo));
		GridBagConstraints gbc_btnMover = new GridBagConstraints();
		gbc_btnMover.insets = new Insets(0, 0, 5, 0);
		gbc_btnMover.gridx = 0;
		gbc_btnMover.gridy = 1;
		add(btnMover, gbc_btnMover);
	}

}
