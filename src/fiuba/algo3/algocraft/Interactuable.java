package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;

public abstract class Interactuable {
	
	protected Jugador propietario;
	protected Vitalidad vitalidad;
	protected int tiempoDeConstruccion;
	protected Parcela parcelaUbicacion;

    public void recibirDanyo(int cantidad) throws ExcepcionEstadoMuerto {
        try {
            (this.vitalidad).recibirDanyo(cantidad);
        }
        catch (ExcepcionEstadoMuerto e) {
            this.destruir();
        }
    }
    
    public void recibirAtaque(UnidadAgresora agresor, int distancia) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
    	RangoAtaque rango = agresor.getRangoAtaque();
    	Danyo danyo = agresor.getDanyo();
    	if(this.seleccionarRango(rango) < distancia){
    		throw new ExcepcionEnemigoFueraDeAlcance();
    	}
    	this.recibirDanyo(this.seleccionarDanyo(danyo));
    }
    
    protected abstract int seleccionarDanyo(Danyo danyo);
    
    protected abstract int seleccionarRango(RangoAtaque rango);
    
    
    public void setParcela(Parcela parcela){
    	this.parcelaUbicacion = parcela;
    }
    
    public Parcela getParcela(){
    	return this.parcelaUbicacion;
    }
    
    public int getVida() {
    	return vitalidad.getVida();
    }
    
    public Vitalidad getVitalidad(){
    	return this.vitalidad;
    }

    public abstract void destruir();
    
    public abstract void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;


}
