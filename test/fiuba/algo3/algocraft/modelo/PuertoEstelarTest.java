package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
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
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;

public class PuertoEstelarTest {
    @Test
    public void crearEspectroCreaEspectro() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);

        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 3));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(1, 1));

        //Se pasan los turnos necesarios
        while(!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(1, 2));

        //Se pasan los turnos necesarios
        while(!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while(!puerto.estaCreado())
            unJugador.terminarTurno(juego);


        Assert.assertNotNull(puerto.crearEspectro(mapa));
    }

    @Test
    public void crearNaveDeTransporteCreaNaveDeTransporte() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while(!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 1));

        //Se pasan los turnos necesarios
        while(!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while(!puerto.estaCreado())
            unJugador.terminarTurno(juego);


        Assert.assertNotNull(puerto.crearNaveTransporte(mapa));
    }

    @Test
    public void crearNaveCienciaCreaUnaNaveCiencia() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while(!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 1));

        //Se pasan los turnos necesarios
        while(!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while(!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertNotNull(puerto.crearNaveCiencia(mapa));
    }

    @Test
     public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        juego.agregarJugador(unJugador);

        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);

        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while(!barraca.estaCreado())
            unJugador.terminarTurno(juego);

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 1));

        //Se pasan los turnos necesarios
        while(!fabrica.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelar puerto = (PuertoEstelar) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 3));


        Assert.assertEquals(puerto.getTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_MAGICAS);
    }
}
