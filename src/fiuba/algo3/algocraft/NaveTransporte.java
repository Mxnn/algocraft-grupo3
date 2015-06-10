package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;

import java.util.ArrayList;

public abstract class NaveTransporte extends Unidad {
    protected int lugaresOcupados;
    protected int capacidad;
    protected ArrayList<Unidad> unidades = new ArrayList<Unidad>();

    public void insertarUnidad(Unidad unidad) throws ExcepcionNaveDeTransporteLlena, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre {
        if (!unidad.obtenerPropietario().equals(this.propietario))
            throw new ExcepcionUnidadEnemiga();

        if (unidad.obtenerCupoDeTransporte() == 0)
            throw new ExcepcionNoEsUnidadTerrestre();

        int lugaresTotalesOcupadas = lugaresOcupados + unidad.obtenerCupoDeTransporte();
        if (lugaresTotalesOcupadas <= capacidad) {
            lugaresOcupados = lugaresTotalesOcupadas;
            unidades.add(unidad);
            Parcela parcela = unidad.getParcela();
            if (parcela != null) //Fix medio triste
                parcela.vaciarParcela();
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
    
    protected int seleccionarDanyo(Danyo danyo){
    	return danyo.obtenerDanyoDeAtaqueEnAire();
    }
    
    protected int seleccionarRango(RangoAtaque rango){
    	return rango.obtenerRangoDeAtaqueAlAire();
    }
}