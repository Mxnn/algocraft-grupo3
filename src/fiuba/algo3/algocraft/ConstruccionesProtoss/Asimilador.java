package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.ExtractorGas;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;

public class Asimilador  extends ExtractorGas {
    public Asimilador(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 450;
        //escudo = 450
        this.tiempoDeConstruccion = 6;
        //Costo 100M
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_GAS;
    }
}

