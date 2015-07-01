package fiuba.algo3.algocraft.vista.acciones;

import fiuba.algo3.algocraft.controlador.accionesDeUnidades.NaveTransporteInsertarUnidadListener;
import fiuba.algo3.algocraft.controlador.accionesDeUnidades.NaveTransporteSacarUnidadesComboBoxListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.NaveTransporte;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;

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

        JLabel label = new JLabel();
        GridBagConstraints lblgbc = new GridBagConstraints();
        lblgbc.insets = new Insets(0, 0, 5, 0);
        lblgbc.gridx = 0;
        lblgbc.gridy = 4;
        label.setText("Sacar Unidad:");
        this.add(label, lblgbc);

        JComboBox<Unidad> cbUnidadesContenidas = new JComboBox<Unidad>();
        for (Unidad unidad: representado.getUnidades()) {
            cbUnidadesContenidas.addItem(unidad);
        }
        cbUnidadesContenidas.addActionListener(new NaveTransporteSacarUnidadesComboBoxListener(modelo, representado));
        GridBagConstraints gbca = new GridBagConstraints();
        gbca.insets = new Insets(0, 0, 5, 0);
        gbca.gridx = 0;
        gbca.gridy = 5;
        add(cbUnidadesContenidas, gbca);
	}
}