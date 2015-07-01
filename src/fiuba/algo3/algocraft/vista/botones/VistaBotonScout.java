package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Scout;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesUnidadAgresora;

public class VistaBotonScout extends VistaBotonRepresentante {

	private static final String CODIGO = "Sc";
	private static final String NOMBRE = "Scout";

	public VistaBotonScout(Scout scout){
		super(scout, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	Scout representado = (Scout) this.elementoRepresentado;
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	vistaAcciones.setVida(Scout.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(Scout.ESCUDO_INICIAL, escudoActual);
        return vistaAcciones;
    }
}
