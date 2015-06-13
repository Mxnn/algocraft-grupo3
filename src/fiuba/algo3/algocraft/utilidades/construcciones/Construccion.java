package fiuba.algo3.algocraft.utilidades.construcciones;

import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.Vitalidad;
import fiuba.algo3.algocraft.utilidades.unidades.Danyo;
import fiuba.algo3.algocraft.utilidades.unidades.RangoAtaque;

public abstract class Construccion extends Interactuable {

    public Construccion(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion) {
        super(propietario, vitalidad, tiempoDeConstruccion);
    }

    public abstract TipoDeConstruccion getTipoDeConstruccion();

	public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        parcela.setElemento(this);
    }
    
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }

    public void destruir() {
        (this.propietario).eliminarConstruccion(this);
        (this.parcelaUbicacion).vaciarParcela();
    }
    
    protected  int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnTierra();
    }
    
    protected int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnTierra();
    }

	public void collectarRecursos() {
		
		
	}
    
    
}