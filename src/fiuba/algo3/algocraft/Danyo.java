package fiuba.algo3.algocraft;

public class Danyo {
    private int danyoAire;
    private int danyoTierra;

    public Danyo(int danyoAire, int danyoTierra) {
        this.danyoAire = danyoAire;
        this.danyoTierra = danyoTierra;
    }

    public int obtenerDanyoDeAtaqueEnAire() {
        return this.danyoAire;
    }

    public int obtenerDanyoDeAtaqueEnTierra() {
        return this.danyoTierra;
    }
}


