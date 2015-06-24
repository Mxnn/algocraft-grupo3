package fiuba.algo3.algocraft.vista;
import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.CrearAdicionalDeSuministroListener;
import fiuba.algo3.algocraft.controlador.CrearExtractorMineralListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VistaAccionesParcelaVacia extends VistaAcciones {
	public VistaAccionesParcelaVacia(Juego modelo, VistaBarraLateral vistaBarraLateral, Controlador controlador) {
		super(modelo, vistaBarraLateral, controlador);
		
		
		JButton btnExtractorGas = new JButton("Extractor Gas");
		
		GridBagConstraints gbc_btnCrearExtractorGas = new GridBagConstraints();
		gbc_btnCrearExtractorGas.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearExtractorGas.gridx = 0;
		gbc_btnCrearExtractorGas.gridy = 2;
		add(btnExtractorGas, gbc_btnCrearExtractorGas);
		
		JButton btnExtractorMinera = new JButton("Extractor Mineral");
		btnExtractorMinera.addActionListener(new CrearExtractorMineralListener(controlador));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		add(btnExtractorMinera, gbc_btnNewButton);
		
		JButton btnAdicionalDeSuministros = new JButton("Adicional De Suministros");
		btnAdicionalDeSuministros.addActionListener(new CrearAdicionalDeSuministroListener(controlador));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 3;
		add(btnAdicionalDeSuministros, gbc_btnNewButton_1);
		
		JButton btnCreadorUnidadesBasicas = new JButton("Creador Unidades Basicas");
		GridBagConstraints gbc_btnCreadorUnidadesBasicas = new GridBagConstraints();
		gbc_btnCreadorUnidadesBasicas.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreadorUnidadesBasicas.gridx = 0;
		gbc_btnCreadorUnidadesBasicas.gridy = 4;
		add(btnCreadorUnidadesBasicas, gbc_btnCreadorUnidadesBasicas);
		
		JButton btnCreadorUnidadesAvanzadas = new JButton("Creador Unidades Avanzadas");
		GridBagConstraints gbc_btnCreadorUnidadesAvanzadas = new GridBagConstraints();
		gbc_btnCreadorUnidadesAvanzadas.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreadorUnidadesAvanzadas.gridx = 0;
		gbc_btnCreadorUnidadesAvanzadas.gridy = 5;
		add(btnCreadorUnidadesAvanzadas, gbc_btnCreadorUnidadesAvanzadas);
		
		JButton btnCreadorUnidadesMagicas = new JButton("Creador Unidades Magicas");
		GridBagConstraints gbc_btnCreadorUnidadesMagicas = new GridBagConstraints();
		gbc_btnCreadorUnidadesMagicas.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreadorUnidadesMagicas.gridx = 0;
		gbc_btnCreadorUnidadesMagicas.gridy = 6;
		add(btnCreadorUnidadesMagicas, gbc_btnCreadorUnidadesMagicas);
	}

}
