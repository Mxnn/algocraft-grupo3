package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.terran.construcciones.CentroDeMineral;

import org.junit.Assert;
import org.junit.Test;

public class CentroDeMineralTest {
    @Test
    public void unCentroDeMineralRecolectaMineralesYSeLosSumaAlJugadorPropietario() {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ExtractorMineral centroDeMineral = new CentroDeMineral(unJugadorPropietario);

        centroDeMineral.collectarRecursos();

        Assert.assertEquals(unJugadorPropietario.getMinerales(), Jugador.MINERAL_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ExtractorMineral centroDeMineral = new CentroDeMineral(unJugadorPropietario);

        Assert.assertEquals(centroDeMineral.getTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_MINERAL);
    }
}
