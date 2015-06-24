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
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.vista.VistaJuego;

public class Controlador {
	Juego modelo;
	VistaJuego vista;
	Coordenada coordPartida;
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
		} catch (ExcepcionElementoNoAdmitidoEnParcela e1) {
			vista.displayError("Elemento No Admitido En Parcela");
		} catch (ExcepcionParcelaOcupada e1) {
			vista.displayError("ParcelaOcupada");
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
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
		}
	}

	public void crearExtractorGas() {
		try {
			this.modelo.getJugadorQueJuega().crearExtractorGas(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e) {
			vista.displayError("Recursos Insuficientes");
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
		}
		
	}

	public void crearCreadorUnidadesBasicas() {
		try {
			this.modelo.getJugadorQueJuega().crearCreadorDeUnidadesBasicas(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e) {
			vista.displayError("Recursos Insuficientes");
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
		}
		
	}

	public void crearCreadorUnidadesAvanzadas(){
		try {
			this.modelo.getJugadorQueJuega().crearCreadorDeUnidadesAvanzadas(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e) {
			vista.displayError("Recursos Insuficientes");
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
		} catch (ExcepcionConstruccionesRequeridasNoCreadas e) {
			vista.displayError("Construcciones Requeridas No Creadas");
		}
	}

	public void crearCreadorUnidadesMagicas() {
		try {
			this.modelo.getJugadorQueJuega().crearCreadorDeUnidadesMagicas(modelo.getMapa(), vista.getCoordenadaSeleccionada());
			this.vista.refrescar();
		} catch (ExcepcionRecursosInsuficientes e) {
			vista.displayError("Recursos Insuficientes");
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			vista.displayError("Coordenada Fuera Del Mapa");
		} catch (ExcepcionParcelaOcupada e) {
			vista.displayError("Parcela Ocupada");
		} catch (ExcepcionElementoNoAdmitidoEnParcela e) {
			vista.displayError("Elemento No Admitido En Parcela");
		} catch (ExcepcionConstruccionesRequeridasNoCreadas e) {
			vista.displayError("Construcciones Requeridas No Creadas");
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
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void crearGolliat() {
		try {
			Fabrica fabrica = (Fabrica) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			fabrica.crearGolliat(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void crearEspectro() {
		try {
			PuertoEstelar puertoEstelar = (PuertoEstelar) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			puertoEstelar.crearEspectro(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
			// TODO Auto-generated catch block
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void crearNaveTransporte() {
		try {
			PuertoEstelar puertoEstelar = (PuertoEstelar) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			puertoEstelar.crearNaveTransporte(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void crearNaveCiencia() {
		try {
			PuertoEstelar puertoEstelar = (PuertoEstelar) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			puertoEstelar.crearNaveCiencia(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void crearZealot() {
		try {
			Acceso acceso = (Acceso) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			acceso.crearZealot(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void crearDragon() {
		try {
			Acceso acceso = (Acceso) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			acceso.crearDragon(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void crearScout() {
		try {
			PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			puerto.crearScout(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void crearNaveTransporteProtoss() {
		try {
			PuertoEstelarProtoss puertoEstelar = (PuertoEstelarProtoss) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			puertoEstelar.crearNaveTransporte(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void crearAltoTemplario() {
		try {
			ArchivosTemplarios archivosTemplarios = (ArchivosTemplarios) this.modelo.getMapa().devolverElementoEnParcela(this.vista.getCoordenadaSeleccionada());
			archivosTemplarios.crearAltoTemplario(this.modelo.getMapa());
			this.vista.refrescar();
		} catch (ExcepcionCoordenadaFueraDelMapa e) {
			// TODO Auto-generated catch block
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			vista.displayError("No Hay Suministros Disponibles");
		} catch (ExcepcionNoHayLugarDisponible e) {
			vista.displayError("No Hay Lugar Disponible");
		} catch (ExcepcionEntidadEnConstruccion e) {
            vista.displayError("La entidad esta en construccion");
		}
	}

	public void mover() throws ExcepcionCoordenadaFueraDelMapa {
		
		this.coordPartida= this.vista.getCoordenadaSeleccionada();
			vista.displayError("Bien, ahora clickear sobre destinacion");
       
	}

	public void ponerDestinacion() throws ExcepcionCoordenadaFueraDelMapa {
		if(this.coordPartida!=null){
		Unidad unidad = (Unidad) this.modelo.getMapa().devolverElementoEnParcela(this.coordPartida);
		unidad.moverHasta(this.vista.getCoordenadaSeleccionada());
		this.vista.refrescar();
		this.coordPartida=null;
		}else{
			vista.displayError("Primer, clickear sobre la unidad");
		}
		
	}
}