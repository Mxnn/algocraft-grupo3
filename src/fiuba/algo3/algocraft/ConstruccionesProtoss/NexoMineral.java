package fiuba.algo3.algocraft.ConstruccionesProtoss;

import fiuba.algo3.algocraft.*;

public class NexoMineral  extends ExtractorMineral {
    private static final int VIDA_INICIAL = 250;
    private static final int ESCUDO_INICIAL = 250;
    public static int COSTO_MINERAL = 50;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public NexoMineral(Jugador propietario, Parcela parcela) {
        this.parcela = parcela;
        this.propietario = propietario;
        this.estado = new EstadoProtoss(VIDA_INICIAL, ESCUDO_INICIAL);
        this.tiempoDeConstruccion = 4;
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_MINERAL;
    }
}

