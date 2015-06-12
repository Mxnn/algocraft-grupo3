package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;

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
    
    public RangoAtaque getRangoAtaque(){
    	return this.rangoAtaque;
    }
    
    public Danyo getDanyo(){
    	return this.danyo;
    }

}
