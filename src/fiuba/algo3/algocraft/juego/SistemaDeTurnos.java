package fiuba.algo3.algocraft.juego;

import fiuba.algo3.algocraft.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.utilidades.Interactuable;

import java.util.ArrayList;

public class SistemaDeTurnos {
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorQueJuega;
    private int turno;
    private Mapa mapa;
    public SistemaDeTurnos(ArrayList<Jugador> jugadores, Mapa mapa) {
        this.jugadores = jugadores;
        if (jugadores.size() > 0) {
            jugadorQueJuega = jugadores.get(0);
            this.turno = 0;
            this.mapa = mapa;
        }
    }

    public Jugador getJugadorQueJuega() {
        return this.jugadorQueJuega;
    }

    public void pasarTurno(Jugador jugador) throws ExcepcionNoEsElTurnoDelJugador {
        if (!jugador.equals(this.jugadorQueJuega))
            throw new ExcepcionNoEsElTurnoDelJugador();

        if (this.turno < (this.jugadores.size() - 1))
            this.turno++;
        else
            this.turno = 0;

        this.jugadorQueJuega = this.jugadores.get(this.turno);
        this.tareasDeEntreturno();
    }

    private void tareasDeEntreturno() {
        for (Jugador j: this.jugadores) {
            ArrayList<Interactuable> interactuables = new ArrayList<Interactuable>();
            interactuables.addAll(j.getConstrucciones());
            interactuables.addAll(j.getUnidades());

            for (Interactuable i: interactuables) {
                i.tareaDeEntreTurno(this.mapa);
            }
        }
    }
}
