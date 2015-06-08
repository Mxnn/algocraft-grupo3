package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.ExtractorMineral;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;

public class NexoMineral  extends ExtractorMineral {
    public static int COSTO_MINERAL= 50;
    public static int COSTO_GAZ = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    public NexoMineral(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 250;
        //escudo = 250
        this.tiempoDeConstruccion = 4;

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_MINERAL;
    }
}

