package fiuba.algo3.algocraft.vista.acciones.unidades;

import fiuba.algo3.algocraft.controlador.accionesDeUnidades.AtacarListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class VistaAccionesUnidadAgresora extends VistaAccionesUnidad {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VistaAccionesUnidadAgresora(Juego modelo, UnidadAgresora representado) {
		super(modelo, representado);
		this.setTitulo("Unidad Agresora");
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new AtacarListener(representado));
		GridBagConstraints gbc_btnAtacar = new GridBagConstraints();
		gbc_btnAtacar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAtacar.gridx = 0;
		gbc_btnAtacar.gridy = 3;
		add(btnAtacar, gbc_btnAtacar);
		this.habilitarBoton(btnAtacar, representado);
		
	}

}
