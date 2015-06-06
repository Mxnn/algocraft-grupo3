package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;
import fiuba.algo3.algocraft.ConstruccionesProtoss.Asimilador;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;

public class AsimiladorTest {

	@Test
	 public void unAsimiladorAbsorbeGasVespenoYSeLoSumaAlJugadorPropietario() {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorGas asimilador = new Asimilador(unJugadorPropietario);

        asimilador.absorberGasVespeno();

        Assert.assertEquals(unJugadorPropietario.obtenerGasVespeno(), Jugador.GAS_VESPENO_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorGas asimilador = new Asimilador(unJugadorPropietario);

        Assert.assertEquals(asimilador.obtenerTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_GAS);
    }

}
