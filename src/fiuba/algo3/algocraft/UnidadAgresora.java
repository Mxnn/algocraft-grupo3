package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;

public abstract class UnidadAgresora extends Unidad {
    protected RangoAtaque rangoAtaque;
    protected Danyo danyo; 
    
    public void atacar(Interactuable enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
		int distancia = calcularDistanciaDeEnemigo(enemigo.getParcela());
    	enemigo.recibirAtaque(this, distancia);
	}
    
    private int calcularDistanciaDeEnemigo(Parcela parcelaEnemigo){
    	return ((this.parcelaUbicacion).devolverDistanciaConParcela(parcelaEnemigo));
    }
    
    public RangoAtaque obtenerRangoAtaque(){
    	return this.rangoAtaque;
    }
    
    public Danyo obtenerDanyo(){
    	return this.danyo;
    }

}
