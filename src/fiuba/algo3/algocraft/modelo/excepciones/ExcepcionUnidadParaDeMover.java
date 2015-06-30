package fiuba.algo3.algocraft.modelo.excepciones;

public class ExcepcionUnidadParaDeMover extends Exception {
	public ExcepcionUnidadParaDeMover(Class claseDeUnidad){
		super("El/la " + claseDeUnidad.getName() + " no puede continuar su recorrido");
	}
}
