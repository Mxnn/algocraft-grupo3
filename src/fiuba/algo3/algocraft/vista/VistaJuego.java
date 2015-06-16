package fiuba.algo3.algocraft.vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.juego.Juego;

public class VistaJuego {
	Juego modelo ;
	Controlador controlador;
	
	
	public static int CANTIDAD_DE_OPCIONES = 8;
	public VistaJuego(Juego elJuego, Controlador elControlador) {
		this.modelo = elJuego;
		this.controlador= elControlador;
	
		int columnas = this.modelo.getMapa().getColumnas();
		int filas = this.modelo.getMapa().getFilas();
		
		 JFrame ventanita= new JFrame();
		 ventanita.setSize(800,650);
		 
		 ventanita.setVisible(true);	
		 
		 JPanel panelDeParcela = new JPanel();
		 panelDeParcela.setSize(500,500);
		 panelDeParcela.setLayout(new GridLayout(columnas,filas));
		 
		 for (int i=0;i<filas*columnas;i++){
			 JButton buttonActual= new JButton();
			 panelDeParcela.add(buttonActual);
			 buttonActual.addActionListener(this.controlador.getParcelaListener());
				
		 }
		 
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
		 
		 

		 JButton button = new JButton();
		 button.setSize(20,20);
		 button.setText("Button Crear deposito de Sumnistro");
		 button.addActionListener(this.controlador.getCrearDepositoDeSumnistroListener());
	
		 ventanita.add(panelDeParcela);
		 ventanita.add(button);
		 ventanita.setLayout(null);

		 ventanita.repaint();
	}

}
