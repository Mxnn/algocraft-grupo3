package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import org.junit.Assert;
import org.junit.Test;

public class RefineriaTest {
    @Test
    public void unaRefineriaAbsorbeGasVespenoYSeLoSumaAlJugadorPropietario() {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ExtractorGas refineria = new Refineria(unJugadorPropietario);

        refineria.absorberGasVespeno();

        Assert.assertEquals(unJugadorPropietario.obtenerGasVespeno(), Jugador.GAS_VESPENO_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ExtractorGas refineria = new Refineria(unJugadorPropietario);

        Assert.assertEquals(refineria.obtenerTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_GAS);
    }
}
