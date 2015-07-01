package fiuba.algo3.algocraft.modelo.excepciones;

public class ExcepcionUnidadEnemiga extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionUnidadEnemiga(){
		super("No se puede clonar una unidad enemiga");
	}
}
