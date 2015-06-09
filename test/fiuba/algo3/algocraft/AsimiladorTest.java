package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.Asimilador;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;

public class AsimiladorTest {

	@Test
	 public void unAsimiladorAbsorbeGasVespenoYSeLoSumaAlJugadorPropietario() {
        ParcelaVolcan parcela = new ParcelaVolcan(new Coordenada(0, 0));
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorGas asimilador = new Asimilador(unJugadorPropietario, parcela);

        asimilador.absorberGasVespeno();

        Assert.assertEquals(unJugadorPropietario.obtenerGasVespeno(), Jugador.GAS_VESPENO_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        ParcelaVolcan parcela = new ParcelaVolcan(new Coordenada(0, 0));
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorGas asimilador = new Asimilador(unJugadorPropietario, parcela);

        Assert.assertEquals(asimilador.obtenerTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_GAS);
    }

}
