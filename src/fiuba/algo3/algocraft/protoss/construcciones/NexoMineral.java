package fiuba.algo3.algocraft.protoss.construcciones;

import fiuba.algo3.algocraft.*;

public class NexoMineral  extends ExtractorMineral {
    private static final int VIDA_INICIAL = 250;
    private static final int ESCUDO_INICIAL = 250;
    public static int COSTO_MINERAL = 50;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public NexoMineral(Jugador propietario) {
        this.propietario = propietario;
        this.vitalidad = new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.tiempoDeConstruccion = 4;
    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_MINERAL;
    }
}

