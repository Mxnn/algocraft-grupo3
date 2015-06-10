package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public interface Alucinable {
    public Alucinable crearAlucinacion() throws ExcepcionNoHaySuministrosDisponibles, CloneNotSupportedException;

    public Jugador obtenerPropietario();
}
