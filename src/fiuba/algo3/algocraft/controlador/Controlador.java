package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaJuego;

public class Controlador {
	Juego modelo;
	VistaJuego vista;
	
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
	public void clickEnParcela(int x, int y) throws ExcepcionCoordenadaFueraDelMapa {
		//hacer algo cuando sea necesario
		System.out.println("click en parcela "+x+","+y);
		vista.seleccionarCoordenada(x, y);
		
	}

	public void setVistaJuego(VistaJuego vista){
		this.vista = vista;
		
	}

	public void crearExtractorMineral() throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
		this.modelo.getJugadorQueJuega().crearExtractorMineral(modelo.getMapa(), vista.getCoordenadaSeleccionada());
		this.vista.refrescar(modelo.getMapa());
	}
	
}