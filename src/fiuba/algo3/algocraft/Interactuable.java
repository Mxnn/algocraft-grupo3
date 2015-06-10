package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionParcelaOcupada;

public abstract class Interactuable {
	
	protected Jugador propietario;
	protected Estado estado;
	protected int tiempoDeConstruccion;
	protected Parcela parcelaUbicacion;

    public void recibirDanyo(int cantidad) throws ExcepcionEstadoMuerto {
        try {
            (this.estado).recibirDanyo(cantidad);
        }
        catch (ExcepcionEstadoMuerto e) {
            this.destruir();
        }
    }
    
    public void recibirAtaque(UnidadAgresora agresor, int distancia) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
    	RangoAtaque rango = agresor.obtenerRangoAtaque();
    	Danyo danyo = agresor.obtenerDanyo();
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
    
    public int obtenerVida() {
    	return estado.obtenerVida();
    }
    
    public Estado obtenerEstado(){
    	return this.estado;
    }
    
    
    
    public abstract void destruir();
    
    public abstract void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;
}
