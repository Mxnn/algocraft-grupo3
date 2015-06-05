package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.ExtractorMineral;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;

public class NexoMineral  extends ExtractorMineral {
    public NexoMineral(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 250;
        //escudo = 250
        this.tiempoDeConstruccion = 4;
        //Costo 50M
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_MINERAL;
    }
}

