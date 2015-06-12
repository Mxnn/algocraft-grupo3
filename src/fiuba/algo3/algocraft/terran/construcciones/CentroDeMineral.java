package fiuba.algo3.algocraft.terran.construcciones;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.Vitalidad;
import fiuba.algo3.algocraft.ExtractorMineral;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;

public class CentroDeMineral extends ExtractorMineral{
    private static final int VIDA_INICIAL = 500;
    public static int COSTO_MINERAL = 50;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

	public CentroDeMineral(Jugador propietario) {
        this.propietario = propietario;
        this.tiempoDeConstruccion = 4;
        this.vitalidad = new Vitalidad(VIDA_INICIAL);
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_MINERAL;
    }
    
}
