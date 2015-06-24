package fiuba.algo3.algocraft.vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class VistaAccionesFabrica extends VistaAcciones {


	public VistaAccionesFabrica(Juego modelo, VistaBarraLateral barra, Controlador controlador) {
		super(modelo, barra, controlador);
		
		JButton btnCrearGolliat = new JButton("Crear Golliat");
		GridBagConstraints gbc_btnCrearGolliat = new GridBagConstraints();
		gbc_btnCrearGolliat.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearGolliat.gridx = 0;
		gbc_btnCrearGolliat.gridy = 2;
		add(btnCrearGolliat, gbc_btnCrearGolliat);
		
		
	}

}

