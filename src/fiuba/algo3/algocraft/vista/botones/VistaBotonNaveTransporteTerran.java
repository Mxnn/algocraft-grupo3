package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveTransporteTerran;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesNaveTransporte;

public class VistaBotonNaveTransporteTerran extends VistaBotonRepresentante {
	private static final String NOMBRE = "Nave Transpoerte Terran";
	private static final String CODIGO = "NTT";

	public VistaBotonNaveTransporteTerran(NaveTransporteTerran nave){
		super(nave, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesNaveTransporte getVistaDeAcciones(Juego modelo) {
    	NaveTransporteTerran representado = (NaveTransporteTerran) this.elementoRepresentado;
    	VistaAccionesNaveTransporte vistaAcciones = new VistaAccionesNaveTransporte(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	vistaAcciones.setVida(NaveTransporteTerran.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	vistaAcciones.setCapacidad(NaveTransporteTerran.CAPACIDAD, representado.cantidadDeUnidades());

    	return vistaAcciones;
    }
}
