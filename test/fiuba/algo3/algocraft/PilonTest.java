package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.Pilon;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;

public class PilonTest {

	@Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Pilon pilon = new Pilon(unJugadorPropietario);

        Assert.assertEquals(pilon.obtenerTipoDeConstruccion(), TipoDeConstruccion.ADICIONAL_SUMINISTROS);
    }
}