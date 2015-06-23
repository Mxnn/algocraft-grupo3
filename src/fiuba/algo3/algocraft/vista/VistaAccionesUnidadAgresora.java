package fiuba.algo3.algocraft.vista;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class VistaAccionesUnidadAgresora extends VistaAccionesUnidad{
	public VistaAccionesUnidadAgresora() {
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
//		setLayout(gridBagLayout);
		super();
		this.setTitulo("Unidad Agresora");
		
		JButton btnAtacar = new JButton("Atacar");
		GridBagConstraints gbc_btnAtacar = new GridBagConstraints();
		gbc_btnAtacar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAtacar.gridx = 0;
		gbc_btnAtacar.gridy = 2;
		add(btnAtacar, gbc_btnAtacar);
		
	}

}
