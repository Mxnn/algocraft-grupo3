package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Pilon;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;

public class PilonTest {

	@Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Pilon pilon = new Pilon(unJugadorPropietario);

        Assert.assertEquals(pilon.getTipoDeConstruccion(), TipoDeConstruccion.ADICIONAL_SUMINISTROS);
    }
}
