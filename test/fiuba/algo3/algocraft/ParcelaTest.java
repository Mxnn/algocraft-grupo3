package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.terran.unidades.Marine;

import org.junit.Assert;
import org.junit.Test;

public class ParcelaTest {
    @Test
    public void vaciarParcelaVaciaLaParcela() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa {
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