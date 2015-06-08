package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.ExtractorGas;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.TipoDeConstruccion;

public class Asimilador  extends ExtractorGas {
	
    public static int COSTO_MINERAL= 100;
    public static int COSTO_GAZ = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    
    public Asimilador(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 450;
        //escudo = 450
        this.tiempoDeConstruccion = 6;

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_GAS;
    }
}

