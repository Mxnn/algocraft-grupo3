package fiuba.algo3.algocraft;

import java.util.LinkedList;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public abstract class Unidad extends Interactuable {
	protected int cupoDeTransporte;
    protected int vision;

    protected LinkedList<Coordenada> itinerario = new LinkedList<Coordenada>();
    public int SUMINISTRO;
    
    public void destruir() {
        (this.propietario).eliminarUnidad(this);
    }
    public int obtenerCupoDeTransporte() { return this.cupoDeTransporte; }
    
    public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        parcela.setElemento(this);
    }
    
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    protected int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnTierra();
    }
    
    protected int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnTierra();
    }

    public Jugador obtenerPropietario() {
        return this.propietario;
    }
}