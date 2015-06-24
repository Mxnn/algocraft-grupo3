package fiuba.algo3.algocraft.vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.CrearCreadorUnidadesMagicasListener;
import fiuba.algo3.algocraft.controlador.CrearMarineListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class VistaAccionesBarraca extends VistaAcciones {


	public VistaAccionesBarraca(Controlador controlador) {
		super(controlador);
		
		JButton btnCrearMarines = new JButton("Crear Marines");
		btnCrearMarines.addActionListener(new CrearMarineListener(controlador));
		GridBagConstraints gbc_btnCrearMarines = new GridBagConstraints();
		gbc_btnCrearMarines.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearMarines.gridx = 0;
		gbc_btnCrearMarines.gridy = 2;
		add(btnCrearMarines, gbc_btnCrearMarines);
		
		
	}

}

