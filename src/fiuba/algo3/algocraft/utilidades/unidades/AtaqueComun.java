package fiuba.algo3.algocraft.utilidades.unidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public class AtaqueComun extends Ataque {
	public static final int TURNOS_DE_DURACION = 1;
	private RangoAtaque rango;
	private Danyo danyo;
	private int distancia;
	
	public AtaqueComun(Parcela target, RangoAtaque rango, Danyo danyo, int distancia){
		super(target);
		this.rango = rango;
		this.danyo = danyo;
		this.distancia = distancia;
		(this.listaParcelas).add(target);
		this.duracionDeAtaque = TURNOS_DE_DURACION;
	}

	private void danyar(Interactuable enemigo) throws ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto{
		if(enemigo.seleccionarRango(this.rango) < distancia){
    		throw new ExcepcionEnemigoFueraDeAlcance();
    	}
    	enemigo.recibirDanyo(enemigo.seleccionarDanyo(this.danyo));
	}

    @Override
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
    	this.danyar(enemigo);
	}

    @Override
	public void atacar(Unidad enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance {
	this.danyar(enemigo);
}
}
