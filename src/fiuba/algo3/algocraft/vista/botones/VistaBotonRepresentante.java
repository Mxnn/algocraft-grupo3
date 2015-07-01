package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;

public abstract class VistaBotonRepresentante extends VistaBotonInteractuable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Interactuable elementoRepresentado;

    public VistaBotonRepresentante(Interactuable elemento, String codigo, String nombre) {
        this.elementoRepresentado = elemento;
        this.setEnabled(elemento.estaCreado());
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public void habilitarBoton(){
    	this.setEnabled(this.elementoRepresentado.estaCreado());
    }
    
}
