package fiuba.algo3.algocraft;

import static org.junit.Assert.*;
import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.razas.terran.Terran;
import fiuba.algo3.algocraft.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.unidades.Ataque;
import fiuba.algo3.algocraft.utilidades.unidades.UnidadAgresora;

import org.junit.Test;

import fiuba.algo3.algocraft.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.razas.terran.unidades.Golliat;
import fiuba.algo3.algocraft.razas.terran.unidades.Marine;

public class GolliatTest {

    @Test
    public void atacarRestaVidaATerrestre() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        Mapa mapa = new Mapa(2, 5, 5);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        UnidadAgresora golliat = new Golliat(unJugador);
        while(!golliat.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(0,0), golliat);
        unJugador.terminarTurno(juego);

        Interactuable marine = new Marine(unJugador2);
        while(!marine.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(1,0), marine);
        unJugador2.terminarTurno(juego);

        golliat.atacar(marine.getParcela());
        unJugador.terminarTurno(juego);
        assertEquals(marine.getVida(), 40-12);
    }

    @Test
    public void atacarRestaVidaAVolador() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        Mapa mapa = juego.getMapa();
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 2));
        while(!barraca.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(4, 3));
        while(!fabrica.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        Golliat golliat = fabrica.crearGolliat(mapa); //Creado en la (3,4)
        while(!golliat.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        unJugador.terminarTurno(juego);

        //Construcciones jugador 2
        Barraca barracaJugador2 = (Barraca) unJugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(7, 7));
        while(!barracaJugador2.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        Fabrica fabricaJugador2 = (Fabrica) unJugador2.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(8, 8));
        while(!fabricaJugador2.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        PuertoEstelar puerto = (PuertoEstelar) unJugador2.crearCreadorDeUnidadesMagicas(mapa, new Coordenada(3, 6));
        while(!puerto.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        Espectro espectro = puerto.crearEspectro(mapa);
        unJugador2.terminarTurno(juego);

        golliat.atacar(espectro.getParcela());
        unJugador.terminarTurno(juego);
        
        assertEquals(espectro.getVida(), 120-10);
    }

    @Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
    public void atacarFueraDeRangoEnTierraLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionNoHayLugarDisponible, ExcepcionConstruccionesRequeridasNoCreadas {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        Mapa mapa = juego.getMapa();
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 2));
        while(!barraca.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(4, 3));
        while(!fabrica.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        Golliat golliat = fabrica.crearGolliat(mapa); //Creado en la (3,4)
        while(!golliat.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        unJugador.terminarTurno(juego);

        //Construcciones jugador 2
        Barraca barracaJugador2 = (Barraca) unJugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(18, 18));
        while(!barracaJugador2.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        Marine marine = barracaJugador2.crearMarine(mapa);
        while(!marine.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        golliat.atacar(marine.getParcela());
        unJugador2.terminarTurno(juego);
    }

    @Test(expected = ExcepcionEnemigoFueraDeAlcance.class)
    public void atacarFueraDeRangoEnAireLanzaExcepcion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionNoEsElTurnoDelJugador, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        Mapa mapa = juego.getMapa();
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        UnidadAgresora golliat = new Golliat(unJugador);
        while(!golliat.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }
        mapa.ubicarElementoEnParcela(new Coordenada(5,5), golliat);
        unJugador.terminarTurno(juego);

        Interactuable espectro = new Espectro(unJugador2);
        while(!espectro.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        mapa.ubicarElementoEnParcela(new Coordenada(12,  12), espectro);
        unJugador2.terminarTurno(juego);

        golliat.atacar(espectro.getParcela());
        unJugador.terminarTurno(juego);
    }

    @Test
    public void atacarRestaVidaAConstruccion() throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionNumeroDeBasesInvalido, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionNombreCorto, ExcepcionEntidadEnConstruccion, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso, ExcepcionNoEsElTurnoDelJugador, ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHayLugarDisponible {
        Juego juego = new Juego();
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador unJugador2 = new Jugador("Juan2", Color.VERDE, Terran.getInstance());
        Mapa mapa = juego.getMapa();
        juego.agregarJugador(unJugador);
        juego.agregarJugador(unJugador2);
        unJugador.sumarMinerales(999);
        unJugador.sumarGasVespeno(999);
        unJugador2.sumarMinerales(999);
        unJugador2.sumarGasVespeno(999);
        unJugador.crearAdicionalDeSuministro(mapa, new Coordenada(3, 3));
        unJugador2.crearAdicionalDeSuministro(mapa, new Coordenada(3, 1));
        for(int i= 0; i<=7; i++){
        	unJugador.terminarTurno(juego);
        	unJugador2.terminarTurno(juego);
        }
        Barraca barraca = (Barraca) unJugador.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 2));

        while(!barraca.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        Fabrica fabrica = (Fabrica) unJugador.crearCreadorDeUnidadesAvanzadas(mapa, new Coordenada(4, 3));

        while(!fabrica.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        UnidadAgresora golliat = fabrica.crearGolliat(mapa); //Creado en la (3,4)
        while(!golliat.estaCreado()) {
            unJugador.terminarTurno(juego);
            unJugador2.terminarTurno(juego);
        }

        unJugador.terminarTurno(juego);

        Barraca barracaJugador2 = (Barraca) unJugador2.crearCreadorDeUnidadesBasicas(mapa, new Coordenada(3, 5));
        while(!barracaJugador2.estaCreado()) {
            unJugador2.terminarTurno(juego);
            unJugador.terminarTurno(juego);
        }

        unJugador2.terminarTurno(juego);

        golliat.atacar(barracaJugador2.getParcela());
        unJugador.terminarTurno(juego);

        assertEquals(barracaJugador2.getVida(), 1000-12);
    }
}
