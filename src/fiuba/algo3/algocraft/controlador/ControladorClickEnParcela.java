package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.vista.ObservadorMapa;
import fiuba.algo3.algocraft.vista.VistaJuego;

public class ControladorClickEnParcela {
	Juego modelo;
	VistaJuego vista;
	private ObservadorMapa observador;
	
	public ControladorClickEnParcela(Juego elJuego) {
		this.modelo = elJuego;
	}

	public ParcelaListener getParcelaListener() {
		
		return new ParcelaListener(this);
	}

	public void clickEnParcela(int x, int y) throws ExcepcionCoordenadaFueraDelMapa {
//		System.out.println("click en parcela "+x+","+y);
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