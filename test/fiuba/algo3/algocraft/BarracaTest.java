package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;

import org.junit.Assert;
import org.junit.Test;

public class BarracaTest {
    @Test
    public void crearMarineCreaUnMarine() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        Barraca barraca = new Barraca(unJugador);

        Assert.assertNotNull(barraca.crearMarine());
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        Barraca barraca = new Barraca(unJugador);

        Assert.assertEquals(barraca.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_SOLDADOS);
    }
}
