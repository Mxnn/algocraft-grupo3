package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionNaveDeTransporteLlena;

import java.util.ArrayList;

public abstract class NaveTransporte extends UnidadVoladora {
    protected int lugaresOcupados;
    protected int capacidad;
    protected ArrayList<UnidadTerrestre> unidades = new ArrayList<UnidadTerrestre>();

    public void insertarUnidad(UnidadTerrestre unidad) throws ExcepcionNaveDeTransporteLlena {
        int lugaresTotalesOcupadas = lugaresOcupados + unidad.obtenerCupoDeTransporte();
        if (lugaresTotalesOcupadas <= capacidad) {
            lugaresOcupados = lugaresTotalesOcupadas;
            unidades.add(unidad);
        }
        else
            throw new ExcepcionNaveDeTransporteLlena();
    }

    public int cantidadDeUnidades() {
        return this.unidades.size();
    }
}
