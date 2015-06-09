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
    
    public abstract void recibirAtaque(UnidadAgresora agresor, int distancia) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto;
    
//    public boolean estoyEnRangoDeAtaque(int rango){
//		int distancia = (enemigo.getParcela()).devolverDistanciaConParcela(miParcela);
//		if (rango < distancia)
//			throw new ExcepcionEnemigoFueraDeAlcance();
//    }
    
    
    public void setParcela(Parcela parcela){
    	this.parcelaUbicacion = parcela;
    }
    
    public Parcela getParcela(){
    	return this.parcelaUbicacion;
    }
    
    public int obtenerVida() {
    	return estado.obtenerVida();
    }
    
    public abstract void destruir();
    
    public abstract void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;

    public abstract void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada;
}
