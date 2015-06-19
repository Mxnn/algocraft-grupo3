package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;

import org.junit.Test;
import org.junit.Assert;

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
