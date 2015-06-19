package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNumeroDeBasesInvalido;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;

import org.junit.Assert;
import org.junit.Test;

public class FabricaTest {
    @Test
    public void crearGolliatCreaUnGolliat() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);

        unJugador.sumarMinerales(700);
        unJugador.sumarGasVespeno(700);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertNotNull(fabrica.crearGolliat(mapa));
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));
        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = new Fabrica(unJugador);

        Assert.assertEquals(fabrica.getTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_AVANZADAS);
    }

    @Test
    public void crearUnGolliatCreaLaUnidadAlrededorDeLaFabrica() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);

        unJugador.sumarMinerales(700);
        unJugador.sumarGasVespeno(700);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(3, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        Golliat golliat = fabrica.crearGolliat(mapa);

        Assert.assertEquals(golliat.getParcela().getCoordenada(), new Coordenada(2, 2));
    }


    @Test(expected = ExcepcionNoHayLugarDisponible.class)
    public void crearUnGolliatLanzaExcepcionSiLasParcelasAlrededorDeLaFabricaNoPuedenContenerAlGolliat() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);

        //Rodeo el lugar de la fabrica por parcelas volcan
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

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(3, 3));

        //Se pasan los turnos necesarios
        while (!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        fabrica.crearGolliat(mapa);
    }
}
