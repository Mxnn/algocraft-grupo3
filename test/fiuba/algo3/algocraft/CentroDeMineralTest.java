package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import org.junit.Assert;
import org.junit.Test;

public class CentroDeMineralTest {
    @Test
    public void unCentroDeMineralRecolectaMineralesYSeLosSumaAlJugadorPropietario() {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ParcelaMineral parcela = new ParcelaMineral(new Coordenada(1, 1));
        ExtractorMineral centroDeMineral = new CentroDeMineral(unJugadorPropietario, parcela);

        centroDeMineral.recolectarMinerales();

        Assert.assertEquals(unJugadorPropietario.obtenerMineral(), Jugador.MINERAL_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ParcelaMineral parcela = new ParcelaMineral(new Coordenada(1, 1));
        ExtractorMineral centroDeMineral = new CentroDeMineral(unJugadorPropietario, parcela);

        Assert.assertEquals(centroDeMineral.obtenerTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_MINERAL);
    }
}
