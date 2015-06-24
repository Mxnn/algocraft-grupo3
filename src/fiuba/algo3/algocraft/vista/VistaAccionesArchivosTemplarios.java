
package fiuba.algo3.algocraft.vista;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.CrearCreadorUnidadesMagicasListener;
import fiuba.algo3.algocraft.controlador.CrearMarineListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class VistaAccionesArchivosTemplarios  extends VistaAcciones {


	public VistaAccionesArchivosTemplarios(Controlador controlador) {
		super(controlador);
		
		JButton btnCrearAltoTemplario = new JButton("Crear Alto Templario");
		btnCrearAltoTemplario.addActionListener(new CrearMarineListener(controlador));
		GridBagConstraints gbc_btnCrearAltoTemplario = new GridBagConstraints();
		gbc_btnCrearAltoTemplario.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearAltoTemplario.gridx = 0;
		gbc_btnCrearAltoTemplario.gridy = 2;
		add(btnCrearAltoTemplario, gbc_btnCrearAltoTemplario);
			
	}

}