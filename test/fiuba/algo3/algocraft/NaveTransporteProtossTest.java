package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.RazaProtoss.Dragon;
import fiuba.algo3.algocraft.RazaProtoss.NaveTransporteProtoss;
import fiuba.algo3.algocraft.RazaTerran.Marine;

import org.junit.Assert;
import org.junit.Test;

public class NaveTransporteProtossTest {
    @Test
    public void insertarUnidadInsertaLaUnidadEnLaNave() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);
        nave.insertarUnidad(new Dragon(unJugador));

        Assert.assertEquals(nave.cantidadDeUnidades(), 1);
    }

    @Test(expected = ExcepcionNaveDeTransporteLlena.class)
    public void insertarUnidadLanzaExcepcionSiLaNaveEstaLlena() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(2, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);

        for (int i = 1; i <= 4; i++) {
            nave.insertarUnidad(new Dragon(unJugador));
        }

        nave.insertarUnidad(new Marine(unJugador));
    }

    @Test
    public void destruirNaveDestruyeTodasLasUnidadesQueHayEnSuInterior() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(2, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);

        for (int i = 1; i <= 2; i++) {
            nave.insertarUnidad(new Dragon(unJugador));
        }

        nave.recibirDanyo(NaveTransporteProtoss.VIDA_INICIAL + NaveTransporteProtoss.ESCUDO_INICIAL + 1);

        Assert.assertEquals(unJugador.cantidadDeUnidades(), 0);
        Assert.assertEquals(unJugador.obtenerPoblacion(), 0);
    }

    @Test(expected = ExcepcionUnidadEnemiga.class)
    public void ingresarUnaUnidadEnemigaEnLaNaveLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador unJugador2 = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);

        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);

        nave.insertarUnidad(new Dragon(unJugador2));
    }
}