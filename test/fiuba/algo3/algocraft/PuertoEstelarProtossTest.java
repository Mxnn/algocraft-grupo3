package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public class PuertoEstelarProtossTest {

	 @Test
	    public void crearScoutCreaScout() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
	        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.crearCreadorDeSoldados();
	        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(unJugador);

	        unJugador.crearAdicionalDeSuministro();

	        Assert.assertNotNull(puerto.crearScout());
	    }

	    @Test
	    public void crearNaveDeTransportePCreaNaveDeTransporteP() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
	    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.crearCreadorDeSoldados();
	        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(unJugador);

	        unJugador.crearAdicionalDeSuministro();

	        Assert.assertNotNull(puerto.crearNaveTransporte());
	    }

	    @Test
	     public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
	    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.crearCreadorDeSoldados();
	        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(unJugador);

	        Assert.assertEquals(puerto.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS);
	    }

}
