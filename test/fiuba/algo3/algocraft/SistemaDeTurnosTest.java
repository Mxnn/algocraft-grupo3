package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.juego.SistemaDeTurnos;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.terran.Terran;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SistemaDeTurnosTest {
    @Test
    public void enUnSistemaDeTurnosSiempreComienzaJugandoElPrimerJugadorDeLaLista() throws ExcepcionNombreCorto {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador juan = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Jugador pedro = new Jugador("Pedro", Color.ROJO, Protoss.getInstance());
        jugadores.add(juan);
        jugadores.add(pedro);
        SistemaDeTurnos sistema = new SistemaDeTurnos(jugadores);

        Assert.assertSame(juan, sistema.getJugadorQueJuega());
    }

    @Test
    public void pasarTurnoHaceQueJuegueElOtroJugador() throws ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador juan = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Jugador pedro = new Jugador("Pedro", Color.ROJO, Protoss.getInstance());
        jugadores.add(juan);
        jugadores.add(pedro);
        SistemaDeTurnos sistema = new SistemaDeTurnos(jugadores);

        sistema.pasarTurno(juan);

        Assert.assertSame(pedro, sistema.getJugadorQueJuega());
    }

    @Test(expected = ExcepcionNoEsElTurnoDelJugador.class)
    public void pasarTurnoLanzaExcepcionSiElQuePasaElTurnoNoEsElJugadorQueDebeJugar() throws ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador juan = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Jugador pedro = new Jugador("Pedro", Color.ROJO, Protoss.getInstance());
        jugadores.add(juan);
        jugadores.add(pedro);
        SistemaDeTurnos sistema = new SistemaDeTurnos(jugadores);

        sistema.pasarTurno(pedro);
    }
}
