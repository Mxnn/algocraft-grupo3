package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.NaveTransporteProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesNaveTransporte;

public class VistaBotonNaveTransporteProtoss extends VistaBotonRepresentante {

	private static final String NOMBRE = "Nave Transporte Protoss";
	private static final String CODIGO = "NTP";

	public VistaBotonNaveTransporteProtoss(NaveTransporteProtoss nave){
		super(nave);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesNaveTransporte getVistaDeAcciones(Juego modelo) {
    	NaveTransporteProtoss representado = (NaveTransporteProtoss) this.elementoRepresentado;
    	
    	VistaAccionesNaveTransporte vistaAcciones = new VistaAccionesNaveTransporte(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	
    	vistaAcciones.setVida(representado.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	int escudoActual = ((VitalidadProtoss) representado.getVitalidad()).getEscudo();
    	vistaAcciones.setEscudo(representado.ESCUDO_INICIAL, escudoActual);
    	return vistaAcciones;
    }
}