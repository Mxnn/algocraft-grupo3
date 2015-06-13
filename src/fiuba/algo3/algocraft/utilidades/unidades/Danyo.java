package fiuba.algo3.algocraft.utilidades.unidades;

public class Danyo {
    private int danyoAire;
    private int danyoTierra;

    public Danyo(int danyoAire, int danyoTierra) {
        this.danyoAire = danyoAire;
        this.danyoTierra = danyoTierra;
    }

    public int getDanyoDeAtaqueEnAire() {
        return this.danyoAire;
    }

    public int getDanyoDeAtaqueEnTierra() {
        return this.danyoTierra;
    }
}


