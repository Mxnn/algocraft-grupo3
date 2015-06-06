package fiuba.algo3.algocraft;


public class Refineria extends ExtractorGas {
	
    public static int COSTO_MINERAL= 100;
    public static int COSTO_GAZ = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    public Refineria(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 750;
        this.tiempoDeConstruccion = 6;

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_GAS;
    }
}
