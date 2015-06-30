package fiuba.algo3.algocraft.vista.acciones;

import fiuba.algo3.algocraft.controlador.NaveTransporteInsertarUnidadListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.NaveTransporte;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class VistaAccionesNaveTransporte extends VistaAccionesUnidad {
	private Interactuable representado;

	public VistaAccionesNaveTransporte(Juego modelo, NaveTransporte representado) {
		super(modelo, representado);
		this.representado = representado;
		JButton btnInsertarUnidad = new JButton("Insertar Unidad");
        btnInsertarUnidad.addActionListener(new NaveTransporteInsertarUnidadListener(modelo, representado));
		GridBagConstraints gbc_btnInsertarUnidad = new GridBagConstraints();
		gbc_btnInsertarUnidad.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsertarUnidad.gridx = 0;
		gbc_btnInsertarUnidad.gridy = 3;
		add(btnInsertarUnidad, gbc_btnInsertarUnidad);
		this.habilitarBoton(btnInsertarUnidad, representado);
		
//		JButton btnSacarUnidad = new JButton("Sacar Unidad");
//		GridBagConstraints gbc_btnSacarUnidad = new GridBagConstraints();
//		gbc_btnSacarUnidad.insets = new Insets(0, 0, 5, 0);
//		gbc_btnSacarUnidad.gridx = 0;
//		gbc_btnSacarUnidad.gridy = 4;
//		add(btnSacarUnidad, gbc_btnSacarUnidad);
//		this.habilitarBoton(btnSacarUnidad, representado);
		
		JButton btnSacarUnidad = new JButton("U");
		GridBagConstraints gbc_btnSacarUnidad = new GridBagConstraints();
		gbc_btnSacarUnidad.insets = new Insets(0, 0, 5, 0);
		gbc_btnSacarUnidad.gridx = 0;
		gbc_btnSacarUnidad.gridy = 4;
		add(btnSacarUnidad, gbc_btnSacarUnidad);
		this.habilitarBoton(btnSacarUnidad, representado);
		
//		JButton btnSacarUnidad2 = new JButton("U");
//		GridBagConstraints gbc_btnSacarUnidad2 = new GridBagConstraints();
//		gbc_btnSacarUnidad2.insets = new Insets(0, 0, 5, 0);
//		gbc_btnSacarUnidad2.gridx = 1;
//		gbc_btnSacarUnidad2.gridy = 4;
//		add(btnSacarUnidad2, gbc_btnSacarUnidad2);
//		this.habilitarBoton(btnSacarUnidad2, representado);
//		
//		JButton btnSacarUnidad3 = new JButton("U");
//		GridBagConstraints gbc_btnSacarUnidad3 = new GridBagConstraints();
//		gbc_btnSacarUnidad3.insets = new Insets(0, 0, 5, 0);
//		gbc_btnSacarUnidad3.gridx = 2;
//		gbc_btnSacarUnidad3.gridy = 4;
//		add(btnSacarUnidad3, gbc_btnSacarUnidad3);
//		this.habilitarBoton(btnSacarUnidad3, representado);
//		
//		JButton btnSacarUnidad3 = new JButton("U");
//		GridBagConstraints gbc_btnSacarUnidad3 = new GridBagConstraints();
//		gbc_btnSacarUnidad3.insets = new Insets(0, 0, 5, 0);
//		gbc_btnSacarUnidad3.gridx = 2;
//		gbc_btnSacarUnidad3.gridy = 4;
//		add(btnSacarUnidad3, gbc_btnSacarUnidad3);
//		this.habilitarBoton(btnSacarUnidad3, representado);
	}
	
	public void setBotonesSacar(int capacidad){
		for(int i=0; i<capacidad; i++){
			JButton btnSacarUnidad = new JButton("U");
			btnSacarUnidad.setSize(10, 20);
			GridBagConstraints gbc_btnSacarUnidad = new GridBagConstraints();
			gbc_btnSacarUnidad.insets = new Insets(0, 0, 0, 0);
			gbc_btnSacarUnidad.gridx = i;
			gbc_btnSacarUnidad.gridy = 4;
			this.add(btnSacarUnidad, gbc_btnSacarUnidad);
			this.habilitarBoton(btnSacarUnidad, representado);
		}
	}

}