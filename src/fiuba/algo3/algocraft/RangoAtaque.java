package fiuba.algo3.algocraft;

public class RangoAtaque {
    private int rangoAire;
    private int rangoTierra;

    public RangoAtaque(int rangoAire, int rangoTierra) {
        this.rangoAire = rangoAire;
        this.rangoTierra = rangoTierra;
    }

    public int obtenerRangoDeAtaqueAlAire() {
        return this.rangoAire;
    }

    public int obtenerRangoDeAtaqueEnTierra() {
        return this.rangoTierra;
    }
}
