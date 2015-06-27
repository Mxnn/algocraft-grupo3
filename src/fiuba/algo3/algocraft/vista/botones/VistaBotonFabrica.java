package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.vista.VistaAccionesFabrica;

public class VistaBotonFabrica extends VistaBotonRepresentante {

	public VistaBotonFabrica(Fabrica fabrica){
		super(fabrica);
		this.setText("Fa");
	}

    @Override
    public VistaAccionesFabrica getVistaDeAcciones(Juego modelo) {
    	VistaAccionesFabrica vistaAcciones = new VistaAccionesFabrica(modelo, (Fabrica) this.elementoRepresentado);
        this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
