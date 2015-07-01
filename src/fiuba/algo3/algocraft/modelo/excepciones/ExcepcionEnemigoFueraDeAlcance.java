package fiuba.algo3.algocraft.modelo.excepciones;


public class ExcepcionEnemigoFueraDeAlcance extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionEnemigoFueraDeAlcance(Class claseUnidad){
		super("Ataque Fallido: "+ claseUnidad.getSimpleName() + " fuera de alcance");
	}
}
