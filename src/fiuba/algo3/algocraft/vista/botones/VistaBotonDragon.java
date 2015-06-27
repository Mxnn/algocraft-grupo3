package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.Dragon;
import fiuba.algo3.algocraft.vista.VistaAccionesUnidadAgresora;

public class VistaBotonDragon extends VistaBotonInteractuable {
	private Dragon representado;

	public VistaBotonDragon(Dragon dragon){
		super();
		this.setText("Dr");
		this.representado = dragon;
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, this.representado);
    	this.vistaAcciones = vistaAcciones;
        return vistaAcciones;
    }
}
