
package fiuba.algo3.algocraft.vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.CrearCreadorUnidadesMagicasListener;
import fiuba.algo3.algocraft.controlador.CrearDragonListener;
import fiuba.algo3.algocraft.controlador.CrearMarineListener;
import fiuba.algo3.algocraft.controlador.CrearZealotListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class  VistaAccionesAcceso  extends VistaAcciones {


	public VistaAccionesAcceso(Controlador controlador) {
		super(controlador);
		
		JButton btnCrearZealot = new JButton("Crear Zealot");
		btnCrearZealot.addActionListener(new CrearZealotListener(controlador));
		GridBagConstraints gbc_btnCrearZealot = new GridBagConstraints();
		gbc_btnCrearZealot.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearZealot.gridx = 0;
		gbc_btnCrearZealot.gridy = 2;
		add(btnCrearZealot, gbc_btnCrearZealot);
		

		JButton btnCrearDragon = new JButton("Crear Dragon");
		btnCrearDragon.addActionListener(new CrearDragonListener(controlador));
		GridBagConstraints gbc_btnCrearDragon = new GridBagConstraints();
		gbc_btnCrearDragon.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearDragon.gridx = 0;
		gbc_btnCrearDragon.gridy = 3;
		add(btnCrearDragon, gbc_btnCrearDragon);		
	}

}