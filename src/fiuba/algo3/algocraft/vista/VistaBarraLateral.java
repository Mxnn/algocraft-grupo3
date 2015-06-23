package fiuba.algo3.algocraft.vista;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;

public class VistaBarraLateral extends JTabbedPane{
    private final Color colorJugadorQueJuega = Color.blue;

	private JLabel nombreJ1;
	private JLabel mineralJ1;
	private JLabel gasJ1;
	private JLabel poblacionJ1;
	private JLabel maxPoblacionJ1;
	
	private JLabel nombreJ2;
	private JLabel mineralJ2;
	private JLabel gasJ2;
	private JLabel poblacionJ2;
	private JLabel maxPoblacionJ2;
	
	private JPanel acciones;
	
	
	public VistaBarraLateral(Controlador controlador) {
		//hay que modificar para que el tabbedPane se cree desde este constructor

		this.setBounds(627, 0, 281, 641);
	
		 
		 JPanel panelInfo = new JPanel();
		 
		 this.addTab("Informacion", panelInfo);
		 GridBagLayout gbl_panelInfo = new GridBagLayout();
		 gbl_panelInfo.columnWidths = new int[]{0, 0, 0, 0, 0};
		 gbl_panelInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		 gbl_panelInfo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 gbl_panelInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		 panelInfo.setLayout(gbl_panelInfo);
		 
		 JLabel lblInformacionElementoSeleccionado = new JLabel("Informacion Elemento Seleccionado");
		 GridBagConstraints gbc_lblInformacionElementoSeleccionado = new GridBagConstraints();
		 gbc_lblInformacionElementoSeleccionado.insets = new Insets(0, 0, 5, 5);
		 gbc_lblInformacionElementoSeleccionado.anchor = GridBagConstraints.EAST;
		 gbc_lblInformacionElementoSeleccionado.gridx = 2;
		 gbc_lblInformacionElementoSeleccionado.gridy = 0;
		 panelInfo.add(lblInformacionElementoSeleccionado, gbc_lblInformacionElementoSeleccionado);
		 
		 JSeparator separator = new JSeparator();
		 GridBagConstraints gbc_separator = new GridBagConstraints();
		 gbc_separator.insets = new Insets(0, 0, 5, 5);
		 gbc_separator.gridx = 2;
		 gbc_separator.gridy = 9;
		 panelInfo.add(separator, gbc_separator);
		 
		 JLabel lblInformacionJugador = new JLabel("Informacion Jugador 1");
		 GridBagConstraints gbc_lblInformacionJugador = new GridBagConstraints();
		 gbc_lblInformacionJugador.insets = new Insets(0, 0, 5, 5);
		 gbc_lblInformacionJugador.gridx = 2;
		 gbc_lblInformacionJugador.gridy = 10;
		 panelInfo.add(lblInformacionJugador, gbc_lblInformacionJugador);
		 
		 JLabel lblNombre = new JLabel("Nombre:");
		 GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		 gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNombre.gridx = 1;
		 gbc_lblNombre.gridy = 11;
		 panelInfo.add(lblNombre, gbc_lblNombre);
		 
		 JLabel lblNombreJ1 = new JLabel("NOMBRE J1");
		 this.nombreJ1 = lblNombreJ1;
		 GridBagConstraints gbc_lblNombreJ1 = new GridBagConstraints();
		 gbc_lblNombreJ1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNombreJ1.gridx = 2;
		 gbc_lblNombreJ1.gridy = 11;
		 panelInfo.add(lblNombreJ1, gbc_lblNombreJ1);
		 
		 JLabel lblMinerales = new JLabel("Minerales:");
		 GridBagConstraints gbc_lblMinerales = new GridBagConstraints();
		 gbc_lblMinerales.insets = new Insets(0, 0, 5, 5);
		 gbc_lblMinerales.gridx = 1;
		 gbc_lblMinerales.gridy = 12;
		 panelInfo.add(lblMinerales, gbc_lblMinerales);
		 
		 JLabel lblCantminj1 = new JLabel("CANT_MIN_J1");
		 this.mineralJ1 = lblCantminj1;
		 GridBagConstraints gbc_lblCantminj1 = new GridBagConstraints();
		 gbc_lblCantminj1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblCantminj1.gridx = 2;
		 gbc_lblCantminj1.gridy = 12;
		 panelInfo.add(lblCantminj1, gbc_lblCantminj1);
		 
		 JLabel lblGas = new JLabel("Gas:");
		 GridBagConstraints gbc_lblGas = new GridBagConstraints();
		 gbc_lblGas.insets = new Insets(0, 0, 5, 5);
		 gbc_lblGas.gridx = 1;
		 gbc_lblGas.gridy = 13;
		 panelInfo.add(lblGas, gbc_lblGas);
		 
		 JLabel lblCantgasj1 = new JLabel("CANT_GAS_J1");
		 this.gasJ1 = lblCantgasj1;
		 GridBagConstraints gbc_lblCantgasj1 = new GridBagConstraints();
		 gbc_lblCantgasj1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblCantgasj1.gridx = 2;
		 gbc_lblCantgasj1.gridy = 13;
		 panelInfo.add(lblCantgasj1, gbc_lblCantgasj1);
		 
		 JLabel lblSuministros = new JLabel("Poblacion:");
		 GridBagConstraints gbc_lblSuministros = new GridBagConstraints();
		 gbc_lblSuministros.insets = new Insets(0, 0, 5, 5);
		 gbc_lblSuministros.gridx = 1;
		 gbc_lblSuministros.gridy = 14;
		 panelInfo.add(lblSuministros, gbc_lblSuministros);
		 
		 JLabel lblPoblacionj1 = new JLabel("POBLACION_J1");
		 this.poblacionJ1 = lblPoblacionj1;
		 GridBagConstraints gbc_lblPoblacionj1 = new GridBagConstraints();
		 gbc_lblPoblacionj1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblPoblacionj1.gridx = 2;
		 gbc_lblPoblacionj1.gridy = 14;
		 panelInfo.add(lblPoblacionj1, gbc_lblPoblacionj1);
		 
		 JLabel lblMaxPoblacion = new JLabel("Max Poblacion");
		 GridBagConstraints gbc_lblMaxPoblacion = new GridBagConstraints();
		 gbc_lblMaxPoblacion.insets = new Insets(0, 0, 5, 5);
		 gbc_lblMaxPoblacion.gridx = 1;
		 gbc_lblMaxPoblacion.gridy = 15;
		 panelInfo.add(lblMaxPoblacion, gbc_lblMaxPoblacion);
		 
		 JLabel lblMaxpobacionj1 = new JLabel("MAX_POBlACION_J1");
		 this.maxPoblacionJ1 = lblMaxpobacionj1;
		 GridBagConstraints gbc_lblMaxpobacionj1 = new GridBagConstraints();
		 gbc_lblMaxpobacionj1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblMaxpobacionj1.gridx = 2;
		 gbc_lblMaxpobacionj1.gridy = 15;
		 panelInfo.add(lblMaxpobacionj1, gbc_lblMaxpobacionj1);
		 
		 JLabel lblInformacionJugador_1 = new JLabel("Informacion Jugador 2");
		 GridBagConstraints gbc_lblInformacionJugador_1 = new GridBagConstraints();
		 gbc_lblInformacionJugador_1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblInformacionJugador_1.gridx = 2;
		 gbc_lblInformacionJugador_1.gridy = 17;
		 panelInfo.add(lblInformacionJugador_1, gbc_lblInformacionJugador_1);
		 
		 JLabel label = new JLabel("Nombre:");
		 GridBagConstraints gbc_label = new GridBagConstraints();
		 gbc_label.insets = new Insets(0, 0, 5, 5);
		 gbc_label.gridx = 1;
		 gbc_label.gridy = 18;
		 panelInfo.add(label, gbc_label);
		 
		 JLabel lblNombreJ2 = new JLabel("NOMBRE J2");
		 this.nombreJ2 = lblNombreJ2;
		 GridBagConstraints gbc_lblNombreJ2 = new GridBagConstraints();
		 gbc_lblNombreJ2.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNombreJ2.gridx = 2;
		 gbc_lblNombreJ2.gridy = 18;
		 panelInfo.add(lblNombreJ2, gbc_lblNombreJ2);
		 
		 JLabel label_1 = new JLabel("Minerales:");
		 GridBagConstraints gbc_label_1 = new GridBagConstraints();
		 gbc_label_1.insets = new Insets(0, 0, 5, 5);
		 gbc_label_1.gridx = 1;
		 gbc_label_1.gridy = 19;
		 panelInfo.add(label_1, gbc_label_1);
		 
		 JLabel lblCantminj2 = new JLabel("CANT_MIN_J2");
		 this.mineralJ2 = lblCantminj2;
		 GridBagConstraints gbc_lblCantminj2 = new GridBagConstraints();
		 gbc_lblCantminj2.insets = new Insets(0, 0, 5, 5);
		 gbc_lblCantminj2.gridx = 2;
		 gbc_lblCantminj2.gridy = 19;
		 panelInfo.add(lblCantminj2, gbc_lblCantminj2);
		 
		 JLabel label_2 = new JLabel("Gas:");
		 GridBagConstraints gbc_label_2 = new GridBagConstraints();
		 gbc_label_2.insets = new Insets(0, 0, 5, 5);
		 gbc_label_2.gridx = 1;
		 gbc_label_2.gridy = 20;
		 panelInfo.add(label_2, gbc_label_2);
		 
		 JLabel lblCantgasj2 = new JLabel("CANT_GAS_J2");
		 this.gasJ2 = lblCantgasj2;
		 GridBagConstraints gbc_lblCantgasj2 = new GridBagConstraints();
		 gbc_lblCantgasj2.insets = new Insets(0, 0, 5, 5);
		 gbc_lblCantgasj2.gridx = 2;
		 gbc_lblCantgasj2.gridy = 20;
		 panelInfo.add(lblCantgasj2, gbc_lblCantgasj2);
		 
		 JLabel label_3 = new JLabel("Poblacion:");
		 GridBagConstraints gbc_label_3 = new GridBagConstraints();
		 gbc_label_3.insets = new Insets(0, 0, 5, 5);
		 gbc_label_3.gridx = 1;
		 gbc_label_3.gridy = 21;
		 panelInfo.add(label_3, gbc_label_3);
		 
		 JLabel lblPoblacionj2 = new JLabel("POBLACION_J2");
		 this.poblacionJ2 = lblPoblacionj2;
		 GridBagConstraints gbc_lblPoblacionj2 = new GridBagConstraints();
		 gbc_lblPoblacionj2.insets = new Insets(0, 0, 5, 5);
		 gbc_lblPoblacionj2.gridx = 2;
		 gbc_lblPoblacionj2.gridy = 21;
		 panelInfo.add(lblPoblacionj2, gbc_lblPoblacionj2);
		 
		 JLabel label_4 = new JLabel("Max Poblacion");
		 GridBagConstraints gbc_label_4 = new GridBagConstraints();
		 gbc_label_4.insets = new Insets(0, 0, 0, 5);
		 gbc_label_4.gridx = 1;
		 gbc_label_4.gridy = 22;
		 panelInfo.add(label_4, gbc_label_4);
		 
		 JLabel lblMaxpobacionj2 = new JLabel("MAX_POBLACION_J2");
		 this.maxPoblacionJ2 = lblMaxpobacionj2;
		 GridBagConstraints gbc_lblMaxpobacionj2 = new GridBagConstraints();
		 gbc_lblMaxpobacionj2.insets = new Insets(0, 0, 0, 5);
		 gbc_lblMaxpobacionj2.gridx = 2;
		 gbc_lblMaxpobacionj2.gridy = 22;
		 panelInfo.add(lblMaxpobacionj2, gbc_lblMaxpobacionj2);
		 
		 
		 JPanel panelAcciones = new JPanel();
		 this.acciones = panelAcciones;
		 this.addTab("Acciones", this.acciones);

	}

