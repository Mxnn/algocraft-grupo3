package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

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
import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;

public class AccesoTest {
    @Test
    public void crearZealotCreaUnZealot() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);

        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1 ,1));
        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertNotNull(acceso.crearZealot(mapa));
    }
    
    @Test
    public void crearDragonCreaUnDragon() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);
        Mapa mapa = new Mapa(2, 5, 5);

        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertNotNull(acceso.crearDragon(mapa));
    }

    @Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));
        Acceso acceso = new Acceso(unJugador);

        Assert.assertEquals(acceso.getTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_BASICAS);
    }
}
