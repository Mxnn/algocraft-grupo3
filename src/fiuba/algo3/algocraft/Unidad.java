package fiuba.algo3.algocraft;

import java.util.LinkedList;
import java.util.List;

public abstract class Unidad extends Interactuable {

    protected int vision;
    protected RangoAtaque rangoAtaque;
    protected LinkedList<Coordenada> itinerario = new LinkedList<Coordenada>();
    //protected Coordenada posicion;
    public int SUMINISTRO;

    public void destruir() {
        (this.propietario).eliminarUnidad(this);
    }
}