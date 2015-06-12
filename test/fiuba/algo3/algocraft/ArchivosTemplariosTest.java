package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.protoss.construcciones.ArchivosTemplarios;

import org.junit.Assert;
import org.junit.Test;

public class ArchivosTemplariosTest {

	@Test
	public void crearAltoTemplariotCreaUnAltoTemplario() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada (1, 1));
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 1));
        ArchivosTemplarios archivo = (ArchivosTemplarios) unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 3));

        Assert.assertNotNull(archivo.crearAltoTemplario(mapa));
    }
	
	@Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());

        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));
        unJugador.crearCreadorDeUnidadesTerrestres(mapa, new Coordenada(2, 1));
        unJugador.crearCreadorDeUnidadesAereas(mapa, new Coordenada(2, 3));
        ArchivosTemplarios archivo = new ArchivosTemplarios(unJugador);

        Assert.assertEquals(archivo.getTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_AEREAS);
    }
}
