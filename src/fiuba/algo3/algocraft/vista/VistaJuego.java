package fiuba.algo3.algocraft.vista;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.controlador.CerrarFrameControlador;
import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.NuevoJuegoListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.Insets;

public class VistaJuego {
	Juego modelo ;
	Controlador controlador;
	VistaMapa panelDeParcela;
	JFrame ventanita;
	
	public static int CANTIDAD_DE_OPCIONES = 8;
	public VistaJuego(Juego elJuego, Controlador elControlador) throws ExcepcionCoordenadaFueraDelMapa {
		this.modelo = elJuego;
		this.controlador= elControlador;
	
		int columnas = this.modelo.getMapa().getColumnas();
		int filas = this.modelo.getMapa().getFilas();
		
		 JFrame ventanita= new JFrame();
		 this.ventanita = ventanita;
		 ventanita.setSize(1000,700);
		 
		 
		 VistaMapa panelDeParcela = new VistaMapa(this.controlador,filas,columnas);
		 this.panelDeParcela = panelDeParcela;
		 panelDeParcela.setBackground(new Color(240, 240, 240));
		 
//		 panelDeParcela.setLocation(0, 0);
//		 panelDeParcela.setSize(500,500);
////		 panelDeParcela.setLayout(new GridLayout(columnas,filas)); esto lo comente para poder usar el window builder
//		 panelDeParcela.setLayout(new GridLayout(20,20));
//
//		 
//		 for (int i=0;i<filas*columnas;i++){
//			 JButton buttonActual= new JButton();
//			 panelDeParcela.add(buttonActual);
//			 buttonActual.addActionListener(this.controlador.getParcelaListener());
//				
//		 }
		 
		 /*int columnasOpciones = CANTIDAD_DE_OPCIONES;
		 int filasOpciones = 1;
		 
		 JPanel panelDeOpciones = new JPanel();
		 panelDeOpciones.setSize(500,500);
		 panelDeOpciones.setLayout(new GridLayout(columnasOpciones,filasOpciones));
		 
		 for (int i=0;i<filasOpciones*columnasOpciones;i++){
			 JButton buttonActual= new JButton();
			 panelDeOpciones.add(buttonActual);
			 buttonActual.addActionListener(this.controlador.getParcelaListener());
				
		 }*/
		 
		 

//		 JButton button = new JButton();
//		 button.setSize(20,20);
//		 button.setText("Button Crear deposito de Sumnistro");
//		 button.addActionListener(this.controlador.getCrearDepositoDeSumnistroListener());
	
		 ventanita.getContentPane().add(panelDeParcela);
		 
//		 ventanita.getContentPane().add(button);
		 ventanita.getContentPane().setLayout(null);
		 
		 JMenuBar menuBar = new JMenuBar();
		 ventanita.setJMenuBar(menuBar);
		 
		 JMenu mnArchivo = new JMenu("Archivo");
		 menuBar.add(mnArchivo);
		 
		 JMenuItem mntmNuevoJuego = new JMenuItem("Nuevo Juego");
		 mnArchivo.add(mntmNuevoJuego);
		 mntmNuevoJuego.addActionListener(new NuevoJuegoListener(this.modelo));
		 
		 JMenuItem mntmSalir = new JMenuItem("Salir");
		 mnArchivo.add(mntmSalir);
		 mntmSalir.addActionListener(new CerrarFrameControlador(ventanita));
		 
		 
		 //esto habria que [ponerlo cuando se inicie el juego pero lo pongo aca para probar
		 panelDeParcela.setParcelas(this.modelo.getMapa());
		 
		 
		 JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		 tabbedPane.setBounds(627, 0, 281, 641);
		 ventanita.getContentPane().add(tabbedPane);
		 
		 JPanel panelInfo = new JPanel();
		 JPanel panelAcciones = new JPanel();
		 tabbedPane.addTab("Informacion", panelInfo);
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
		 
		 JLabel lblMaxpobacionj1 = new JLabel("MAX_POBACION_J1");
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
		 
		 JLabel lblMaxpobacionj2 = new JLabel("MAX_POBACION_J2");
		 GridBagConstraints gbc_lblMaxpobacionj2 = new GridBagConstraints();
		 gbc_lblMaxpobacionj2.insets = new Insets(0, 0, 0, 5);
		 gbc_lblMaxpobacionj2.gridx = 2;
		 gbc_lblMaxpobacionj2.gridy = 22;
		 panelInfo.add(lblMaxpobacionj2, gbc_lblMaxpobacionj2);
		 tabbedPane.addTab("Acciones", panelAcciones);
		 
		 

		 ventanita.setVisible(true);
		 
		 
		 ventanita.repaint();
	}
	
	public void refrescar(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa{
		this.panelDeParcela.refrescar(mapa);
		this.ventanita.repaint();
	}
}
