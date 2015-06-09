package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;

import java.util.ArrayList;
import java.util.LinkedList;


public class Juego {
    //EL CODIGO COMENTADO ES EL CODIGO PARA EL SINGLETON DE LA CLASE (NECESITO "LIMPIAR" EL OBJETO CLASE PARA BORRAR LOS USUARIOS "INSCRIPTOS")
    //private static Juego INSTANCIA = null;
    private static int LONGITUD_MINIMA_PARA_EL_NOMBRE = 4;
    private static int MAXIMO_NUMERO_DE_JUGADORES = 2;

    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    public Mapa mapa ;
    public LinkedList<Unidad> UnidadesQueDebenMoverEnElTurno = new LinkedList<Unidad>();
    public LinkedList<Unidad> UnidadesQueDebenMoverEnElProximoTurno = new LinkedList<Unidad>();
    
    public Juego() throws ExcepcionNumeroDeBasesInvalido { 
    	mapa = new Mapa (2,5,5); 
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

    public void crearJugador(String nombre, Color color, Raza raza) throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores {
        if (jugadores.size() == MAXIMO_NUMERO_DE_JUGADORES)
            throw new ExcepcionAlcanzadoElMaximoCupoDeJugadores();

        if (nombre.length() < LONGITUD_MINIMA_PARA_EL_NOMBRE)
            throw new ExcepcionNombreCorto();

        if (this.elNombreEstaEnUso(nombre))
            throw new ExcepcionNombreEnUso();

        if (this.elColorEstaEnUso(color))
            throw new ExcepcionColorEnUso();

        Jugador nuevoJugador = new Jugador(nombre, color, raza);

        jugadores.add(nuevoJugador);
    }

    public int cantidadDeJugadores() {
        return jugadores.size();
    }

    private boolean elNombreEstaEnUso(String nombre) {
        for (Jugador jugador : jugadores) {
            if ( (jugador.obtenerNombre()).equals(nombre) ) {
               return true;
            }
        }
        return false;
    }

    private boolean elColorEstaEnUso(Color color) {
        for (Jugador jugador : jugadores) {
            if (jugador.obtenerColor() == color) {
                return true;
            }
        }
        return false;
    }
    

	public void moverUnidad(Coordenada desde, Coordenada hasta) throws ExcepcionCoordenadaFueraDelMapa{
	//	if (this.devolverElementoEnParcela(desde) != Unidad.class) 
	//			throw new ExcepcionNoEsUnaUnidad();
		
		this.mapa.calcularItinerario(desde, hasta);
		this.UnidadesQueDebenMoverEnElTurno.add((Unidad) this.mapa.devolverElementoEnParcela(desde)) ;
		
			
		
	}

}
