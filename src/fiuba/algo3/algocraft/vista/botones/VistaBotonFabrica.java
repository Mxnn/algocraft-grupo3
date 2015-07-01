package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesFabrica;

public class VistaBotonFabrica extends VistaBotonRepresentante {

	private static final String NOMBRE = "Fabrica";
	private static final String CODIGO = "Fa";

	public VistaBotonFabrica(Fabrica fabrica){
		super(fabrica, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesFabrica getVistaDeAcciones(Juego modelo) {
    	VistaAccionesFabrica vistaAcciones = new VistaAccionesFabrica(modelo, (Fabrica) this.elementoRepresentado);
    	vistaAcciones.setTitulo(NOMBRE);

    	vistaAcciones.setVida(Fabrica.VIDA_INICIAL, this.elementoRepresentado.getVida());
        return vistaAcciones;
    }
}
