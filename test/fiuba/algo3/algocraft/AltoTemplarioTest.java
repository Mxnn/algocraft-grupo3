package fiuba.algo3.algocraft;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.razas.protoss.unidades.Zealot;
import fiuba.algo3.algocraft.utilidades.unidades.Ataque;

import org.junit.Test;

public class AltoTemplarioTest {
    @Test(expected = ExcepcionUnidadEnemiga.class)
    public void alucionacionLanzaExcpecionSiLaUnidadNoEsPropia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionUnidadEnemiga, CloneNotSupportedException, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionEnergiaInsuficiente, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 20, 20);
        Jugador jugador1 = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador jugador2 = new Jugador("Pablo", Color.AZUL, Protoss.getInstance());
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        ArchivosTemplarios archivo;
        Acceso acceso;
        Zealot zealot;
        AltoTemplario altoTemplario;

        jugador1.sumarMinerales(999);
        jugador1.sumarGasVespeno(999);
        jugador2.sumarMinerales(999);
        jugador2.sumarGasVespeno(999);

        jugador1.crearAdicionalDeSuministro(mapa, new Coordenada(2, 2));
        acceso = (Acceso) jugador1.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(1, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado()) {
            jugador1.terminarTurno(juego);
            jugador2.terminarTurno(juego);
        }

        zealot = acceso.crearZealot(mapa);
        jugador1.terminarTurno(juego); //Le pasa el turno al segundo jugador

        jugador2.crearAdicionalDeSuministro(mapa, new Coordenada(18, 18));
        Acceso acceso2 = (Acceso) jugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(19, 19));

        //Se pasan los turnos necesarios
        while (!acceso2.estaCreado()) {
            jugador2.terminarTurno(juego);
            jugador1.terminarTurno(juego);
        }

        PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) jugador2.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(18, 19));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado()) {
            jugador2.terminarTurno(juego);
            jugador1.terminarTurno(juego);
        }

        archivo = (ArchivosTemplarios) jugador2.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(19, 18));

        //Se pasan los turnos necesarios
        while(!archivo.estaCreado()) {
            jugador2.terminarTurno(juego);
            jugador1.terminarTurno(juego);
        }

        altoTemplario = archivo.crearAltoTemplario(mapa);

        //Se pasan los turnos necesarios
        while(!altoTemplario.estaCreado()) {
            jugador2.terminarTurno(juego);
            jugador1.terminarTurno(juego);
        }

        for (int i = 0; i < 6; i++) 
        	altoTemplario.regenerarEnergia();

        altoTemplario.crearAlucinacion(zealot, mapa);
    }
    
    @Test(expected = ExcepcionEnergiaInsuficiente.class)
    public void alucionacionLanzaExcpecionSiNoAlcanzaLaEnergia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionUnidadEnemiga, CloneNotSupportedException, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionEnergiaInsuficiente, ExcepcionNoEsElTurnoDelJugador, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
        Juego juego = new Juego();
        Mapa mapa = new Mapa(2, 20, 20);
        Jugador jugador1 = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        Jugador jugador2 = new Jugador("Pablo", Color.AZUL, Protoss.getInstance());
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        ArchivosTemplarios archivo;
        Acceso acceso;
        Zealot zealot;
        AltoTemplario altoTemplario;

        jugador1.sumarMinerales(999);
        jugador1.sumarGasVespeno(999);
        jugador2.sumarMinerales(999);
        jugador2.sumarGasVespeno(999);

        jugador1.crearAdicionalDeSuministro(mapa, new Coordenada(2, 2));
        acceso = (Acceso) jugador1.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(1, 2));

        //Se pasan los turnos necesarios
        while (!acceso.estaCreado()) {
            jugador1.terminarTurno(juego);
            jugador2.terminarTurno(juego);
        }

        zealot = acceso.crearZealot(mapa);
        jugador1.terminarTurno(juego); //Le pasa el turno al segundo jugador

        jugador2.crearAdicionalDeSuministro(mapa, new Coordenada(18, 18));
        Acceso acceso2 = (Acceso) jugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(19, 19));

        //Se pasan los turnos necesarios
        while (!acceso2.estaCreado()) {
            jugador2.terminarTurno(juego);
            jugador1.terminarTurno(juego);
        }

        PuertoEstelarProtoss puerto = (PuertoEstelarProtoss) jugador2.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(18, 19));

        //Se pasan los turnos necesarios
        while (!puerto.estaCreado()) {
            jugador2.terminarTurno(juego);
            jugador1.terminarTurno(juego);
        }

        archivo = (ArchivosTemplarios) jugador2.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(19, 18));

        //Se pasan los turnos necesarios
        while(!archivo.estaCreado()) {
            jugador2.terminarTurno(juego);
            jugador1.terminarTurno(juego);
        }

        altoTemplario = archivo.crearAltoTemplario(mapa);

        //Se pasan los turnos necesarios
        while(!altoTemplario.estaCreado()) {
            jugador2.terminarTurno(juego);
            jugador1.terminarTurno(juego);
        }

        altoTemplario.crearAlucinacion(zealot, mapa);
    }
    
    @Test(expected = ExcepcionEnergiaInsuficiente.class)
    public void tormentaPsionicaLanzaExcpecionSiNoAlcanazaLaEnergia() throws ExcepcionNumeroDeBasesInvalido, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa, ExcepcionRecursosInsuficientes, ExcepcionNoHaySuministrosDisponibles, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionUnidadEnemiga, CloneNotSupportedException, ExcepcionNoHayLugarDisponible, ExcepcionNombreCorto, ExcepcionEnergiaInsuficiente, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
    	Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
		 Mapa mapa = new Mapa(2, 5, 5);
	     unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
	     
	     AltoTemplario templario = new AltoTemplario(unJugador);
	     
	     ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	     listaParcelas.add(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     
	     Ataque ataque = templario.lanzarTormentaPsionica(mapa.obtenerParcelaEnCoordenada(new Coordenada (1,1)));
	     ataque.tareaDeEntreTurno(mapa);
    }
    
}
