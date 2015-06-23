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
	public ParcelaListener getParcelaListener() {
		
		return new ParcelaListener(this);
	}
	public void clickEnParcela(int x, int y) {
		System.out.println("click en parcela "+x+","+y);
		
	}
}
