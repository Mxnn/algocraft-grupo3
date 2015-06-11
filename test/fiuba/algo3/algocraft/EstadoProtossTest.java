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

        Assert.assertEquals(estado.getVida(), vidaInicial);
        Assert.assertEquals(estado.getEscudo(), escudoInicial - danyoHecho);
    }

    @Test
    public void recibirDanyoMayorAlEscudoDejaAlEscudoEnCeroYComienzaARestarLaVida() throws ExcepcionEstadoMuerto {
        int vidaInicial = 200;
        int escudoInicial = 100;
        int danyoHecho = 150;
        EstadoProtoss estado = new EstadoProtoss(vidaInicial, escudoInicial);

        estado.recibirDanyo(danyoHecho);

        Assert.assertEquals(estado.getVida(), vidaInicial + escudoInicial - danyoHecho );
        Assert.assertEquals(estado.getEscudo(), 0);
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
