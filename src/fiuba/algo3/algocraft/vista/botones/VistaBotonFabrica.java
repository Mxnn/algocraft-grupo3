package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.vista.VistaAccionesFabrica;

public class VistaBotonFabrica extends VistaBotonInteractuable {
	private Fabrica representado;

	public VistaBotonFabrica(Fabrica fabrica){
		super();
		this.setText("Fa");
		this.representado = fabrica;
	}

    @Override
    public VistaAccionesFabrica getVistaDeAcciones(Juego modelo) {
    	VistaAccionesFabrica vistaAcciones = new VistaAccionesFabrica(modelo,this.representado);
        return vistaAcciones;
    }
}
