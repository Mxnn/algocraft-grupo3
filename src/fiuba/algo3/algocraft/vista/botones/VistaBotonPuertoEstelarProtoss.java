package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesPuertoEstelarProtoss;

public class VistaBotonPuertoEstelarProtoss extends VistaBotonRepresentante {

	private static final String NOMBRE = "Puerto Estelar Protoss";
	private static final String CODIGO = "PEP";

	public VistaBotonPuertoEstelarProtoss(PuertoEstelarProtoss puerto){
		super(puerto);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesPuertoEstelarProtoss getVistaDeAcciones(Juego modelo) {
    	PuertoEstelarProtoss representado = (PuertoEstelarProtoss) this.elementoRepresentado;
    	VistaAccionesPuertoEstelarProtoss vistaAcciones = new VistaAccionesPuertoEstelarProtoss(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	vistaAcciones.setVida(representado.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(representado.ESCUDO_INICIAL, escudoActual);
        return vistaAcciones;
    }
}
