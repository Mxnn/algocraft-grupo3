package fiuba.algo3.algocraft.modelo.excepciones;

public class ExcepcionUnidadNoClonable extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionUnidadNoClonable(){
		super("Esa unidad no es clonable, debe ser agresora");
	}

}
