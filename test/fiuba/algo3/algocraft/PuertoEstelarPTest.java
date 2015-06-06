package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.PuertoEstelarP;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.RazaProtoss.NaveTransporteP;
import fiuba.algo3.algocraft.RazaProtoss.Scout;

public class PuertoEstelarPTest {

	 @Test
	    public void crearScoutCreaScout() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
	        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.crearCreadorDeSoldados();
	        PuertoEstelarP puerto = new PuertoEstelarP(unJugador);

	        unJugador.crearAdicionalDeSuministro();

	        Assert.assertTrue(puerto.crearScout() instanceof Scout );
	    }

	    @Test
	    public void crearNaveDeTransportePCreaNaveDeTransporteP() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles {
	    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.crearCreadorDeSoldados();
	        PuertoEstelarP puerto = new PuertoEstelarP(unJugador);

	        unJugador.crearAdicionalDeSuministro();

	        Assert.assertTrue(puerto.crearNaveTransporteP() instanceof NaveTransporteP);
	    }

	    @Test
	     public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas {
	    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.crearCreadorDeSoldados();
	        PuertoEstelarP puerto = new PuertoEstelarP(unJugador);

	        Assert.assertEquals(puerto.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS);
	    }

}
