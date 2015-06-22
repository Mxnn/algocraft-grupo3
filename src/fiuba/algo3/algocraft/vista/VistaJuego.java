package fiuba.algo3.algocraft.vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.controlador.CerrarFrameControlador;
import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.juego.Juego;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;

public class VistaJuego {
	Juego modelo ;
	Controlador controlador;
	
	
	public static int CANTIDAD_DE_OPCIONES = 8;
	public VistaJuego(Juego elJuego, Controlador elControlador) throws ExcepcionCoordenadaFueraDelMapa {
		this.modelo = elJuego;
		this.controlador= elControlador;
	
		int columnas = this.modelo.getMapa().getColumnas();
		int filas = this.modelo.getMapa().getFilas();
		
		 JFrame ventanita= new JFrame();
		 ventanita.setSize(800,650);
		 
		 
		 VistaMapa panelDeParcela = new VistaMapa(this.controlador,filas,columnas);
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
		 mntmNuevoJuego.addActionListener(this.controlador.getNuevoJuego());
		 
		 JMenuItem mntmSalir = new JMenuItem("Salir");
		 mnArchivo.add(mntmSalir);
		 mntmSalir.addActionListener(new CerrarFrameControlador(ventanita));
		 
		 
		 //esto habria que [ponerlo cuando se inicie el juego pero lo pongo aca para probar
		 panelDeParcela.setParcelas(this.modelo.getMapa());
		 
		 ventanita.setVisible(true);
		 
		 
		 
		 ventanita.repaint();
	}
}
