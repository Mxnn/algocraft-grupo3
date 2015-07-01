package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.ObservadorMapa;
import fiuba.algo3.algocraft.vista.VistaJuego;

public class ClickEnParcelaListener {
	Juego modelo;
	VistaJuego vista;
	private ObservadorMapa observador;
	
	public ClickEnParcelaListener(Juego elJuego) {
		this.modelo = elJuego;
	}

	public ParcelaListener getParcelaListener() {
		
		return new ParcelaListener(this);
	}

	public void clickEnParcela(int x, int y) throws ExcepcionCoordenadaFueraDelMapa {
		vista.seleccionarCoordenada(x, y);
		this.observador.seleccionarCoordenada(x,y);
	}

	public void setVistaJuego(VistaJuego vista){
		this.vista = vista;
	}


	public void setObservadores(ObservadorMapa observador) {
		this.observador = observador;
		
	}
}