package fiuba.algo3.algocraft.vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class VistaAccionesBarraca extends VistaAcciones {


	public VistaAccionesBarraca(Juego modelo, VistaBarraLateral barra, Controlador controlador) {
		super(modelo, barra, controlador);
		
		JButton btnCrearMarines = new JButton("Crear Marines");
		GridBagConstraints gbc_btnEmp = new GridBagConstraints();
		gbc_btnEmp.insets = new Insets(0, 0, 5, 0);
		gbc_btnEmp.gridx = 0;
		gbc_btnEmp.gridy = 2;
		add(btnCrearMarines, gbc_btnEmp);
		
		
	}

}

