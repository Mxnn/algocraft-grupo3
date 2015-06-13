package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;

import fiuba.algo3.algocraft.utilidades.Interactuable;
import org.junit.Assert;
import org.junit.Test;

public class ParcelaTest {
    @Test
    public void vaciarParcelaVaciaLaParcela() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto {
        Mapa mapa = new Mapa(2, 5, 5);
        Coordenada coordenada = new Coordenada(3, 3);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro(mapa, coordenada);
        Parcela parcela = new ParcelaTierra(new Coordenada(0,0));
        Interactuable marine = new Marine(unJugador);

        parcela.guardarElemento(marine);
        Assert.assertSame(marine, parcela.devolverElemento());

        parcela.vaciarParcela();
        Assert.assertTrue(parcela.estaVacia());
    }


}