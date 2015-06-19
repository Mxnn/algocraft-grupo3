package fiuba.algo3.algocraft.razas.terran.construcciones;

import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.AdicionalSuministros;

public class DepositoSuministro extends AdicionalSuministros {

    public static final int SUMINISTROS_ADICIONALES = 5;
    public static final int TIEMPO_DE_CONSTRUCCION = 6;
    public static final int VIDA_INICIAL = 500;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public DepositoSuministro(Jugador propietario) {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION, SUMINISTROS_ADICIONALES);
    }

    @Override
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}
