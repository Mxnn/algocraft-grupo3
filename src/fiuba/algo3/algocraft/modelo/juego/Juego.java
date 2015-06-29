package fiuba.algo3.algocraft.modelo.juego;

import java.util.ArrayList;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.Raza;
import fiuba.algo3.algocraft.vista.ObservadorJuego;
import fiuba.algo3.algocraft.vista.ObservadorMapa;

public class Juego {
    public static int MAXIMO_NUMERO_DE_JUGADORES = 2;

    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private GeneradorMapa generadorMapa;
    private SistemaDeTurnos sistemaDeTurnos;
    private ArrayList<ObservadorJuego> observadores = new ArrayList<ObservadorJuego>();
    
    public Juego() throws ExcepcionNumeroDeBasesInvalido { 
    	this.generadorMapa = new GeneradorMapa();
//    	this.mapa = this.generadorMapa.getMapa();
        this.sistemaDeTurnos = new SistemaDeTurnos(this.jugadores,this.getMapa());
    }

	public void setObservadores(ObservadorMapa observador, ObservadorJuego observadorJuego) throws ExcepcionNumeroDeBasesInvalido {
		this.generadorMapa = new GeneradorMapa(observador);
		this.sistemaDeTurnos = new SistemaDeTurnos(this.jugadores,this.getMapa());
//		this.sistemaDeTurnos.setObservador(observadorJuego);
		this.observadores.add(observadorJuego);

//		this.mapa = this.generadorMapa.getMapa();
		//por ahi convienen dos inicializadores de je
	}

    public void setMapaParaTests() throws ExcepcionNumeroDeBasesInvalido{
    	this.generadorMapa.setMapaParaTests();
//    	this.mapa = this.generadorMapa.getMapa();
    	this.sistemaDeTurnos = new SistemaDeTurnos(this.jugadores,this.getMapa());
    }

    public ArrayList<Jugador> getJugadores(){
    	return this.jugadores;
    }

    public Mapa getMapa(){
    	return this.generadorMapa.getMapa();
    }

    public void crearJugador(String nombre, Color color, Raza raza) throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreCorto {
        if (jugadores.size() == MAXIMO_NUMERO_DE_JUGADORES)
            throw new ExcepcionAlcanzadoElMaximoCupoDeJugadores();

        if (this.elNombreEstaEnUso(nombre))
            throw new ExcepcionNombreEnUso();

        if (this.elColorEstaEnUso(color))
            throw new ExcepcionColorEnUso();

        Jugador nuevoJugador = new Jugador(nombre, color, raza);

        this.jugadores.add(nuevoJugador);
    }

    public void agregarJugador(Jugador unJugador) throws ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionColorEnUso {
        if (jugadores.size() == MAXIMO_NUMERO_DE_JUGADORES)
            throw new ExcepcionAlcanzadoElMaximoCupoDeJugadores();

        if (this.elNombreEstaEnUso(unJugador.getNombre()))
            throw new ExcepcionNombreEnUso();

        if (this.elColorEstaEnUso(unJugador.getColor()))
            throw new ExcepcionColorEnUso();

        this.jugadores.add(unJugador);
    }

    public int getCantidadDeJugadores() {
        return jugadores.size();
    }

    private boolean elNombreEstaEnUso(String nombre) {
        for (Jugador jugador : jugadores) {
            if ( (jugador.getNombre()).equals(nombre) ) {
               return true;
            }
        }
        return false;
    }

    private boolean elColorEstaEnUso(Color color) {
        for (Jugador jugador : jugadores) {
            if (jugador.getColor() == color) {
                return true;
            }
        }
        return false;
    }

  private void finJuego(Jugador perdedor){
  	for (ObservadorJuego observador: this.observadores) {
		observador.hayPerdedor(perdedor);
	}
  }

    public void pasarTurno(Jugador jugador) throws ExcepcionEstadoMuerto, ExcepcionCoordenadaFueraDelMapa {
        try {
			this.sistemaDeTurnos.pasarTurno(jugador);
		} catch (ExcepcionEnemigoFueraDeAlcance e) {
			for (ObservadorJuego observador: this.observadores) {
	    		observador.displayError(e.getMessage());
			}
		}finally{
        for (ObservadorJuego observador: this.observadores) {
    		observador.nuevoTurno();
    	}
        if(jugador.esPerdedor())
        	this.finJuego(jugador);
		}
    }

    public void limpiarJugadores() {
        this.jugadores.clear();
    }

    public Jugador getJugadorQueJuega() {
        return this.sistemaDeTurnos.getJugadorQueJuega();
    }
}
