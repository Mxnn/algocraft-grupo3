package fiuba.algo3.algocraft.modelo.razas.protoss.construcciones;

import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;

public class Asimilador  extends ExtractorGas {

    private static final int TIEMPO_DE_CONSTRUCCION = 6;
    private static final int ESCUDO_INICIAL = 450;
    private static final int VIDA_INICIAL = 450;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public Asimilador(Jugador propietario) {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION);
    }

    @Override
    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_GAS;
    }
}

