package fiuba.algo3.algocraft;

public class Refineria extends ExtractorGas {
    public Refineria(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 750;
        this.tiempoDeConstruccion = 6;
        //Costo 100M
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.EXTRACTOR_GAS;
    }
}
