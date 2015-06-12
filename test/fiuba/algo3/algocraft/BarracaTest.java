package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;
import fiuba.algo3.algocraft.RazaTerran.Marine;
import fiuba.algo3.algocraft.terran.construcciones.Barraca;

import org.junit.Assert;
import org.junit.Test;

public class BarracaTest {
    @Test
    public void crearMarineCreaUnMarine() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        Barraca barraca = (Barraca) unJugador.crearCreadorDeSoldados(mapa, new Coordenada(3, 2));

        Assert.assertNotNull(barraca.crearMarine(mapa));
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        Barraca barraca = new Barraca(unJugador);

        Assert.assertEquals(barraca.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_SOLDADOS);
    }

    @Test
    public void crearUnMarineCreaLaUnidadAlrededorDeLaFabrica() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        unJugador.sumarMinerales(700);
        unJugador.sumarGasVespeno(700);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Barraca barraca = (Barraca) unJugador.crearCreadorDeSoldados(mapa, new Coordenada(2, 2));


        Marine marine = barraca.crearMarine(mapa);

        Assert.assertEquals(marine.getParcela().getCoordenada(), new Coordenada(1, 2));
    }


    @Test(expected = ExcepcionNoHayLugarDisponible.class)
    public void crearUnMarineLanzaExcepcionSiLasParcelasAlrededorDeLaFabricaNoPuedenContenerAlGolliat() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());

        //Rodeo el lugar de la fabrica por parcelas volcan
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(2, 2)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(2, 3)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(2, 4)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(3, 2)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(3, 4)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(4, 2)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(4, 3)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(4, 4)));
        unJugador.sumarMinerales(700);
        unJugador.sumarGasVespeno(700);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Barraca barraca = (Barraca) unJugador.crearCreadorDeSoldados(mapa, new Coordenada(3, 3));

        barraca.crearMarine(mapa);
    }
}
