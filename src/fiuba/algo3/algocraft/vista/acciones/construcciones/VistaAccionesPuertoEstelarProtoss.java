package fiuba.algo3.algocraft.vista.acciones.construcciones;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.creadoresDeInteractuables.CrearNaveTransporteProtossListener;
import fiuba.algo3.algocraft.controlador.creadoresDeInteractuables.CrearScoutListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

public class VistaAccionesPuertoEstelarProtoss  extends VistaAccionesInteractuable {

	public VistaAccionesPuertoEstelarProtoss(Juego modelo, PuertoEstelarProtoss representado) {
		super(modelo, representado);
		
		JButton btnCrearScout = new JButton("Crear Scout");
		btnCrearScout.addActionListener(new CrearScoutListener(modelo, representado));
		GridBagConstraints gbc_btnCrearScout = new GridBagConstraints();
		gbc_btnCrearScout.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearScout.gridx = 0;
		gbc_btnCrearScout.gridy = 3;
		add(btnCrearScout, gbc_btnCrearScout);
		this.habilitarBoton(btnCrearScout, representado);

		JButton btnCrearNaveDeTransporte = new JButton("Crear Nave de transporte");
		btnCrearNaveDeTransporte.addActionListener(new CrearNaveTransporteProtossListener(modelo, representado));
		GridBagConstraints gbc_btnCrearNaveDeTransporte = new GridBagConstraints();
		gbc_btnCrearNaveDeTransporte.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearNaveDeTransporte.gridx = 0;
		gbc_btnCrearNaveDeTransporte.gridy = 4;
		add(btnCrearNaveDeTransporte, gbc_btnCrearNaveDeTransporte);
		this.habilitarBoton(btnCrearNaveDeTransporte, representado);
	}

}