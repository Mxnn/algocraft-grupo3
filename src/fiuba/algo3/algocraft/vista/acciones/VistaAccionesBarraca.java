package fiuba.algo3.algocraft.vista.acciones;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.CrearMarineListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;

public class VistaAccionesBarraca extends VistaAccionesInteractuable {

    //Por referencia el modelo
	public VistaAccionesBarraca(Juego modelo, Barraca representado) {
		super(modelo);

		JButton btnCrearMarines = new JButton("Crear Marine");
		btnCrearMarines.addActionListener(new CrearMarineListener(modelo, representado));
		GridBagConstraints gbc_btnCrearMarines = new GridBagConstraints();
		gbc_btnCrearMarines.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearMarines.gridx = 0;
		gbc_btnCrearMarines.gridy = 3;
		add(btnCrearMarines, gbc_btnCrearMarines);
		this.habilitarBoton(btnCrearMarines, representado);
	}

}