	public void refrescar(Juego modelo) {
		Jugador j1 = modelo.getJugadores().get(0);
		Jugador j2 = modelo.getJugadores().get(1);
		
		this.nombreJ1.setText(j1.getNombre());
		this.mineralJ1.setText(Integer.toString(j1.getMinerales()));
		this.gasJ1.setText(Integer.toString(j1.getGasVespeno()));
		this.poblacionJ1.setText(Integer.toString(j1.getPoblacion()));
		this.maxPoblacionJ1.setText(Integer.toString(j1.getCapacidadDePoblacion()));
		
		this.nombreJ2.setText(j2.getNombre());
		this.mineralJ2.setText(Integer.toString(j2.getMinerales()));
		this.gasJ2.setText(Integer.toString(j2.getGasVespeno()));
		this.poblacionJ2.setText(Integer.toString(j2.getPoblacion()));
		this.maxPoblacionJ2.setText(Integer.toString(j2.getCapacidadDePoblacion()));

        if ((modelo.getJugadorQueJuega()).equals(modelo.getJugadores().get(0))) {
            this.nombreJ1.setForeground(colorJugadorQueJuega);
            this.nombreJ2.setForeground(Color.black);
        }
        else {
            this.nombreJ1.setForeground(Color.black);
            this.nombreJ2.setForeground(colorJugadorQueJuega);
        }
	}
	
	public void setPanelAcciones(JPanel accion){
		this.setComponentAt(1, accion);
		this.repaint();
	}
}
