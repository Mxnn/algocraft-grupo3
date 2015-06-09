package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;

public interface Agresor {
	
	//public abstract void atacarConDanyoYRango(Interactuable enemigo);
	
//	public static void target(Parcela parcela, RangoAtaque rango){
//		
//		
//	}
	
	public default void estaEnRango(Parcela miParcela, Interactuable enemigo, int rango) throws ExcepcionEnemigoFueraDeAlcance{
		int distancia = (enemigo.getParcela()).devolverDistanciaConParcela(miParcela);
		if (rango < distancia)
			throw new ExcepcionEnemigoFueraDeAlcance();
	}
	
	
	public default void atacar(Interactuable enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
		enemigo.recibirAtaque(this);
	}
	
	public abstract void atacar(UnidadTerrestre enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto;
	
	public abstract void atacar(UnidadVoladora enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto;
	
	public abstract void atacar(Construccion enemigo) throws ExcepcionEnemigoNoAtacable, ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto;

}
