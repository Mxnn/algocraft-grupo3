package fiuba.algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Ataque;


public class SistemaDeTurnos {
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorQueJuega;
    private int turno = 0;
    private Mapa mapa;


    public SistemaDeTurnos(ArrayList<Jugador> jugadores, Mapa mapa) {
        this.jugadores = jugadores;
        if (jugadores.size() > 0) 
            jugadorQueJuega = jugadores.get(0);

        this.mapa = mapa;
    }

    public Jugador getJugadorQueJuega() {
        if (this.jugadorQueJuega == null && this.jugadores.size() > 0)
            this.jugadorQueJuega = this.jugadores.get(0);

        return this.jugadorQueJuega;
    }

    public void pasarTurno(Jugador jugador) throws ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa {
        if (this.jugadorQueJuega == null && this.jugadores.size() > 0)
            this.jugadorQueJuega = this.jugadores.get(0);

        if (!jugador.equals(this.jugadorQueJuega))
            throw new ExcepcionNoEsElTurnoDelJugador();

        if (this.turno < (this.jugadores.size() - 1))
            this.turno++;
        else
            this.turno = 0;

        this.jugadorQueJuega = this.jugadores.get(this.turno);
        this.tareasDeEntreturno();
    }

    private void tareasDeEntreturno() throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa{
    	
    	ArrayList<Ataque> ataques = new ArrayList<Ataque>();
    	for (Jugador j: this.jugadores) {
//    		if(j.esPerdedor())
//    			throw new ExcepcionFinDelJuego();
            ArrayList<Interactuable> interactuables = new ArrayList<Interactuable>();
            ataques.addAll(j.getAtaques());
            interactuables.addAll(j.getConstrucciones());
            interactuables.addAll(j.getUnidades());
        
            for (Interactuable i: interactuables) {
                i.tareaDeEntreTurno(this.mapa);
            }
        }
        
        for (Ataque i: ataques) {
            i.tareaDeEntreTurno(this.mapa);
        }
    }


}
