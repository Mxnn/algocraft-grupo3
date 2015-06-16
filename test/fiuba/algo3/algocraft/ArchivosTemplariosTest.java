package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;

import org.junit.Assert;
import org.junit.Test;

public class ArchivosTemplariosTest {

	@Test
	public void crearAltoTemplariotCreaUnAltoTemplario() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);
        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(1, 1));

        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        ArchivosTemplarios archivos = (ArchivosTemplarios) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));

        //Se pasan los turnos necesarios
        while (!archivos.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertNotNull(archivos.crearAltoTemplario(mapa));
    }
	
	@Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionNombreCorto, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 5, 5);
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        juego.agregarJugador(unJugador);

        unJugador.sumarMinerales(JugadorTest.RECURSOS_SUFFICIENTES);
      	unJugador.sumarGasVespeno(JugadorTest.RECURSOS_SUFFICIENTES);

        Acceso acceso = (Acceso) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(2, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado())
            unJugador.terminarTurno(juego);

        PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(2, 3));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado())
            unJugador.terminarTurno(juego);

        ArchivosTemplarios archivos = (ArchivosTemplarios) unJugador.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(2, 4));

        //Se pasan los turnos necesarios
        while (!archivos.estaCreado())
            unJugador.terminarTurno(juego);

        Assert.assertEquals(archivos.getTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_MAGICAS);
    }
}
