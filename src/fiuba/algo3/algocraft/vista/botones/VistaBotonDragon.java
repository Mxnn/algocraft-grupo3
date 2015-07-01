package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.unidades.VistaAccionesUnidadAgresora;

public class VistaBotonDragon extends VistaBotonRepresentante {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String NOMBRE = "Dragon";
	private static final String CODIGO = "Dr";

	public VistaBotonDragon(Dragon dragon) {
		super(dragon, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	Dragon representado = (Dragon) this.elementoRepresentado;

    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);

    	vistaAcciones.setVida(Dragon.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(Dragon.ESCUDO_INICIAL, escudoActual);
    	
        return vistaAcciones;
    }
}
