package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;
import fiuba.algo3.algocraft.utilidades.unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {
    @Test
    public void crearJugadorConNombreAgregaJugadorAlJuego() throws ExcepcionColorEnUso, ExcepcionNombreEnUso, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNumeroDeBasesInvalido {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Pedro", Color.VERDE, Protoss.getInstance());

        Assert.assertEquals(juego.getCantidadDeJugadores(), 2);
    }

    @Test(expected = ExcepcionNombreEnUso.class)
    public void crearJugadoresConNombresIgualesLanzaExcepcionNombreEnUso() throws ExcepcionColorEnUso, ExcepcionNombreEnUso, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNumeroDeBasesInvalido {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Juan", Color.VERDE, Protoss.getInstance());
    }

    @Test(expected = ExcepcionColorEnUso.class)
    public void crearJugadoresConColoresIgualesLanzaExcepcionColorEnUso() throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNumeroDeBasesInvalido {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Pedro", Color.ROJO, Protoss.getInstance());
    }

    @Test(expected = ExcepcionAlcanzadoElMaximoCupoDeJugadores.class)
    public void crearTresJugadoresLanzaExcepcion() throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNombreCorto, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNumeroDeBasesInvalido {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Pablo", Color.AZUL, Terran.getInstance());
        juego.crearJugador("Carlos", Color.VERDE, Terran.getInstance());
    }

    @Test
    public void llamandoElMetodoCalcularItinerarioSeHaceUnaListaDeParcelaEnLaUnidad() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 10, 10);
        Coordenada desde = new Coordenada(5, 5);
        Coordenada hasta = new Coordenada(8, 8);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(2, 2));
        Unidad golliat = new Golliat(unJugador);
        mapa.ubicarElementoEnParcela(desde, golliat);

    	golliat.calcularItinerario(mapa, desde, hasta);

    	Assert.assertNotNull(golliat.getItinerario());
    }
    
    @Test
    public void llamandoAMoverUnidadSeAgregaUnaUnidadEnLaListUnidadAMoverEnElTurno() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNoHaySuministrosDisponibles, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
    	Juego elJuego = new Juego();
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
    	
    	unJugador.crearAdicionalDeSuministro(elJuego.getMapa(), new Coordenada(1, 1));

    	Coordenada desde = new Coordenada(3,3);
    	Coordenada hasta = new Coordenada (4,3);
    	

    	elJuego.getMapa().ubicarElementoEnParcela(desde,new Marine(unJugador));
 
    	elJuego.moverUnidad(desde, hasta);
    	
    	Assert.assertEquals(elJuego.getListDeUnidadesQueDebenMoverEnElTurno().size(),1);
    }
    
    @Test
    public void unaUnidadSeMueveSiEsEnLaListDeUnidadesAMover() throws ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionNombreCorto {
    	Juego elJuego = new Juego();
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
   	  	unJugador.crearAdicionalDeSuministro(elJuego.getMapa(), new Coordenada(1, 1));
    	Coordenada desde = new Coordenada(2,2);
    	Coordenada hasta = new Coordenada (3,2);
    	elJuego.getMapa().ubicarElementoEnParcela(desde,new Marine(unJugador));
    	elJuego.moverUnidad(desde, hasta);
    	
    	elJuego.tareaDelTurnoMoverLasUnidades();

    	Assert.assertTrue(elJuego.getMapa().obtenerParcelaEnCoordenada(desde).estaVacia());
    }
}
