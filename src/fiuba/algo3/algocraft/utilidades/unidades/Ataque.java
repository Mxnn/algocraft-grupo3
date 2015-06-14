package fiuba.algo3.algocraft.utilidades.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public abstract class Ataque {	
	protected int duracionDeAtaque;
	protected int cantidadDeAtaques;
	
	public abstract void ejecutarAtaque() throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;
	
	public boolean esDescartable(){
		return ((this.duracionDeAtaque - this.cantidadDeAtaques) == 0);
	}
	
	public abstract void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;
	public abstract void atacar(UnidadAgresora enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;
	public abstract void atacar(UnidadMagica enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;
	public abstract void atacar(NaveTransporte enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;

}
