package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNaveDeTransporteLlena;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

import java.util.ArrayList;

public abstract class NaveTransporte extends Unidad {
    protected int lugaresOcupados;
    protected int capacidad;
    protected ArrayList<Unidad> unidades = new ArrayList<Unidad>();

    public void insertarUnidad(Unidad unidad) throws ExcepcionNaveDeTransporteLlena {
        int lugaresTotalesOcupadas = lugaresOcupados + unidad.obtenerCupoDeTransporte();
        if (lugaresTotalesOcupadas <= capacidad) {
            lugaresOcupados = lugaresTotalesOcupadas;
            unidades.add(unidad);
        }
        else
            throw new ExcepcionNaveDeTransporteLlena();
    }

    public void destruir() {
        for (Unidad u : unidades) {
            u.destruir();
        }
        super.destruir();
    }

    public int cantidadDeUnidades() {
        return this.unidades.size();
    }
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }
    
    protected  int seleccionarDanyo(Danyo danyo){
    	return danyo.obtenerDanyoDeAtaqueEnAire();
    }
    
    protected int seleccionarRango(RangoAtaque rango){
    	return rango.obtenerRangoDeAtaqueAlAire();
    }
}
