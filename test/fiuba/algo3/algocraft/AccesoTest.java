package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.Acceso;

import org.junit.Assert;

public class AccesoTest {
    @Test
    public void crearZealotCreaUnZealot() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1 ,1));
        Acceso acceso = new Acceso(unJugador);

        Assert.assertNotNull(acceso.crearZealot());
    }
    
    @Test
    public void crearDragonCreaUnDragon() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Acceso acceso = new Acceso(unJugador);

        Assert.assertNotNull(acceso.crearDragon());
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Acceso acceso = new Acceso(unJugador);

        Assert.assertEquals(acceso.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_SOLDADOS);
    }
}
