package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.terran.unidades.Espectro;
import fiuba.algo3.algocraft.terran.unidades.Golliat;
import fiuba.algo3.algocraft.terran.unidades.Marine;
import fiuba.algo3.algocraft.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.terran.unidades.NaveTransporteTerran;

import org.junit.Assert;
import org.junit.Test;

public class NaveTransporteTerranTest {
    @Test
    public void insertarUnidadInsertaLaUnidadEnLaNave() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);

        nave.insertarUnidad(new Marine(unJugador));

        Assert.assertEquals(nave.cantidadDeUnidades(), 1);
    }

    @Test(expected = ExcepcionNaveDeTransporteLlena.class)
    public void insertarUnidadLanzaExcepcionSiLaNaveEstaLlena() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);

        for (int i = 1; i <= 4; i++) {
            nave.insertarUnidad(new Golliat(unJugador));
        }

        nave.insertarUnidad(new Marine(unJugador));
    }

    @Test
    public void destruirNaveDestruyeTodasLasUnidadesQueHayEnSuInterior() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);

        for (int i = 1; i <= 4; i++) {
            nave.insertarUnidad(new Golliat(unJugador));
        }

        nave.recibirDanyo(NaveTransporteTerran.VIDA_INICIAL + 1);

        Assert.assertEquals(unJugador.getCantidadDeUnidades(), 0);
        Assert.assertEquals(unJugador.getPoblacion(), 0);
    }

    @Test(expected = ExcepcionNoEsUnidadTerrestre.class)
    public void ingresarUnEspectroLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);
        Espectro espectro = new Espectro(unJugador);

        nave.insertarUnidad(espectro);
    }

    @Test(expected = ExcepcionNoEsUnidadTerrestre.class)
    public void ingresarUnaNaveCienciaLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);
        NaveCiencia naveCiencia = new NaveCiencia(unJugador);

        nave.insertarUnidad(naveCiencia);
    }

    @Test(expected = ExcepcionNoEsUnidadTerrestre.class)
    public void ingresarUnaNaveTransporteLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador);
        NaveTransporteTerran nave2 = new NaveTransporteTerran(unJugador);

        nave.insertarUnidad(nave2);
    }
}
