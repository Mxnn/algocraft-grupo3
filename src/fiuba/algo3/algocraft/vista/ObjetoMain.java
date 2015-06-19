package fiuba.algo3.algocraft.vista;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.juego.Juego;

public class ObjetoMain {
	 public static void main(String[] args) throws ExcepcionNumeroDeBasesInvalido{
		 Juego elJuego = new Juego();
		 Controlador unControlador = new Controlador(elJuego);
		 
		 new VistaJuego(elJuego, unControlador);
	 }
}
