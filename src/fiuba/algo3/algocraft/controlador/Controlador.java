package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.juego.Juego;

public class Controlador {
	Juego modelo;
	
	public Controlador(Juego elJuego) {
		this.modelo=elJuego;
	}
	
	public void clickYCrearDeposito() {
		System.out.println("coucou");
		
	}

	public CrearDepositoDeSumnistroListener getCrearDepositoDeSumnistroListener(){
		return new CrearDepositoDeSumnistroListener(this);
	}
}
