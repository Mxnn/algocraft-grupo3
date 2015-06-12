package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.protoss.construcciones.Acceso;

import org.junit.Test;
import org.junit.Assert;

public class AccesoTest {
    @Test
    public void crearZealotCreaUnZealot() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);

        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1 ,1));
        Acceso acceso = (Acceso) unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));

        Assert.assertNotNull(acceso.crearZealot(mapa));
    }
    
    @Test
    public void crearDragonCreaUnDragon() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);

        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Acceso acceso = (Acceso) unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));

        Assert.assertNotNull(acceso.crearDragon(mapa));
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Acceso acceso = new Acceso(unJugador);

        Assert.assertEquals(acceso.getTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_SOLDADOS);
    }
}
