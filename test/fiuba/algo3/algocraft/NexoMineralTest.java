package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.protoss.construcciones.NexoMineral;

public class NexoMineralTest {

	@Test
    public void unNexoMineralRecolectaMineralesYSeLosSumaAlJugadorPropietario() {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorMineral nexoMineral = new NexoMineral(unJugadorPropietario);

        nexoMineral.collectarRecursos();

        Assert.assertEquals(unJugadorPropietario.obtenerMineral(), Jugador.MINERAL_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorMineral nexoMineral = new NexoMineral(unJugadorPropietario);
        
        Assert.assertEquals(nexoMineral.obtenerTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_MINERAL);
    }
}
