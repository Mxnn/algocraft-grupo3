package fiuba.algo3.algocraft.vista.acciones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

public class VistaAccionesInteractuable extends VistaAcciones {
	protected JPanel panelVitalidad;
	public VistaAccionesInteractuable(Juego modelo) {
		super(modelo);
		GridBagLayout gridBagLayout = (GridBagLayout) getLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.columnWeights = new double[]{1.0};
		
//		JLabel lblNewLabel = new JLabel("Vitalidad");
//		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
//		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
//		gbc_lblNewLabel.gridx = 0;
//		gbc_lblNewLabel.gridy = 1;
//		add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		this.panelVitalidad = panel;
		
	}
	
	public void setVida(int max, int actual){
		JLabel lblVida = new JLabel("Vida");
		GridBagConstraints gbc_lblVida = new GridBagConstraints();
		gbc_lblVida.insets = new Insets(0, 0, 5, 0);
		gbc_lblVida.gridx = 0;
		gbc_lblVida.gridy = 0;
		this.panelVitalidad.add(lblVida, gbc_lblVida);
		
		JProgressBar progressVida = new JProgressBar();
		
		progressVida.setMaximum(max);
		progressVida.setStringPainted(true);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		progressVida.setValue(actual);
		
		progressVida.setString(actual + "/" + max);
		this.panelVitalidad.add(progressVida, gbc_progressBar);
	}
	
	public void setEscudo(int max, int actual){
		JLabel lblEscudo = new JLabel("Escudo");
		GridBagConstraints gbc_lblEscudo = new GridBagConstraints();
		gbc_lblEscudo.insets = new Insets(0, 0, 5, 0);
		gbc_lblEscudo.gridx = 0;
		gbc_lblEscudo.gridy = 2;
		this.panelVitalidad.add(lblEscudo, gbc_lblEscudo);
		
		JProgressBar progressEscudo = new JProgressBar();
		
		progressEscudo.setMaximum(max);
		progressEscudo.setStringPainted(true);
		GridBagConstraints gbc_progressEscudo = new GridBagConstraints();
		gbc_progressEscudo.insets = new Insets(0, 0, 5, 0);
		gbc_progressEscudo.gridx = 0;
		gbc_progressEscudo.gridy = 3;
		progressEscudo.setValue(actual);
		progressEscudo.setString(actual + "/" + max);
		this.panelVitalidad.add(progressEscudo, gbc_progressEscudo);

	}
	
	public void setEnergia(int max, int actual){
		JLabel lblEnergia = new JLabel("Energia");
		GridBagConstraints gbc_lblEnergia = new GridBagConstraints();
		gbc_lblEnergia.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnergia.gridx = 0;
		gbc_lblEnergia.gridy = 4;
		this.panelVitalidad.add(lblEnergia, gbc_lblEnergia);
		
		JProgressBar progressEnergia = new JProgressBar();
		
		progressEnergia.setMaximum(max);
		progressEnergia.setStringPainted(true);
		GridBagConstraints gbc_progressEnergia = new GridBagConstraints();
		gbc_progressEnergia.insets = new Insets(0, 0, 5, 0);
		gbc_progressEnergia.gridx = 0;
		gbc_progressEnergia.gridy = 5;
		progressEnergia.setValue(actual);
		progressEnergia.setString(actual + "/" + max);
		this.panelVitalidad.add(progressEnergia, gbc_progressEnergia);

	}

}
