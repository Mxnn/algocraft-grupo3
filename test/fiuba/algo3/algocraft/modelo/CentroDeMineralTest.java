package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;

import org.junit.Assert;
import org.junit.Test;

public class CentroDeMineralTest {
    @Test
    public void unCentroDeMineralRecolectaMineralesYSeLosSumaAlJugadorPropietario() throws ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ExtractorMineral centroDeMineral = new CentroDeMineral(unJugadorPropietario);

        centroDeMineral.recolectarRecursos();

        Assert.assertEquals(unJugadorPropietario.getMinerales(), Jugador.MINERAL_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ExtractorMineral centroDeMineral = new CentroDeMineral(unJugadorPropietario);

        Assert.assertEquals(centroDeMineral.getTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_MINERAL);
    }
}
