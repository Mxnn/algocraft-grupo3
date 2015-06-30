package fiuba.algo3.algocraft.modelo.excepciones;

public class ExcepcionUnidadNoClonable extends Exception {
	
	public ExcepcionUnidadNoClonable(){
		super("Esa unidad no es clonable, debe ser agresora");
	}

}
