package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import org.junit.Assert;
import org.junit.Test;

public class EstadoTest {
    @Test
    public void recibirDanyoRestaElDanyoDelEstado() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int danyoHecho = 50;
        Estado estado = new Estado(vidaInicial);

        estado.recibirDanyo(danyoHecho);

        Assert.assertEquals(estado.obtenerVida(), vidaInicial - danyoHecho);
    }

    @Test(expected = ExcepcionEstadoMuerto.class)
    public void siElDanyoRecibidoEsMayorALaVidaDelEstadoLanzaExcepcion() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int danyoHecho = 250;
        Estado estado = new Estado(vidaInicial);

        estado.recibirDanyo(danyoHecho);
    }
}
