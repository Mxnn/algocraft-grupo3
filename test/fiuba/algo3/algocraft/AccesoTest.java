package fiuba.algo3.algocraft;

import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.Acceso;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.RazaProtoss.Dragon;
import fiuba.algo3.algocraft.RazaProtoss.Zealot;

import org.junit.Assert;

public class AccesoTest {
    @Test
    public void crearZealotCreaUnZealot() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.crearAdicionalDeSuministro();
        Acceso acceso = new Acceso(unJugador);

        Assert.assertTrue(acceso.crearZealot() instanceof Zealot);
    }
    
    @Test
    public void crearDragonCreaUnDragon() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.crearAdicionalDeSuministro();
        Acceso acceso = new Acceso(unJugador);

        Assert.assertTrue(acceso.crearDragon() instanceof Dragon);
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro();
        Acceso acceso = new Acceso(unJugador);

        Assert.assertEquals(acceso.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_SOLDADOS);
    }
}
