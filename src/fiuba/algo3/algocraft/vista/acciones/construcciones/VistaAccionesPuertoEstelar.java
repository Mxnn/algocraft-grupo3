
package fiuba.algo3.algocraft.vista.acciones.construcciones;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.creadoresDeInteractuables.CrearEspectroListener;
import fiuba.algo3.algocraft.controlador.creadoresDeInteractuables.CrearNaveCienciaListener;
import fiuba.algo3.algocraft.controlador.creadoresDeInteractuables.CrearNaveTransporteListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesInteractuable;

public class VistaAccionesPuertoEstelar  extends VistaAccionesInteractuable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VistaAccionesPuertoEstelar(Juego modelo, PuertoEstelar representado) {
		super(modelo, representado);
		
		JButton btnCrearEspectro = new JButton("Crear Espectro");
		btnCrearEspectro.addActionListener(new CrearEspectroListener(modelo, representado));
		GridBagConstraints gbc_btnCrearEspectro = new GridBagConstraints();
		gbc_btnCrearEspectro.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearEspectro.gridx = 0;
		gbc_btnCrearEspectro.gridy = 3;
		add(btnCrearEspectro, gbc_btnCrearEspectro);
		this.habilitarBoton(btnCrearEspectro, representado);
		

		JButton btnCrearNaveDeTransporte = new JButton("Crear Nave Transporte");
		btnCrearNaveDeTransporte.addActionListener(new CrearNaveTransporteListener(modelo, representado));
		GridBagConstraints gbc_btnCrearNaveDeTransporte = new GridBagConstraints();
		gbc_btnCrearNaveDeTransporte.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearNaveDeTransporte.gridx = 0;
		gbc_btnCrearNaveDeTransporte.gridy = 4;
		add(btnCrearNaveDeTransporte, gbc_btnCrearNaveDeTransporte);	
		this.habilitarBoton(btnCrearNaveDeTransporte, representado);
		
		
		
		JButton btnCrearNaveCiencia = new JButton("Crear Nave Ciencia");
		btnCrearNaveCiencia.addActionListener(new CrearNaveCienciaListener(modelo, representado));
		GridBagConstraints gbc_btnCrearNaveCiencia = new GridBagConstraints();
		gbc_btnCrearNaveCiencia.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrearNaveCiencia.gridx = 0;
		gbc_btnCrearNaveCiencia.gridy = 5;
		add(btnCrearNaveCiencia, gbc_btnCrearNaveCiencia);	
		this.habilitarBoton(btnCrearNaveCiencia, representado);
		
	}

}