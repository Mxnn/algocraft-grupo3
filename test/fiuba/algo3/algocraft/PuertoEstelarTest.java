package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import org.junit.Assert;
import org.junit.Test;

public class PuertoEstelarTest {
    @Test
    public void crearEspectroCreaEspectro() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        unJugador.crearAdicionalDeSuministro();

        Assert.assertNotNull(puerto.crearEspectro());
    }

    @Test
    public void crearNaveDeTransporteCreaNaveDeTransporte() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        unJugador.crearAdicionalDeSuministro();

        Assert.assertNotNull(puerto.crearNaveTransporte());
    }

    @Test
    public void crearNaveCienciaCreaUnaNaveCiencia() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        unJugador.crearAdicionalDeSuministro();

        Assert.assertNotNull(puerto.crearNaveCiencia());
    }

    @Test
     public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        Assert.assertEquals(puerto.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS);
    }
}
