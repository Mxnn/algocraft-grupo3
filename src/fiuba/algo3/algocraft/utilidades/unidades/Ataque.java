package fiuba.algo3.algocraft.utilidades.unidades;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.utilidades.Interactuable;

public abstract class Ataque {
	
	public abstract void atacar(Interactuable enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;

}
