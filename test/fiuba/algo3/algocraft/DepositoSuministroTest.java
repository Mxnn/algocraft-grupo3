package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNumeroDeBasesInvalido;
import org.junit.Assert;
import org.junit.Test;

public class DepositoSuministroTest {
    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Coordenada coordenada = new Coordenada(3, 3);
        Parcela parcela = mapa.obtenerParcelaEnCoordenada(coordenada);
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        DepositoSuministro deposito = new DepositoSuministro(unJugadorPropietario, parcela);

        Assert.assertEquals(deposito.obtenerTipoDeConstruccion(), TipoDeConstruccion.ADICIONAL_SUMINISTROS);
    }
}
