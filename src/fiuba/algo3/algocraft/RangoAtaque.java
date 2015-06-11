package fiuba.algo3.algocraft;

public class RangoAtaque {
    private int rangoAire;
    private int rangoTierra;

    public RangoAtaque(int rangoAire, int rangoTierra) {
        this.rangoAire = rangoAire;
        this.rangoTierra = rangoTierra;
    }

    public int getRangoDeAtaqueEnAire() {
        return this.rangoAire;
    }

    public int getRangoDeAtaqueEnTierra() {
        return this.rangoTierra;
    }
}
