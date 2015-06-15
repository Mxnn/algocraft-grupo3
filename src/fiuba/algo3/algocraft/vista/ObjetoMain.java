package fiuba.algo3.algocraft.vista;

import javax.swing.JButton;
import javax.swing.JFrame;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.juego.Juego;



public class ObjetoMain {
	 public static void main(String[] args) throws ExcepcionNumeroDeBasesInvalido{
		 Juego elJuego = new Juego();
		 Controlador unControlador = new Controlador(elJuego);
		 
		 VistaJuego unaVista = new VistaJuego(elJuego, unControlador);

	 }
}
