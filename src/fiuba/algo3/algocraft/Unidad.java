package fiuba.algo3.algocraft;

public abstract class Unidad extends Interactuable {

    protected int vision;
    protected RangoAtaque rangoAtaque;
    //protected Coordenada posicion;
    public int SUMINISTRO;

    public void destruir() {
        (this.propietario).eliminarUnidad(this);
    }
}