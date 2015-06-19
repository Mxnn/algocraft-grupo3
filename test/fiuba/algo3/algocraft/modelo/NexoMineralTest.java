package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.razas.protoss.construcciones.NexoMineral;

public class NexoMineralTest {

	@Test
    public void unNexoMineralRecolectaMineralesYSeLosSumaAlJugadorPropietario() throws ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorMineral nexoMineral = new NexoMineral(unJugadorPropietario);

        nexoMineral.recolectarRecursos();

        Assert.assertEquals(unJugadorPropietario.getMinerales(), Jugador.MINERAL_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorMineral nexoMineral = new NexoMineral(unJugadorPropietario);
        
        Assert.assertEquals(nexoMineral.getTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_MINERAL);
    }
}
