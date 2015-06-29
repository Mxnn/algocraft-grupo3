package fiuba.algo3.algocraft.modelo.excepciones;


public class ExcepcionEnemigoFueraDeAlcance extends Exception {
	public ExcepcionEnemigoFueraDeAlcance(){
		super("Ataque Fallido: Enemigo fuera de alcance");
	}
}
