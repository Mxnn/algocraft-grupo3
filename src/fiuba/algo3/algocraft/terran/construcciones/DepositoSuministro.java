package fiuba.algo3.algocraft.terran.construcciones;

import fiuba.algo3.algocraft.AdicionalSuministros;
import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.Vitalidad;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;

public class DepositoSuministro extends AdicionalSuministros {

    public static final int VIDA_INICIAL = 500;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public DepositoSuministro(Jugador propietario) {
        this.propietario = propietario;
        this.vitalidad = new Vitalidad(VIDA_INICIAL);
        this.tiempoDeConstruccion = 6;
        this.CANTIDAD_DE_SUMINISTROS_ADICIONALES = 5;
        propietario.incrementarCapacidadDePoblacion(this.CANTIDAD_DE_SUMINISTROS_ADICIONALES);
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}
