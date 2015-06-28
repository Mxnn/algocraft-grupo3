package fiuba.algo3.algocraft.vista.acciones;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JProgressBar;
import java.awt.Insets;

public class pruebaVitalidad extends JPanel {

	/**
	 * Create the panel.
	 */
	public pruebaVitalidad() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblVida = new JLabel("Vida");
		GridBagConstraints gbc_lblVida = new GridBagConstraints();
		gbc_lblVida.insets = new Insets(0, 0, 5, 0);
		gbc_lblVida.gridx = 0;
		gbc_lblVida.gridy = 0;
		add(lblVida, gbc_lblVida);
		
		JProgressBar progressBar = new JProgressBar();
		
		int max = 200;
		progressBar.setMaximum(max);
		progressBar.setStringPainted(true);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		int actual = 100;
		progressBar.setValue(actual);
		
		progressBar.setString(actual + "/" + max);
		add(progressBar, gbc_progressBar);
		
		JLabel lblEscudo = new JLabel("Escudo");
		GridBagConstraints gbc_lblEscudo = new GridBagConstraints();
		gbc_lblEscudo.insets = new Insets(0, 0, 5, 0);
		gbc_lblEscudo.gridx = 0;
		gbc_lblEscudo.gridy = 2;
		add(lblEscudo, gbc_lblEscudo);
		
		JProgressBar progressEscudo = new JProgressBar();
		progressEscudo.setStringPainted(true);
		GridBagConstraints gbc_progressEscudo = new GridBagConstraints();
		gbc_progressEscudo.insets = new Insets(0, 0, 5, 0);
		gbc_progressEscudo.gridx = 0;
		gbc_progressEscudo.gridy = 3;
		add(progressEscudo, gbc_progressEscudo);
		
		JLabel lblEnergia = new JLabel("Energia");
		GridBagConstraints gbc_lblEnergia = new GridBagConstraints();
		gbc_lblEnergia.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnergia.gridx = 0;
		gbc_lblEnergia.gridy = 4;
		add(lblEnergia, gbc_lblEnergia);
		
		JProgressBar progressEnergia = new JProgressBar();
		progressEnergia.setStringPainted(true);
		GridBagConstraints gbc_progressEnergia = new GridBagConstraints();
		gbc_progressEnergia.gridx = 0;
		gbc_progressEnergia.gridy = 5;
		add(progressEnergia, gbc_progressEnergia);

	}

}
