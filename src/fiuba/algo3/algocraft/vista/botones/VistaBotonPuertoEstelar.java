package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.vista.acciones.construcciones.VistaAccionesPuertoEstelar;

public class VistaBotonPuertoEstelar extends VistaBotonRepresentante {
	public static final String CODIGO = "PET";
	public static final String NOMBRE = "Puerto Estelar Terran";

	public VistaBotonPuertoEstelar(PuertoEstelar puertoEstelar){
		super(puertoEstelar, CODIGO, NOMBRE);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesPuertoEstelar getVistaDeAcciones(Juego modelo) {
    	PuertoEstelar representado = (PuertoEstelar) this.elementoRepresentado;

    	VistaAccionesPuertoEstelar vistaAcciones = new VistaAccionesPuertoEstelar(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	vistaAcciones.setVida(PuertoEstelar.VIDA_INICIAL, this.elementoRepresentado.getVida());
        return vistaAcciones;
    }
}
