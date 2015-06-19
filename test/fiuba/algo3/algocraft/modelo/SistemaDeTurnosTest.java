package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.juego.SistemaDeTurnos;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.protoss.Protoss;

public class SistemaDeTurnosTest {
    @Test
    public void enUnSistemaDeTurnosSiempreComienzaJugandoElPrimerJugadorDeLaLista() throws ExcepcionNombreCorto, ExcepcionNumeroDeBasesInvalido {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador juan = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Jugador pedro = new Jugador("Pedro", Color.ROJO, Protoss.getInstance());
        jugadores.add(juan);
        jugadores.add(pedro);
        SistemaDeTurnos sistema = new SistemaDeTurnos(jugadores,new Mapa(2,5,5));

        Assert.assertSame(juan, sistema.getJugadorQueJuega());
    }

    @Test
    public void pasarTurnoHaceQueJuegueElOtroJugador() throws ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionNumeroDeBasesInvalido, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador juan = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Jugador pedro = new Jugador("Pedro", Color.ROJO, Protoss.getInstance());
        jugadores.add(juan);
        jugadores.add(pedro);
        SistemaDeTurnos sistema = new SistemaDeTurnos(jugadores,new Mapa(2,5,5));

        sistema.pasarTurno(juan);

        Assert.assertSame(pedro, sistema.getJugadorQueJuega());
    }

    @Test(expected = ExcepcionNoEsElTurnoDelJugador.class)
    public void pasarTurnoLanzaExcepcionSiElQuePasaElTurnoNoEsElJugadorQueDebeJugar() throws ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionNumeroDeBasesInvalido, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        Jugador juan = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Jugador pedro = new Jugador("Pedro", Color.ROJO, Protoss.getInstance());
        jugadores.add(juan);
        jugadores.add(pedro);
        SistemaDeTurnos sistema = new SistemaDeTurnos(jugadores,new Mapa(2,5,5));

        sistema.pasarTurno(pedro);
    }
    
    
    
}
