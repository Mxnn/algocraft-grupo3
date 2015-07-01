package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.vista.acciones.unidades.VistaAccionesUnidadAgresora;

public class VistaBotonEspectro extends VistaBotonRepresentante {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String NOMBRE = "Espectro";
	private static final String CODIGO = "Es";

	public VistaBotonEspectro(Espectro espectro){
		super(espectro, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	Espectro representado = (Espectro) this.elementoRepresentado;

    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	
    	vistaAcciones.setVida(Espectro.VIDA_INICIAL, this.elementoRepresentado.getVida());
        return vistaAcciones;
    }
}