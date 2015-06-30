package fiuba.algo3.algocraft.vista.acciones;

import fiuba.algo3.algocraft.controlador.NaveTransporteInsertarUnidadListener;
import fiuba.algo3.algocraft.controlador.NaveTransporteRemoverUnidadListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.NaveTransporte;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class VistaAccionesNaveTransporte extends VistaAccionesUnidad {
	public VistaAccionesNaveTransporte(Juego modelo, NaveTransporte representado) {
		super(modelo, representado);
		JButton btnInsertarUnidad = new JButton("Insertar Unidad");
        btnInsertarUnidad.addActionListener(new NaveTransporteInsertarUnidadListener(modelo, representado));
		GridBagConstraints gbc_btnInsertarUnidad = new GridBagConstraints();
		gbc_btnInsertarUnidad.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsertarUnidad.gridx = 0;
		gbc_btnInsertarUnidad.gridy = 3;
		add(btnInsertarUnidad, gbc_btnInsertarUnidad);
		this.habilitarBoton(btnInsertarUnidad, representado);
		
		JButton btnSacarUnidad = new JButton("Sacar Unidad");
        btnSacarUnidad.addActionListener(new NaveTransporteRemoverUnidadListener(modelo, representado));
		GridBagConstraints gbc_btnSacarUnidad = new GridBagConstraints();
		gbc_btnSacarUnidad.insets = new Insets(0, 0, 5, 0);
		gbc_btnSacarUnidad.gridx = 0;
		gbc_btnSacarUnidad.gridy = 4;
		add(btnSacarUnidad, gbc_btnSacarUnidad);
		this.habilitarBoton(btnSacarUnidad, representado);
	}
}