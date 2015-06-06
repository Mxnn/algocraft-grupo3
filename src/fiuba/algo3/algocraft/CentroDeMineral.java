package fiuba.algo3.algocraft;

public class CentroDeMineral extends ExtractorMineral{
    public static int COSTO_MINERAL= 50;
    public static int COSTO_GAZ = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);

	public CentroDeMineral(Jugador propietario) {
        this.propietario = propietario;
        this.tiempoDeConstruccion = 4;
        this.vida = 500;

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_MINERAL;
    }
}
