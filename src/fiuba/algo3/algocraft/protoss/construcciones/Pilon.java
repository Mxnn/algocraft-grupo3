package fiuba.algo3.algocraft.protoss.construcciones;

import fiuba.algo3.algocraft.*;

public class Pilon extends AdicionalSuministros {
    private static final int VIDA_INICIAL = 300;
    private static final int ESCUDO_INICIAL = 300;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
    public Pilon(Jugador propietario) {
        this.propietario = propietario;
        this.vitalidad = new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.tiempoDeConstruccion = 5;
        this.suministrosAdicionales = 5;
    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}
