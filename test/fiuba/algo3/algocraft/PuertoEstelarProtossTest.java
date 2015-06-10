package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.PuertoEstelarProtoss;

public class PuertoEstelarProtossTest {

	 @Test
	    public void crearScoutCreaScout() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
            Mapa mapa = new Mapa(2, 5, 5);
            Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
	      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
	        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
	        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(unJugador);

	        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1,1));

	        Assert.assertNotNull(puerto.crearScout());
	    }

	    @Test
	    public void crearNaveDeTransportePCreaNaveDeTransporteP() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
            Mapa mapa = new Mapa(2, 5, 5);
            Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
	      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);     
	    	
	    	unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
	        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(unJugador);

	        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

	        Assert.assertNotNull(puerto.crearNaveTransporte());
	    }

	    @Test
	     public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
            Mapa mapa = new Mapa(2, 5, 5);
            Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
	        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
	        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(unJugador);

	        Assert.assertEquals(puerto.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES);
	    }

}
