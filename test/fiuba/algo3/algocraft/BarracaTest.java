package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import org.junit.Assert;
import org.junit.Test;

public class BarracaTest {
    @Test
    public void crearMarineCreaUnMarine() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro();
        Barraca barraca = new Barraca(unJugador);

        Assert.assertNotNull(barraca.crearMarine());
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro();
        Barraca barraca = new Barraca(unJugador);

        Assert.assertEquals(barraca.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_SOLDADOS);
    }
}
