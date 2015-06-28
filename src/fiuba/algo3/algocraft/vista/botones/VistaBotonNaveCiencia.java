package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.NaveCiencia;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesNaveCiencia;

public class VistaBotonNaveCiencia extends VistaBotonRepresentante {
	private static final String NOMBRE = "Nave Ciencia";
	private static final String CODIGO = "NC";

	public VistaBotonNaveCiencia(NaveCiencia nave){
		super(nave);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesNaveCiencia getVistaDeAcciones(Juego modelo) {
    	NaveCiencia representado = (NaveCiencia) this.elementoRepresentado;
    	VistaAccionesNaveCiencia vistaAcciones = new VistaAccionesNaveCiencia(modelo, representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	
    	vistaAcciones.setVida(NaveCiencia.VIDA_INICIAL, this.elementoRepresentado.getVida());
    	
    	vistaAcciones.setEnergia(NaveCiencia.ENERGIA_MAXIMA, representado.getEnergia());
        return vistaAcciones;
    }
}
