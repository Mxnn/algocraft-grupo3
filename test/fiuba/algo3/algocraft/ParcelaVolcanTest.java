package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.terran.unidades.Espectro;
import fiuba.algo3.algocraft.terran.unidades.Marine;

import org.junit.Test;
import org.junit.Assert;

public class ParcelaVolcanTest {
    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadDeTierra() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Parcela parcela = new ParcelaVolcan(new Coordenada(0,0));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        Interactuable unidad = new Marine(unJugador);

        parcela.guardarElemento(unidad);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaUnidadVoladora() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Parcela parcela = new ParcelaVolcan(new Coordenada(0,0));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(2 ,2));
        Interactuable unidad = new Espectro(unJugador);

        parcela.guardarElemento(unidad);
    }
    
    @Test
    public void guardarExtractorGasGuardaCorrectamente() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Parcela parcela = new ParcelaVolcan(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable extractor = new Refineria(unJugador);

        parcela.guardarElemento(extractor);

        Assert.assertSame(parcela.devolverElemento(),extractor);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnExtractorDeMineral() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Parcela parcela = new ParcelaVolcan(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable extractor = new CentroDeMineral(unJugador);

        parcela.guardarElemento(extractor);
    }

    @Test(expected = ExcepcionElementoNoAdmitidoEnParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnaConstruccionParaUnidades() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Parcela parcela = new ParcelaVolcan(new Coordenada(0,0));
        Jugador unJugador = new Jugador("Juan", Color.AZUL, Terran.getInstance());
        Interactuable construccion = new Barraca(unJugador);

        parcela.guardarElemento(construccion);
    }

    @Test
    public void despedirGasSumaGasVespenoAlJugadorSiEnLaParcelaHayUnExtractorDeGas() throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNombreCorto {
        Jugador unJugadorPropietario = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        ParcelaVolcan parcela = new ParcelaVolcan(new Coordenada(0,0));

        parcela.guardarElemento(new Refineria(unJugadorPropietario));
        parcela.despedirGas();

        Assert.assertEquals(unJugadorPropietario.getGasVespeno(), Jugador.GAS_VESPENO_INICIAL + 10);
    }
}
