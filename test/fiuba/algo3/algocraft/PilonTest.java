package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionNombreCorto;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.protoss.construcciones.Pilon;

public class PilonTest {

	@Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Pilon pilon = new Pilon(unJugadorPropietario);

        Assert.assertEquals(pilon.getTipoDeConstruccion(), TipoDeConstruccion.ADICIONAL_SUMINISTROS);
    }
}
