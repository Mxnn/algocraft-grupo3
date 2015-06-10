package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;

import org.junit.Assert;
import org.junit.Test;

public class PuertoEstelarTest {
    @Test
    public void crearEspectroCreaEspectro() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);

        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(1, 2));
        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 2));

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));

        Assert.assertNotNull(puerto.crearEspectro(mapa));
    }

    @Test
    public void crearNaveDeTransporteCreaNaveDeTransporte() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 1));
        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 3));

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertNotNull(puerto.crearNaveTransporte(mapa));
    }

    @Test
    public void crearNaveCienciaCreaUnaNaveCiencia() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 1));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(1, 2));
        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 2));

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertNotNull(puerto.crearNaveCiencia(mapa));
    }

    @Test
     public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(1, 1));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 1));
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        Assert.assertEquals(puerto.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS);
    }
}
