package fiuba.algo3.algocraft.razas.protoss.construcciones;

import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.AdicionalSuministros;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;

public class Pilon extends AdicionalSuministros {

    public static final int SUMINISTROS_ADICIONALES = 5;
    public static final int TIEMPO_DE_CONSTRUCCION = 6;
    private static final int VIDA_INICIAL = 300;
    private static final int ESCUDO_INICIAL = 300;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
    public Pilon(Jugador propietario) {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION, SUMINISTROS_ADICIONALES);
    }

    @Override
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}

