package fiuba.algo3.algocraft.modelo.excepciones;

public class ExcepcionNoEsUnidadTerrestre extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionNoEsUnidadTerrestre() {
        super("Solo se pueden transportar unidades terrestres");
    }
}
