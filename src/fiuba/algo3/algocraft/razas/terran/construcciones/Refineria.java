package fiuba.algo3.algocraft.razas.terran.construcciones;

import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.Vitalidad;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.utilidades.construcciones.TipoDeConstruccion;


public class Refineria extends ExtractorGas {

    private static final int TIEMPO_DE_CONSTRUCCION = 6;
    private static final int VIDA_INICIAL = 750;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public Refineria(Jugador propietario) {
        super(propietario, new Vitalidad(VIDA_INICIAL), TIEMPO_DE_CONSTRUCCION);
    }

    public TipoDeConstruccion getTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_GAS;
    }
}