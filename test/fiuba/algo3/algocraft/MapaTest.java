package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.RazaTerran.*;
import org.junit.Assert;
import org.junit.Test;

public class MapaTest {

	@Test
	public void devolverElementoEnParcelaDevuelveElementoGuardado() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNoHaySuministrosDisponibles {
		Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro();
		Interactuable marine = new Marine(unJugador);
		mapa.ubicarElementoEnParcela(0, 0, marine);

		Assert.assertSame(marine, mapa.devolverElementoEnParcela(0, 0));
	}

    @Test
    public void ubicarGolliatEnParcelaLanzaExcepcionSiElElementoNoEsAdmitidoEnLaParcela() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro();
        Interactuable golliat = new Golliat(unJugador);

        mapa.ubicarElementoEnParcela(0, 0, golliat);
    }

    @Test
    public void ubicarUnidadVoladoraEnParcelaEspacioLaUbica() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNoHaySuministrosDisponibles {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro();
        Interactuable espectro = new Espectro(unJugador);
        mapa.ubicarElementoEnParcela(0, 0, espectro);

        Assert.assertSame(espectro, mapa.devolverElementoEnParcela(0,0));
    }

    @Test
    public void elMapaEmpiezaConParcelasVacias() throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa {
        int alturaDelMapa = 10;
        int anchoDelMapa = 10;
        Mapa mapa = new Mapa(2, alturaDelMapa, anchoDelMapa);

        for (int i = 0; i < alturaDelMapa; i++) {
            for (int j = 0; j < anchoDelMapa; j++) {
                Assert.assertNull(mapa.devolverElementoEnParcela(i, j));
            }
        }
    }

    @Test(expected = ExcepcionCoordenadaFueraDelMapa.class)
    public void consultarElElementoEnUnaCoordenadaFueraDelMapaLanzaExcepcion() throws ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa {
        Mapa mapa = new Mapa(2, 10, 10);

        Assert.assertNull(mapa.devolverElementoEnParcela(11, 10));
    }
}
