package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.AdicionalSuministros;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;

public class Pilon extends AdicionalSuministros {

    public Pilon(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 300;
        //escudo = 300
        this.tiempoDeConstruccion = 5;
        this.cantidadDeSuministrosAdicionales = 5;
        propietario.incrementarCapacidadDePoblacion(this.cantidadDeSuministrosAdicionales);
        //Costo = 100M
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}

