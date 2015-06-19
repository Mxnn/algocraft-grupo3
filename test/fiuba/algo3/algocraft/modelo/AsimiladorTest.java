package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.construcciones.Asimilador;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;

public class AsimiladorTest {

	@Test
	 public void unAsimiladorAbsorbeGasVespenoYSeLoSumaAlJugadorPropietario() throws ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorGas asimilador = new Asimilador(unJugadorPropietario);

        asimilador.recolectarRecursos();
        Assert.assertEquals(unJugadorPropietario.getGasVespeno(), Jugador.GAS_VESPENO_INICIAL + 10);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        ExtractorGas asimilador = new Asimilador(unJugadorPropietario);

        Assert.assertEquals(asimilador.getTipoDeConstruccion(), TipoDeConstruccion.EXTRACTOR_GAS);
    }

}
