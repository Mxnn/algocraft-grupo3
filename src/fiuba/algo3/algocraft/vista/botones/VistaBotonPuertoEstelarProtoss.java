package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.construcciones.VistaAccionesPuertoEstelarProtoss;

public class VistaBotonPuertoEstelarProtoss extends VistaBotonRepresentante {
	public static final String NOMBRE = "Puerto Estelar Protoss";
	public static final String CODIGO = "PEP";

	public VistaBotonPuertoEstelarProtoss(PuertoEstelarProtoss puerto){
		super(puerto, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesPuertoEstelarProtoss getVistaDeAcciones(Juego modelo) {
    	PuertoEstelarProtoss representado = (PuertoEstelarProtoss) this.elementoRepresentado;
    	VistaAccionesPuertoEstelarProtoss vistaAcciones = new VistaAccionesPuertoEstelarProtoss(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	vistaAcciones.setVida(PuertoEstelarProtoss.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(PuertoEstelarProtoss.ESCUDO_INICIAL, escudoActual);

        return vistaAcciones;
    }
}
