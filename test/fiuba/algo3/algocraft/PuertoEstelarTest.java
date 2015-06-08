package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;

import org.junit.Assert;
import org.junit.Test;

public class PuertoEstelarTest {
    @Test
    public void crearEspectroCreaEspectro() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);

        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertNotNull(puerto.crearEspectro());
    }

    @Test
    public void crearNaveDeTransporteCreaNaveDeTransporte() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertNotNull(puerto.crearNaveTransporte());
    }

    @Test
    public void crearNaveCienciaCreaUnaNaveCiencia() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Assert.assertNotNull(puerto.crearNaveCiencia());
    }

    @Test
     public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        Assert.assertEquals(puerto.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS);
    }
}
