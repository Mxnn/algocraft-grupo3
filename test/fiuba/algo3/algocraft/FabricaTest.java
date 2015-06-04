package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import org.junit.Assert;
import org.junit.Test;

public class FabricaTest {
    @Test
    public void crearGolliatCreaUnGolliat() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados();
        Fabrica fabrica = new Fabrica(unJugador);

        Assert.assertNotNull(fabrica.crearGolliat());
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearCreadorDeSoldados();
        Fabrica fabrica = new Fabrica(unJugador);

        Assert.assertEquals(fabrica.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES);
    }
}
