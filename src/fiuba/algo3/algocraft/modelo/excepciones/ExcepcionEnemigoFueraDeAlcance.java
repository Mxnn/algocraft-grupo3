package fiuba.algo3.algocraft.modelo.excepciones;


public class ExcepcionEnemigoFueraDeAlcance extends Exception {
	public ExcepcionEnemigoFueraDeAlcance(Class claseUnidad){
		super("Ataque Fallido: "+ claseUnidad.getSimpleName() + " fuera de alcance");
	}
}
