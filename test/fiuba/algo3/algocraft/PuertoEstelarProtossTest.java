package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;

public class PuertoEstelarProtossTest {

	 @Test
	    public void crearScoutCreaScout() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes {
	        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
	      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
	        unJugador.crearCreadorDeSoldados();
	        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(unJugador);

	        unJugador.crearAdicionalDeSuministro();

	        Assert.assertNotNull(puerto.crearScout());
	    }

	    @Test
	    public void crearNaveDeTransportePCreaNaveDeTransporteP() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes {
	    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
	      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);     
	    	
	    	unJugador.crearCreadorDeSoldados();
	        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(unJugador);

	        unJugador.crearAdicionalDeSuministro();

	        Assert.assertNotNull(puerto.crearNaveTransporte());
	    }

	    @Test
	     public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
	    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.crearCreadorDeSoldados();
	        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(unJugador);

	        Assert.assertEquals(puerto.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS);
	    }

}
