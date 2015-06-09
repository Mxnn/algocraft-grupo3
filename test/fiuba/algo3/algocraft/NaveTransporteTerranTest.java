package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.RazaTerran.Golliat;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import fiuba.algo3.algocraft.RazaTerran.NaveTransporteTerran;

import org.junit.Assert;
import org.junit.Test;

public class NaveTransporteTerranTest {
    @Test
    public void insertarUnidadInsertaLaUnidadEnLaNave() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Parcela parcela = new ParcelaTierra(new Coordenada(0,0));
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador, parcela);

        nave.insertarUnidad(new Marine(unJugador, new ParcelaTierra(new Coordenada(1,0))));

        Assert.assertEquals(nave.cantidadDeUnidades(), 1);
    }

    @Test(expected = ExcepcionNaveDeTransporteLlena.class)
    public void insertarUnidadLanzaExcepcionSiLaNaveEstaLlena() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));
        Parcela parcela = new ParcelaTierra(new Coordenada(0,0));
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador, parcela);

        for (int i = 1; i <= 4; i++) {
            nave.insertarUnidad(new Golliat(unJugador, new ParcelaTierra(new Coordenada(1,0))));
        }

        nave.insertarUnidad(new Marine(unJugador, new ParcelaTierra(new Coordenada(0,1))));
    }

    @Test
    public void destruirNaveDestruyeTodasLasUnidadesQueHayEnSuInterior() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));
        Parcela parcela = new ParcelaTierra(new Coordenada(0,0));
        NaveTransporteTerran nave = new NaveTransporteTerran(unJugador, parcela);

        for (int i = 1; i <= 4; i++) {
            nave.insertarUnidad(new Golliat(unJugador, new ParcelaTierra(new Coordenada(2,2))));
        }

        nave.recibirDanyo(NaveTransporteTerran.VIDA_INICIAL + 1);

        Assert.assertEquals(unJugador.cantidadDeUnidades(), 0);
        Assert.assertEquals(unJugador.obtenerPoblacion(), 0);
    }
}
