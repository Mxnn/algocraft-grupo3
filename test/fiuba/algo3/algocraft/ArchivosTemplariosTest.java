package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.ArchivosTemplarios;

public class ArchivosTemplariosTest {

	@Test
	public void crearAltoTemplariotCreaUnAltoTemplario() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada (1, 1));
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 1));
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 3));
        ArchivosTemplarios archivo = new ArchivosTemplarios(unJugador);

        Assert.assertNotNull(archivo.crearAltoTemplario());
    }
	
	@Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 1));
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 3));
        ArchivosTemplarios archivo = new ArchivosTemplarios(unJugador);

        Assert.assertEquals(archivo.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS);
    }
}
