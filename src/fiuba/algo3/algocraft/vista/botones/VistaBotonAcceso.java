package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.vista.VistaAccionesAcceso;

public class VistaBotonAcceso extends VistaBotonInteractuable {
	private Acceso representador;

	public VistaBotonAcceso(Acceso acceso){
		super();
		this.setText("Ac");
		this.representador = acceso;
	}

    @Override
    public VistaAccionesAcceso getVistaDeAcciones(Juego modelo) {
    	VistaAccionesAcceso vistaAcciones = new VistaAccionesAcceso(modelo);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
