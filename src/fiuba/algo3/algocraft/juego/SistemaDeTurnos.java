package fiuba.algo3.algocraft.juego;

import fiuba.algo3.algocraft.utilidades.Interactuable;

import java.util.ArrayList;

public class SistemaDeTurnos {
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorQueJuega;
    private int turno;

    public SistemaDeTurnos(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
        if (jugadores.size() > 0) {
            jugadorQueJuega = jugadores.get(0);
            this.turno = 0;
        }
    }

    public Jugador getJugadorQueJuega() {
        return this.jugadorQueJuega;
    }

    public void pasarTurno() {
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
                i.tareaDeEntreTurno();
            }
        }
    }
}
