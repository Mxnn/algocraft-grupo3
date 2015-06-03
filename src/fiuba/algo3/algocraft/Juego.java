package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;

import java.util.ArrayList;

public class Juego {
    //EL CODIGO COMENTADO ES EL CODIGO PARA EL SINGLETON DE LA CLASE (NECESITO "LIMPIAR" EL OBJETO CLASE PARA BORRAR LOS USUARIOS "INSCRIPTOS")
    //private static Juego INSTANCIA = null;
    private static int LONGITUD_MINIMA_PARA_EL_NOMBRE = 4;
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    /*
    private Juego() { }

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

    public void crearJugador(String nombre, Color color, Raza raza) throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNombreCorto {
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
}
