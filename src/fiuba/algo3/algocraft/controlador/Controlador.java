package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.juego.Juego;

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
	public ParcelaListener getParcelaListener() {
		
		return new ParcelaListener(this);
	}
	public void clickEnParcela() {
		System.out.println("click en parcela");
		
	}
}
