package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import org.junit.Assert;
import org.junit.Test;

public class DepositoSuministroTest {
    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        DepositoSuministro deposito = new DepositoSuministro(unJugadorPropietario);

        Assert.assertEquals(deposito.obtenerTipoDeConstruccion(), TipoDeConstruccion.ADICIONAL_SUMINISTROS);
    }
}
