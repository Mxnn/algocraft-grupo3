package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.modelo.excepciones.*;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.NaveTransporteProtoss;

public class NaveTransporteProtossTest {
    /*@Test
    public void insertarUnidadInsertaLaUnidadEnLaNave() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);
        nave.insertarUnidad(new Dragon(unJugador));

        Assert.assertEquals(nave.cantidadDeUnidades(), 1);
    }*/

    /*@Test(expected = ExcepcionNaveDeTransporteLlena.class)
    public void insertarUnidadLanzaExcepcionSiLaNaveEstaLlena() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(2, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);

        for (int i = 1; i <= 4; i++) {
            nave.insertarUnidad(new Dragon(unJugador));
        }

        nave.insertarUnidad(new Marine(unJugador));
    }*/

    /*@Test
    public void destruirNaveDestruyeTodasLasUnidadesQueHayEnSuInterior() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(2, 2));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);

        for (int i = 1; i <= 2; i++) {
            nave.insertarUnidad(new Dragon(unJugador));
        }

        nave.recibirDanyo(NaveTransporteProtoss.VIDA_INICIAL + NaveTransporteProtoss.ESCUDO_INICIAL + 1);

        Assert.assertEquals(unJugador.getCantidadDeUnidades(), 0);
        Assert.assertEquals(unJugador.getPoblacion(), 0);
    }*/

    /*@Test(expected = ExcepcionUnidadEnemiga.class)
    public void ingresarUnaUnidadEnemigaEnLaNaveLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador unJugador2 = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);

        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);

        nave.insertarUnidad(new Dragon(unJugador2));
    }*/

    /*@Test(expected = ExcepcionNoEsUnidadTerrestre.class)
    public void ingresarUnScoutLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);
        Scout scout = new Scout(unJugador);

        nave.insertarUnidad(scout);
    }*/

    /*@Test(expected = ExcepcionNoEsUnidadTerrestre.class)
    public void ingresarUnaNaveTransporteLanzaExcepcion() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion {
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        NaveTransporteProtoss nave = new NaveTransporteProtoss(unJugador);
        NaveTransporteProtoss nave2 = new NaveTransporteProtoss(unJugador);

        nave.insertarUnidad(nave2);
    }*/

    @Test
    public void sacarUnidadLaDepositaAlrededorDeLaNave() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave, ExcepcionUnidadParaDeMover, ExcepcionUnidadMuyLejos {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 10, 10);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 4));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(7, 7));

        while(!acceso.estaCreado())
            
        	unJugador.terminarTurno(juego);

        PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(8, 8));

        //Se pasan los turnos necesarios
        while(!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        NaveTransporteProtoss nave = puerto.crearNaveTransporte(mapa); //Se crea en (7,7)
        Dragon dragon = acceso.crearDragon(mapa); //Se crea en (6, 6)

        //Se pasan los turnos necesarios
        while(!dragon.estaCreado() || !nave.estaCreado())
            unJugador.terminarTurno(juego);

        nave.insertarUnidad(dragon);
        nave.sacarUnidad(mapa);

        Assert.assertSame(mapa.obtenerParcelaEnCoordenada(dragon.getParcela().getCoordenada()).devolverElemento(), dragon);
    }

    @Test(expected = ExcepcionNoHayLugarDisponible.class)
    public void sacarUnidadLanzaExcepcionSiLasParcelasASuAlrededorNoLaPuedenDepositar() throws ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionNaveDeTransporteLlena, ExcepcionEstadoMuerto, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEnemigoFueraDeAlcance, ExcepcionUnidadYaSeEncuentraEnLaNave, ExcepcionUnidadParaDeMover, ExcepcionUnidadMuyLejos {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 10, 10);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 4));
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(4, 4));
        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(6, 6));

        //Se pasan los turnos necesarios
        while(!acceso.estaCreado())
            unJugador.terminarTurno(juego);

        Dragon dragon = acceso.crearDragon(mapa);

        PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(8, 8));

        //Se pasan los turnos necesarios
        while(!puerto.estaCreado())
            
        	unJugador.terminarTurno(juego);

        NaveTransporteProtoss nave = puerto.crearNaveTransporte(mapa); //Se crea en (7,7)

        //Se pasan los turnos necesarios
        while(!dragon.estaCreado() || !nave.estaCreado())
            unJugador.terminarTurno(juego);

        nave.insertarUnidad(dragon);

        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(6, 7)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(6, 8)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(7, 6)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(7, 8)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(8, 6)));
        mapa.insertarParcela(new ParcelaVolcan(new Coordenada(8, 7)));

        nave.sacarUnidad(mapa);
    }
}