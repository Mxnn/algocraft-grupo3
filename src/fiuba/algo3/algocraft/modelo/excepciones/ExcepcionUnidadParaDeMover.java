package fiuba.algo3.algocraft.modelo.excepciones;

public class ExcepcionUnidadParaDeMover extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionUnidadParaDeMover(Class claseDeUnidad){
		super(claseDeUnidad.getSimpleName() + " no puede continuar su recorrido");
//		super("Unidad no puede continuar su recorrido");
	}
}
