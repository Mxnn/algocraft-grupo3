package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAccionesFabrica;

public class VistaBotonFabrica extends VistaBotonInteractuable {
	public VistaBotonFabrica(){
		super();
		this.setText("Fa");
	}

    @Override
    public VistaAccionesFabrica getVistaDeAcciones(Juego modelo) {
    	VistaAccionesFabrica vistaAcciones = new VistaAccionesFabrica(modelo);
        return vistaAcciones;
    }
}
