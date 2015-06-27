package fiuba.algo3.algocraft.vista.botones;


import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.vista.VistaAccionesPuertoEstelar;

public class VistaBotonPuertoEstelar extends VistaBotonInteractuable {
	private PuertoEstelar representado;

	public VistaBotonPuertoEstelar(PuertoEstelar puertoEstelar){
		super();
		this.setText("Ma");
		this.representado = puertoEstelar;
	}

    @Override
    public VistaAccionesPuertoEstelar getVistaDeAcciones(Juego modelo) {
    	VistaAccionesPuertoEstelar vistaAcciones = new VistaAccionesPuertoEstelar(modelo,this.representado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
