package fiuba.algo3.algocraft.protoss.construcciones;

import fiuba.algo3.algocraft.*;

public class Asimilador  extends ExtractorGas {

    private static final int ESCUDO_INICIAL = 450;
    private static final int VIDA_INICIAL = 450;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    
    public Asimilador(Jugador propietario) {
        this.propietario = propietario;
        this.vitalidad = new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.tiempoDeConstruccion = 6;

    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_GAS;
    }
}
