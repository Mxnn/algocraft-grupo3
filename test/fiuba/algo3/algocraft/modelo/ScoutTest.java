package fiuba.algo3.algocraft.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaVacia;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadParaDeMover;
import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Scout;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;

public class ScoutTest {

	@Test
	public void atacarRestaVidaATerrestre() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionParcelaVacia, ExcepcionUnidadParaDeMover {
	    Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
		Mapa mapa = new Mapa(2, 5, 5);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
	    UnidadAgresora scout = new Scout(unJugador);
        while(!scout.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
        unJugador.terminarTurno(juego);

	    Interactuable marine = new Marine(unJugador2);
        while(!marine.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(1,0), marine);
        unJugador2.terminarTurno(juego);

	    scout.atacar(marine.getParcela());
        unJugador.terminarTurno(juego);

	    assertEquals(marine.getVida(), 40-8);
	}

	@Test
	public void atacarRestaVidaAVolador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionParcelaVacia, ExcepcionUnidadParaDeMover {
		Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
		Mapa mapa = new Mapa(2, 5, 5);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
	    UnidadAgresora scout = new Scout(unJugador);
        while(!scout.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
        unJugador.terminarTurno(juego);

	    Interactuable espectro = new Espectro(unJugador2);
        while(!espectro.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(1,0), espectro);
        unJugador2.terminarTurno(juego);

	    scout.atacar(espectro.getParcela());
        unJugador.terminarTurno(juego);

	    assertEquals(espectro.getVida(), 120-14);
	}

	@Test
	public void atacarFueraDeRangoEnTierraLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionParcelaVacia {
		Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	    Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
		Mapa mapa = new Mapa(2, 6, 6);
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
	    unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	    unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
	    for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
	    UnidadAgresora scout = new Scout(unJugador);
        while(!scout.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
        unJugador.terminarTurno(juego);

	    Marine marine = new Marine(unJugador2);
        while(!marine.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
	    mapa.ubicarElementoEnParcela(new Coordenada(5,0), marine);
        unJugador2.terminarTurno(juego);

	    scout.atacar(marine.getParcela());
        unJugador.terminarTurno(juego);
        assertEquals(marine.getVida(),Marine.VIDA_INICIAL );
	}

    @Test
    public void atacarFueraDeRangoEnAireNoDanya() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionParcelaVacia {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        Mapa mapa = new Mapa(2, 6, 6);
        unJugador.sumarGasVespeno(999);
        unJugador.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        UnidadAgresora scout = new Scout(unJugador);
        while(!scout.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(0,0), scout);
        unJugador.terminarTurno(juego);

        Espectro espectro = new Espectro(unJugador2);
        while(!espectro.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(0,5), espectro);
        unJugador2.terminarTurno(juego);

        scout.atacar(espectro.getParcela());
        unJugador.terminarTurno(juego);
        assertEquals(espectro.getVida(),Espectro.VIDA_INICIAL );
    }
    

}
