package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.terran.construcciones.DepositoSuministro;

import org.junit.Assert;
import org.junit.Test;

public class DepositoSuministroTest {
    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        DepositoSuministro deposito = new DepositoSuministro(unJugadorPropietario);

        Assert.assertEquals(deposito.obtenerTipoDeConstruccion(), TipoDeConstruccion.ADICIONAL_SUMINISTROS);
    }
}
