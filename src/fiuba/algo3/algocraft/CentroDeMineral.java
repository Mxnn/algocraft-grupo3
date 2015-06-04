package fiuba.algo3.algocraft;

public class CentroDeMineral extends ExtractorMineral{
    public CentroDeMineral(Jugador propietario) {
        this.propietario = propietario;
        this.tiempoDeConstruccion = 4;
        this.vida = 500;
        //Costo = 50M
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_MINERAL;
    }
}
