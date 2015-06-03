package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import org.junit.Assert;
import org.junit.Test;

public class BarracaTest {
    @Test
    public void crearMarineCreaUnMarine() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Barraca barraca = new Barraca(unJugador);

        Assert.assertNotNull(barraca.crearMarine());
    }
}
