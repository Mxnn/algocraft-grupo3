package fiuba.algo3.algocraft.utilidades.unidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.utilidades.Interactuable;

public class AtaqueComun extends Ataque {
	private RangoAtaque rango;
	private Danyo danyo;
	private int distancia;
	
	public AtaqueComun(RangoAtaque rango, Danyo danyo, int distancia){
		this.rango = rango;
		this.danyo = danyo;
		this.distancia = distancia;
	}
	@Override
	public void atacar(Interactuable enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
//    	RangoAtaque rango = agresor.getRangoAtaque();
//    	Danyo danyo = agresor.getDanyo();
    	if(enemigo.seleccionarRango(this.rango) < distancia){
    		throw new ExcepcionEnemigoFueraDeAlcance();
    	}
    	enemigo.recibirDanyo(enemigo.seleccionarDanyo(this.danyo));
		
	}
	

}
