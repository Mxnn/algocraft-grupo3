package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;

import java.util.ArrayList;
import java.util.LinkedList;


public class Juego {
    //EL CODIGO COMENTADO ES EL CODIGO PARA EL SINGLETON DE LA CLASE (NECESITO "LIMPIAR" EL OBJETO CLASE PARA BORRAR LOS USUARIOS "INSCRIPTOS")
    //private static Juego INSTANCIA = null;
    private static int MAXIMO_NUMERO_DE_JUGADORES = 2;


    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Mapa mapa ;
    private LinkedList<Unidad> UnidadesQueDebenMoverEnElTurno = new LinkedList<Unidad>();
    private LinkedList<Unidad> UnidadesQueDebenMoverEnElProximoTurno = new LinkedList<Unidad>();
    
    public Juego() throws ExcepcionNumeroDeBasesInvalido { 
    	mapa = new Mapa (2,5,5); 
    }

    public ArrayList<Jugador> getJugadores(){
    	return this.jugadores;
    }
    public Mapa getMapa(){
    	return this.mapa;
    }
    public LinkedList<Unidad> getListDeUnidadesQueDebenMoverEnElTurno(){
    	 return this.UnidadesQueDebenMoverEnElTurno;
    }
    
    public LinkedList<Unidad> getListDeUnidadesQueDebenMoverEnElProximoTurno(){
   	 return this.UnidadesQueDebenMoverEnElProximoTurno;
   }
    /*
 

    private synchronized static void createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new Juego();
        }
    }
    public static Juego getInstance() {
        if (INSTANCIA == null)
            createInstance();

        return INSTANCIA;
    }*/

    public void crearJugador(String nombre, Color color, Raza raza) throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreCorto {
        if (jugadores.size() == MAXIMO_NUMERO_DE_JUGADORES)
            throw new ExcepcionAlcanzadoElMaximoCupoDeJugadores();

        if (this.elNombreEstaEnUso(nombre))
            throw new ExcepcionNombreEnUso();

        if (this.elColorEstaEnUso(color))
            throw new ExcepcionColorEnUso();

        Jugador nuevoJugador = new Jugador(nombre, color, raza);

        jugadores.add(nuevoJugador);
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
    

    public void moverUnidad(Coordenada desde, Coordenada hasta) throws ExcepcionCoordenadaFueraDelMapa{
    	Unidad unidadAMover = (Unidad) this.mapa.devolverElementoEnParcela(desde);
    	unidadAMover.calcularItinerario(this.mapa,desde,hasta);

		this.UnidadesQueDebenMoverEnElTurno.add(unidadAMover) ;
		
			
		
	}

	public void tareaDelTurnoMoverLasUnidades() throws ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada{
    	while (!this.UnidadesQueDebenMoverEnElTurno.isEmpty()){
    		if (this.tareaDelTurnoMoverUnidad(this.UnidadesQueDebenMoverEnElTurno.getFirst()))
    			this.reinscribirLaUnidad();
    		
    		this.UnidadesQueDebenMoverEnElTurno.removeFirst();
    		
    	}
    	this.UnidadesQueDebenMoverEnElTurno = this.UnidadesQueDebenMoverEnElProximoTurno;
    	this.UnidadesQueDebenMoverEnElProximoTurno.clear();
    }

	private void reinscribirLaUnidad() {
		this.UnidadesQueDebenMoverEnElProximoTurno.add(this.UnidadesQueDebenMoverEnElTurno.getFirst());
		
	}

	private boolean tareaDelTurnoMoverUnidad(Unidad unidadAMover) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {

		Parcela parcelaPartida = this.mapa.obtenerParcelaEnCoordenada(unidadAMover.itinerario.getFirst());
		parcelaPartida.vaciarParcela();
		unidadAMover.itinerario.removeFirst();
		Parcela parcelaDestinacion = this.mapa.obtenerParcelaEnCoordenada(unidadAMover.itinerario.getFirst());
		parcelaDestinacion.guardarElemento(unidadAMover);
		
		return (unidadAMover.itinerario.size() > 1);
	}

	public void tareaDelTurnoGenerarRecursos() {
        for (Jugador j : this.jugadores)
            j.tareaDelTurnoGenerarRecursos();
	}


}
