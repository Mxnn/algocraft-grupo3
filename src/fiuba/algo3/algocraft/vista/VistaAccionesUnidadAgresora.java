package fiuba.algo3.algocraft.vista;
import fiuba.algo3.algocraft.modelo.juego.Juego;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class VistaAccionesUnidadAgresora extends VistaAccionesUnidad{
	public VistaAccionesUnidadAgresora(Juego modelo, VistaBarraLateral barra) {
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
//		setLayout(gridBagLayout);
		super(modelo, barra);
		this.setTitulo("Unidad Agresora");
		
		JButton btnAtacar = new JButton("Atacar");
		GridBagConstraints gbc_btnAtacar = new GridBagConstraints();
		gbc_btnAtacar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAtacar.gridx = 0;
		gbc_btnAtacar.gridy = 2;
		add(btnAtacar, gbc_btnAtacar);
		
	}

}
