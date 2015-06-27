package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.vista.VistaAccionesAcceso;

public class VistaBotonAcceso extends VistaBotonInteractuable {
	private Acceso representado;

	public VistaBotonAcceso(Acceso acceso){
		super();
		this.setText("Ac");
		this.representado = acceso;
	}

    @Override
    public VistaAccionesAcceso getVistaDeAcciones(Juego modelo) {
    	VistaAccionesAcceso vistaAcciones = new VistaAccionesAcceso(modelo, this.representado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
