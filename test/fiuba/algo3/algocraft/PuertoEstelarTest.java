package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import org.junit.Assert;
import org.junit.Test;

public class PuertoEstelarTest {
    @Test
    public void crearEspectroCreaEspectro() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        Assert.assertNotNull(puerto.crearEspectro());
    }

    @Test
    public void crearNaveDeTransporteCreaNaveDeTransporte() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

        Assert.assertNotNull(puerto.crearNaveTransporte());
    }

    @Test
    public void crearNaveCienciaCreaUnaNaveCiencia() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesTerrestres();
        PuertoEstelar puerto = new PuertoEstelar(unJugador);

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
