package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VistaAccionesAltoTemplario extends VistaAccionesUnidad {

		public VistaAccionesAltoTemplario(Juego modelo, VistaBarraLateral barra) {
			super(modelo, barra);
			
			JButton btnAlucinacion = new JButton("Alucinacion");
			GridBagConstraints gbc_btnEmp = new GridBagConstraints();
			gbc_btnEmp.insets = new Insets(0, 0, 5, 0);
			gbc_btnEmp.gridx = 0;
			gbc_btnEmp.gridy = 2;
			add(btnAlucinacion, gbc_btnEmp);
			
			JButton btnTormenta = new JButton("Tormenta Psionica");
			GridBagConstraints gbc_btnRadiacion = new GridBagConstraints();
			gbc_btnRadiacion.insets = new Insets(0, 0, 5, 0);
			gbc_btnRadiacion.gridx = 0;
			gbc_btnRadiacion.gridy = 3;
			add(btnTormenta, gbc_btnRadiacion);
			
		}

}
