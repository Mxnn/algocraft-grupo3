package fiuba.algo3.algocraft.terran.construcciones;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.Vitalidad;
import fiuba.algo3.algocraft.ExtractorGas;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;


public class Refineria extends ExtractorGas {

    private static final int VIDA_INICIAL = 750;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public Refineria(Jugador propietario) {
        this.propietario = propietario;
        this.vitalidad = new Vitalidad(VIDA_INICIAL);
        this.tiempoDeConstruccion = 6;

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_GAS;
    }
}
