package fiuba.algo3.algocraft.modelo.excepciones;

public class ExcepcionConstruccionesRequeridasNoCreadas extends Exception {
//	private String mensaje = "Construcciones Requeridas No Creadas";
//	public String getMensaje(){
//		return this.mensaje;
//	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionConstruccionesRequeridasNoCreadas(){
		super("Construcciones Requeridas No Creadas");
	}
}
