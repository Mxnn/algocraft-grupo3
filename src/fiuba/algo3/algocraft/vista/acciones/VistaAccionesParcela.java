package fiuba.algo3.algocraft.vista.acciones;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.DestinacionListener;
import fiuba.algo3.algocraft.controlador.ObjetivoListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;

public class VistaAccionesParcela extends VistaAcciones {

	public VistaAccionesParcela(Juego modelo, Coordenada ubicacionParcela) {
		super(modelo);
		
//		JButton btnDestinacion = new JButton("Destinacion");
//		btnDestinacion.addActionListener(new DestinacionListener(modelo,ubicacionParcela));
//		GridBagConstraints gbc_btnDestinacion = new GridBagConstraints();
//		gbc_btnDestinacion.insets = new Insets(0, 0, 5, 0);
//		gbc_btnDestinacion.gridx = 0;
//		gbc_btnDestinacion.gridy = 7;
//		add(btnDestinacion, gbc_btnDestinacion);
		
		JButton btnObjetivo = new JButton("Objetivo");
		btnObjetivo.addActionListener(new ObjetivoListener(modelo,ubicacionParcela));
		GridBagConstraints gbc_btnObjetivo = new GridBagConstraints();
		gbc_btnObjetivo.insets = new Insets(0, 0, 5, 0);
		gbc_btnObjetivo.gridx = 0;
		gbc_btnObjetivo.gridy = 7;
		add(btnObjetivo, gbc_btnObjetivo);
	}

}
