package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
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

	public CrearAdicionalDeSuministroListener getCrearDepositoDeSumnistroListener(){
		return new CrearAdicionalDeSuministroListener(this);
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

	public void crearExtractorMineral() {		
		try {
			this.modelo.getJugadorQueJuega().crearExtractorMineral(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e1) {
			vista.displayError("Recursos Insuficientes");
		} catch (ExcepcionCoordenadaFueraDelMapa e1) {
			vista.displayError("Coordenada Fuera Del Mapa");
			e1.printStackTrace();
		} catch (ExcepcionElementoNoAdmitidoEnParcela e1) {
			vista.displayError("Elemento No Admitido En Parcela");
			e1.printStackTrace();
		} catch (ExcepcionParcelaOcupada e1) {
			vista.displayError("ParcelaOcupada");
			e1.printStackTrace();
		}
	}

	public void terminarTurno() throws ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa {
		this.modelo.pasarTurno(this.modelo.getJugadorQueJuega());
		this.vista.refrescar();
		
	}
	
	public void crearAdicionalSuministros(){
		try {
			this.modelo.getJugadorQueJuega().crearAdicionalDeSuministro(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e) {
			vista.displayError("Recursos Insuficientes");
			e.printStackTrace();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
			e.printStackTrace();
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
			e.printStackTrace();
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
			e.printStackTrace();
		}
	}

	public void crearExtractorGas() {
		try {
			this.modelo.getJugadorQueJuega().crearExtractorGas(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e) {
			vista.displayError("Recursos Insuficientes");
			e.printStackTrace();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
			e.printStackTrace();
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
			e.printStackTrace();
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
			e.printStackTrace();
		}
		
	}

	public void crearCreadorUnidadesBasicas() {
		try {
			this.modelo.getJugadorQueJuega().crearCreadorDeUnidadesBasicas(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e) {
			vista.displayError("Recursos Insuficientes");
			e.printStackTrace();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
			e.printStackTrace();
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
			e.printStackTrace();
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
			e.printStackTrace();
		}
		
	}

	public void crearCreadorUnidadesAvanzadas(){
		try {
			this.modelo.getJugadorQueJuega().crearCreadorDeUnidadesAvanzadas(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e) {
			vista.displayError("Recursos Insuficientes");
			e.printStackTrace();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
			e.printStackTrace();
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
			e.printStackTrace();
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
			e.printStackTrace();
		} catch (ExcepcionConstruccionesRequeridasNoCreadas e) {
			vista.displayError("Construcciones Requeridas No Creadas");
			e.printStackTrace();
		}
		
		
	}

	public void crearCreadorUnidadesMagicas() {
		try {
			this.modelo.getJugadorQueJuega().crearCreadorDeUnidadesMagicas(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e) {
			vista.displayError("Recursos Insuficientes");
			e.printStackTrace();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
			e.printStackTrace();
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
			e.printStackTrace();
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
			e.printStackTrace();
		} catch (ExcepcionConstruccionesRequeridasNoCreadas e) {
			vista.displayError("Construcciones Requeridas No Creadas");
			e.printStackTrace();
		}
		
	}

	public void crearMarine() {//que onda aca, hacemos los casteos?
		try {
			Barraca barraca = (Barraca) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			barraca.crearMarine(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
			e.printStackTrace();
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
			e.printStackTrace();
		} catch (ExcepcionEntidadEnConstruccion e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		
	}
	
}