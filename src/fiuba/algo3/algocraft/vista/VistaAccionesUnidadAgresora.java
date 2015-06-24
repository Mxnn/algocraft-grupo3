package fiuba.algo3.algocraft.vista;
import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.juego.Juego;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class VistaAccionesUnidadAgresora extends VistaAccionesUnidad{
	public VistaAccionesUnidadAgresora(Controlador controlador) {

		super(controlador);
		this.setTitulo("Unidad Agresora");
		
		JButton btnAtacar = new JButton("Atacar");
		GridBagConstraints gbc_btnAtacar = new GridBagConstraints();
		gbc_btnAtacar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAtacar.gridx = 0;
		gbc_btnAtacar.gridy = 2;
		add(btnAtacar, gbc_btnAtacar);
		
	}

}
