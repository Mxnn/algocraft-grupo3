package fiuba.algo3.algocraft.vista.acciones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VistaAccionesNaveCiencia extends VistaAccionesUnidad {

	public VistaAccionesNaveCiencia(Juego modelo, NaveCiencia representado) {
		super(modelo, representado);
		
		JButton btnEmp = new JButton("EMP");
		GridBagConstraints gbc_btnEmp = new GridBagConstraints();
		gbc_btnEmp.insets = new Insets(0, 0, 5, 0);
		gbc_btnEmp.gridx = 0;
		gbc_btnEmp.gridy = 3;
		add(btnEmp, gbc_btnEmp);
		this.habilitarBoton(btnEmp, representado);
		
		JButton btnRadiacion = new JButton("Radiacion");
		GridBagConstraints gbc_btnRadiacion = new GridBagConstraints();
		gbc_btnRadiacion.insets = new Insets(0, 0, 5, 0);
		gbc_btnRadiacion.gridx = 0;
		gbc_btnRadiacion.gridy = 4;
		add(btnRadiacion, gbc_btnRadiacion);
		this.habilitarBoton(btnRadiacion, representado);
	}
}
