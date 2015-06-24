package fiuba.algo3.algocraft.modelo.utilidades.construcciones;

import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;

public abstract class AdicionalSuministros extends Construccion {
    protected int suministrosAdicionales;

    public AdicionalSuministros(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int suministrosAdicionales, Costo costo) {
        super(propietario, vitalidad, tiempoDeConstruccion, costo);
        this.suministrosAdicionales = suministrosAdicionales;
    }

    public int getCantidadDeSuministrosAdicionales() {
        return this.suministrosAdicionales;
    }
}
