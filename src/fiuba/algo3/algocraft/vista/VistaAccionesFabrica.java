package fiuba.algo3.algocraft.vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.CrearGolliatListener;
import fiuba.algo3.algocraft.controlador.CrearMarineListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class VistaAccionesFabrica extends VistaAcciones {


	public VistaAccionesFabrica(Controlador controlador) {
		super(controlador);
		
		JButton btnCrearGolliat = new JButton("Crear Golliat");
		btnCrearGolliat.addActionListener(new CrearGolliatListener(controlador));	
		GridBagConstraints gbc_btnCrearGolliat = new GridBagConstraints();
		gbc_btnCrearGolliat.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearGolliat.gridx = 0;
		gbc_btnCrearGolliat.gridy = 2;
		add(btnCrearGolliat, gbc_btnCrearGolliat);
		
		
	}

}

