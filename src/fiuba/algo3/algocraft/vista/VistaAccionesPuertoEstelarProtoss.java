
package fiuba.algo3.algocraft.vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.CrearCreadorUnidadesMagicasListener;
import fiuba.algo3.algocraft.controlador.CrearMarineListener;
import fiuba.algo3.algocraft.controlador.CrearNaveTransporteProtossListener;
import fiuba.algo3.algocraft.controlador.CrearScoutListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class VistaAccionesPuertoEstelarProtoss  extends VistaAcciones {


	public VistaAccionesPuertoEstelarProtoss(Controlador controlador) {
		super(controlador);
		
		JButton btnCrearScout = new JButton("Crear Scout");
		btnCrearScout.addActionListener(new CrearScoutListener(controlador));
		GridBagConstraints gbc_btnCrearScout = new GridBagConstraints();
		gbc_btnCrearScout.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearScout.gridx = 0;
		gbc_btnCrearScout.gridy = 2;
		add(btnCrearScout, gbc_btnCrearScout);
		

		JButton btnCrearNaveDeTransporte = new JButton("Crear Nave de transporte");
		btnCrearNaveDeTransporte.addActionListener(new CrearNaveTransporteProtossListener(controlador));
		GridBagConstraints gbc_btnCrearNaveDeTransporte = new GridBagConstraints();
		gbc_btnCrearNaveDeTransporte.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearNaveDeTransporte.gridx = 0;
		gbc_btnCrearNaveDeTransporte.gridy = 3;
		add(btnCrearNaveDeTransporte, gbc_btnCrearNaveDeTransporte);		
	}

}