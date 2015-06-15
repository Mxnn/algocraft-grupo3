package fiuba.algo3.algocraft.juego;

import fiuba.algo3.algocraft.razas.Raza;
import fiuba.algo3.algocraft.utilidades.unidades.Unidad;
import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;

import java.util.ArrayList;
import java.util.LinkedList;


public class Juego {
    private static int MAXIMO_NUMERO_DE_JUGADORES = 2;


    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Mapa mapa;
    private SistemaDeTurnos sistemaDeTurnos;
    private LinkedList<Unidad> unidadesQueDebenMoverEnElTurno = new LinkedList<Unidad>();
    private LinkedList<Unidad> unidadesQueDebenMoverEnElProximoTurno = new LinkedList<Unidad>();
    
    public Juego() throws ExcepcionNumeroDeBasesInvalido { 
    	this.mapa = new Mapa (2,5,5);
        this.sistemaDeTurnos = new SistemaDeTurnos(this.jugadores,this.mapa);
    }

    public ArrayList<Jugador> getJugadores(){
    	return this.jugadores;
    }

    public Mapa getMapa(){
    	return this.mapa;
    }

    public LinkedList<Unidad> getListDeUnidadesQueDebenMoverEnElTurno(){
    	 return this.unidadesQueDebenMoverEnElTurno;
    }
    
    public LinkedList<Unidad> getListDeUnidadesQueDebenMoverEnElProximoTurno(){
   	    return this.unidadesQueDebenMoverEnElProximoTurno;
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

    public void moverUnidad(Coordenada desde, Coordenada hasta) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela{
    	Unidad unidadAMover = (Unidad) this.mapa.devolverElementoEnParcela(desde);
    	unidadAMover.calcularItinerario(this.mapa,desde,hasta);

		this.unidadesQueDebenMoverEnElTurno.add(unidadAMover) ;
	}

	public void tareaDelTurnoMoverLasUnidades() throws ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada{
    	while (!this.unidadesQueDebenMoverEnElTurno.isEmpty()){
    		if (this.tareaDelTurnoMoverUnidad(this.unidadesQueDebenMoverEnElTurno.getFirst()))
    			this.reinscribirLaUnidad();
    		
    		this.unidadesQueDebenMoverEnElTurno.removeFirst();
    		
    	}
    	this.unidadesQueDebenMoverEnElTurno = this.unidadesQueDebenMoverEnElProximoTurno;
    	this.unidadesQueDebenMoverEnElProximoTurno.clear();
    }

	private void reinscribirLaUnidad() {
		this.unidadesQueDebenMoverEnElProximoTurno.add(this.unidadesQueDebenMoverEnElTurno.getFirst());
	}

	private boolean tareaDelTurnoMoverUnidad(Unidad unidadAMover) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
		this.tareaDelTurnoMoverUnidadSubFunction(unidadAMover);

		return (unidadAMover.getItinerario().size() > 1);
	}

	
	private void tareaDelTurnoMoverUnidadSubFunction(Unidad unidadAMover) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
		Parcela parcelaProxima = this.mapa.obtenerParcelaEnCoordenada(unidadAMover.getItinerario().get(1));
		if (parcelaProxima.devolverElemento()!=null){
			unidadAMover.clearItinerario();
			
		} else {
			Parcela parcelaPartida = this.mapa.obtenerParcelaEnCoordenada(unidadAMover.getItinerario().getFirst());
			parcelaPartida.vaciarParcela();
			unidadAMover.getItinerario().removeFirst();
			parcelaProxima.guardarElemento(unidadAMover);
		}
	}

    public void pasarTurno(Jugador jugador) throws ExcepcionNoEsElTurnoDelJugador {
        sistemaDeTurnos.pasarTurno(jugador);
    }
}
