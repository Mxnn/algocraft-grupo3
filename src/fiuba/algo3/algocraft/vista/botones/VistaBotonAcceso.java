package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesAcceso;

public class VistaBotonAcceso extends VistaBotonRepresentante {

	public VistaBotonAcceso(Acceso acceso){
		super(acceso);
		this.setText("Ac");
	}

    @Override
    public VistaAccionesAcceso getVistaDeAcciones(Juego modelo) {
    	VistaAccionesAcceso vistaAcciones = new VistaAccionesAcceso(modelo, (Acceso) this.elementoRepresentado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
