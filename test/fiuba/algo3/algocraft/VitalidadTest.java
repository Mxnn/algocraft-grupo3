package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import org.junit.Assert;
import org.junit.Test;

public class VitalidadTest {
    @Test
    public void recibirDanyoRestaElDanyoDelEstado() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int danyoHecho = 50;
        Vitalidad vitalidad = new Vitalidad(vidaInicial);

        vitalidad.recibirDanyo(danyoHecho);

        Assert.assertEquals(vitalidad.getVida(), vidaInicial - danyoHecho);
    }

    @Test(expected = ExcepcionEstadoMuerto.class)
    public void siElDanyoRecibidoEsMayorALaVidaDelEstadoLanzaExcepcion() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int danyoHecho = 250;
        Vitalidad vitalidad = new Vitalidad(vidaInicial);

        vitalidad.recibirDanyo(danyoHecho);
    }
}
