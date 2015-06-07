package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import org.junit.Assert;
import org.junit.Test;

public class EstadoProtossTest {
    @Test
    public void recibirDanyoRestaElDanyoPrimeroDelEscudo() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int escudoInicial = 100;
        int danyoHecho = 50;
        EstadoProtoss estado = new EstadoProtoss(vidaInicial, escudoInicial);

        estado.recibirDanyo(danyoHecho);

        Assert.assertEquals(estado.obtenerVida(), vidaInicial);
        Assert.assertEquals(estado.obtenerEscudo(), escudoInicial - danyoHecho);
    }

    @Test
    public void recibirDanyoMayorAlEscudoDejaAlEscudoEnCeroYComienzaARestarLaVida() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int escudoInicial = 100;
        int danyoHecho = 150;
        EstadoProtoss estado = new EstadoProtoss(vidaInicial, escudoInicial);

        estado.recibirDanyo(danyoHecho);

        Assert.assertEquals(estado.obtenerVida(), vidaInicial + escudoInicial - danyoHecho );
        Assert.assertEquals(estado.obtenerEscudo(), 0);
    }

    @Test(expected = ExcepcionEstadoMuerto.class)
    public void recibirDanyoLanzaExcepcionSiElDanyoEsMayorOIgualALaVidaYAlEscudoSumados() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int escudoInicial = 100;
        int danyoHecho = 350;
        EstadoProtoss estado = new EstadoProtoss(vidaInicial, escudoInicial);

        estado.recibirDanyo(danyoHecho);
    }
}
