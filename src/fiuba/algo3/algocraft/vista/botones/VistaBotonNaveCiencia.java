package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.vista.VistaAccionesNaveCiencia;

public class VistaBotonNaveCiencia extends VistaBotonInteractuable {
	private NaveCiencia representado;

	public VistaBotonNaveCiencia(NaveCiencia nave){
		super();
		this.setText("NC");
		this.representado = nave;
	}

    @Override
    public VistaAccionesNaveCiencia getVistaDeAcciones(Juego modelo) {
    	VistaAccionesNaveCiencia vistaAcciones = new VistaAccionesNaveCiencia(modelo, this.representado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
