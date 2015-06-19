package fiuba.algo3.algocraft.razas.protoss.construcciones;

import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;

public class NexoMineral  extends ExtractorMineral {

    private static final int TIEMPO_DE_CONSTRUCCION = 4;
    private static final int VIDA_INICIAL = 250;
    private static final int ESCUDO_INICIAL = 250;
    public static int COSTO_MINERAL = 50;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public NexoMineral(Jugador propietario) {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION);
    }

    @Override
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_MINERAL;
    }
}

