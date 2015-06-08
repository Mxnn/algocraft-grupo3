package fiuba.algo3.algocraft;

public abstract class AdicionalSuministros extends Construccion {
    protected int CANTIDAD_DE_SUMINISTROS_ADICIONALES;

    public void destruir() {
        (this.propietario).decrementarPoblacion(this.CANTIDAD_DE_SUMINISTROS_ADICIONALES);
        super.destruir();
    }
}
