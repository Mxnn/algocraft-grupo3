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
	VistaBarraLateral barraLateral;
	
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
		 
		 
		 VistaBarraLateral unaBarraLateral = new VistaBarraLateral(this.controlador);
		 this.barraLateral = unaBarraLateral;
		 ventanita.getContentPane().add(barraLateral);
		
		 
		 
		
		 

		 ventanita.setVisible(true);
		 
		 
		 ventanita.repaint();
	}
	
	public void refrescar(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa{
		this.panelDeParcela.refrescar(mapa);
		this.ventanita.repaint();
	}
}
