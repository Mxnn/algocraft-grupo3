package fiuba.algo3.algocraft.utilidades.unidades;

import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.utilidades.Vitalidad;

public abstract class AdicionalSuministros extends Construccion {
    protected int suministrosAdicionales;

    public AdicionalSuministros(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int suministrosAdicionales) {
        super(propietario, vitalidad, tiempoDeConstruccion);
        this.suministrosAdicionales = suministrosAdicionales;
    }


    public int getCantidadDeSuministrosAdicionales() {
        return this.suministrosAdicionales;
    }
}
