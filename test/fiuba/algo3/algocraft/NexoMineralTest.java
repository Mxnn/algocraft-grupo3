package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionNombreCorto;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.protoss.construcciones.NexoMineral;

public class NexoMineralTest {

	@Test
    public void unNexoMineralRecolectaMineralesYSeLosSumaAlJugadorPropietario() throws ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorMineral nexoMineral = new NexoMineral(unJugadorPropietario);

        nexoMineral.collectarRecursos();

        Assert.assertEquals(unJugadorPropietario.getMinerales(), Jugador.MINERAL_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorMineral nexoMineral = new NexoMineral(unJugadorPropietario);
        
        Assert.assertEquals(nexoMineral.getTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_MINERAL);
    }
}
