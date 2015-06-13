package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.terran.unidades.Espectro;
import fiuba.algo3.algocraft.terran.unidades.Golliat;
import fiuba.algo3.algocraft.terran.unidades.Marine;

import fiuba.algo3.algocraft.utilidades.Interactuable;
import org.junit.Assert;
import org.junit.Test;

public class MapaTest {

	@Test
	public void devolverElementoEnParcelaDevuelveElementoGuardado() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
		Mapa mapa = new Mapa(2, 5, 5);
        Coordenada coordenada = new Coordenada(3, 3);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro(mapa, coordenada);
		Interactuable marine = new Marine(unJugador);

		mapa.ubicarElementoEnParcela(new Coordenada(0,0), marine);

		Assert.assertSame(marine, mapa.devolverElementoEnParcela(new Coordenada(0, 0)));
	}

    @Test
    public void ubicarGolliatEnParcelaLanzaExcepcionSiElElementoNoEsAdmitidoEnLaParcela() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        Interactuable golliat = new Golliat(unJugador);
        Coordenada coordenada = new Coordenada(0,0);

        mapa.ubicarElementoEnParcela(coordenada, golliat);
    }

    @Test
    public void ubicarUnidadVoladoraEnParcelaEspacioLaUbica() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        Interactuable espectro = new Espectro(unJugador);
        Coordenada coordenada = new Coordenada(0,0);

        mapa.ubicarElementoEnParcela(coordenada, espectro);

        Assert.assertSame(espectro, mapa.devolverElementoEnParcela(coordenada));
    }

    @Test
    public void elMapaEmpiezaConParcelasVacias() throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa {
        int alturaDelMapa = 10;
        int anchoDelMapa = 10;
        Mapa mapa = new Mapa(2, alturaDelMapa, anchoDelMapa);

        for (int i = 0; i < alturaDelMapa; i++) {
            for (int j = 0; j < anchoDelMapa; j++) {
                Assert.assertNull(mapa.devolverElementoEnParcela(new Coordenada(i, j)));
            }
        }
    }
    
    @Test
    public void elMapaDaCoordenadasAParcelas() throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa {
        int alturaDelMapa = 10;
        int anchoDelMapa = 10;
        Mapa mapa = new Mapa(2, alturaDelMapa, anchoDelMapa);

        for (int i = 0; i < alturaDelMapa; i++) {
            for (int j = 0; j < anchoDelMapa; j++) {
            	Parcela parcela = mapa.obtenerParcelaEnCoordenada(new Coordenada(i, j));
                Assert.assertEquals(parcela.getCoordenada(),new Coordenada(i, j) );
            }
        }
    }

    @Test(expected = ExcepcionCoordenadaFueraDelMapa.class)
    public void consultarElElementoEnUnaCoordenadaFueraDelMapaLanzaExcepcion() throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 10, 10);

        Assert.assertNull(mapa.devolverElementoEnParcela(new Coordenada(11, 10)));
    }

    @Test
    public void obtenerParcelaEnCoordenadaDevuelveLaParcelaCorrecta() throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 10, 10);
        Coordenada coordenada = new Coordenada(5, 5);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(2, 2));
        Interactuable golliat = new Golliat(unJugador);
        mapa.ubicarElementoEnParcela(coordenada, golliat);

        Assert.assertEquals(mapa.obtenerParcelaEnCoordenada(coordenada).devolverElemento(), golliat);
    }

    @Test(expected = ExcepcionCoordenadaFueraDelMapa.class)
    public void obtenerParcelaEnCoordenadaLanzaExcepcionSiLaParcelaEsInvalida() throws ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido {
        Mapa mapa = new Mapa(2, 10, 10);
        Coordenada coordenada = new Coordenada(11, 5);

        mapa.obtenerParcelaEnCoordenada(coordenada);
    }
    


    @Test
    public void insertarParcelaInsertaParcelaEnElMapa() throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 20, 20);
        ParcelaVolcan parcela = new ParcelaVolcan(new Coordenada(1, 1));

        mapa.insertarParcela(parcela);

        Assert.assertSame(mapa.obtenerParcelaEnCoordenada(new Coordenada(1, 1)), parcela);
    }
}
