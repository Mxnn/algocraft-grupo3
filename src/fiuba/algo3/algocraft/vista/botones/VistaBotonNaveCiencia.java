package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.vista.VistaAccionesNaveCiencia;

public class VistaBotonNaveCiencia extends VistaBotonRepresentante {
	public VistaBotonNaveCiencia(NaveCiencia nave){
		super(nave);
		this.setText("NC");
	}

    @Override
    public VistaAccionesNaveCiencia getVistaDeAcciones(Juego modelo) {
    	VistaAccionesNaveCiencia vistaAcciones = new VistaAccionesNaveCiencia(modelo, (NaveCiencia) this.elementoRepresentado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
