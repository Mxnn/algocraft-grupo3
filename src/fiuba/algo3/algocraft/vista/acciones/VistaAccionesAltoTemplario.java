package fiuba.algo3.algocraft.vista.acciones;

import fiuba.algo3.algocraft.controlador.ataques.LanzarAlucinacionListener;
import fiuba.algo3.algocraft.controlador.ataques.LanzarTormentaPsionicaListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VistaAccionesAltoTemplario extends VistaAccionesUnidad {
	public VistaAccionesAltoTemplario(Juego modelo, AltoTemplario representado) {
		super(modelo, representado);

		JButton btnAlucinacion = new JButton("Alucinacion");
		btnAlucinacion.addActionListener(new LanzarAlucinacionListener(representado));
		GridBagConstraints gbc_btnEmp = new GridBagConstraints();
		gbc_btnEmp.insets = new Insets(0, 0, 5, 0);
		gbc_btnEmp.gridx = 0;
		gbc_btnEmp.gridy = 3;
		add(btnAlucinacion, gbc_btnEmp);
		this.habilitarBoton(btnAlucinacion, representado);

		JButton btnTormenta = new JButton("Tormenta Psionica");
		btnTormenta.addActionListener(new LanzarTormentaPsionicaListener(representado));
		GridBagConstraints gbc_btnRadiacion = new GridBagConstraints();
		gbc_btnRadiacion.insets = new Insets(0, 0, 5, 0);
		gbc_btnRadiacion.gridx = 0;
		gbc_btnRadiacion.gridy = 4;
		add(btnTormenta, gbc_btnRadiacion);
		this.habilitarBoton(btnTormenta, representado);
	}
}
