package fiuba.algo3.algocraft.utilidades.unidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public class AtaqueComun extends Ataque {
	public static final int TURNOS_DE_DURACION = 1;
	protected Interactuable enemigo;
	private RangoAtaque rango;
	private Danyo danyo;
	private int distancia;
	
	public AtaqueComun(Interactuable enemigo, RangoAtaque rango, Danyo danyo, int distancia){
		this.rango = rango;
		this.danyo = danyo;
		this.distancia = distancia;
		this.enemigo = enemigo;
		this.duracionDeAtaque = TURNOS_DE_DURACION;
	}
	
	public void ejecutarAtaque() throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		this.cantidadDeAtaques += 1;
		(this.enemigo).recibirAtaque(this);
	}
	//nombre pedorro, cambiar
	private void danyar(Interactuable enemigo) throws ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
		if(enemigo.seleccionarRango(this.rango) < distancia){
    		throw new ExcepcionEnemigoFueraDeAlcance();
    	}
    	enemigo.recibirDanyo(enemigo.seleccionarDanyo(this.danyo));
	}
	
	
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
    	this.danyar(enemigo);
	}
	
//	public void atacar(Unidad enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
//	this.danyar(enemigo);
//}
	
	public void atacar(UnidadAgresora enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
    	this.danyar(enemigo);
	}
	
	public void atacar(UnidadMagica enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
    	this.danyar(enemigo);
	}
	
	public void atacar(NaveTransporte enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
    	this.danyar(enemigo);
	}

	
//	public boolean descartarAtaque() {
//		// TODO Auto-generated method stub
//		return false;
//	}
	

}
