package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.Espectro;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesUnidadAgresora;

public class VistaBotonEspectro extends VistaBotonRepresentante {
	private static final String NOMBRE = "Espectro";
	private static final String CODIGO = "Es";

	public VistaBotonEspectro(Espectro espectro){
		super(espectro);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesUnidadAgresora getVistaDeAcciones(Juego modelo) {
    	Espectro representado = (Espectro) this.elementoRepresentado;

    	VistaAccionesUnidadAgresora vistaAcciones = new VistaAccionesUnidadAgresora(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	
    	vistaAcciones.setVida(representado.VIDA_INICIAL, this.elementoRepresentado.getVida());
        return vistaAcciones;
    }
}