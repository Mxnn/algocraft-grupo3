package fiuba.algo3.algocraft.modelo.excepciones;

public class ExcepcionUnidadParaDeMover extends Exception {
	public ExcepcionUnidadParaDeMover(Class claseDeUnidad){
		super(claseDeUnidad.getSimpleName() + " no puede continuar su recorrido");
//		super("Unidad no puede continuar su recorrido");
	}
}
