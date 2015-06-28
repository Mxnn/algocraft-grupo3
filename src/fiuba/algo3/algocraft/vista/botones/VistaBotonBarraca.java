package fiuba.algo3.algocraft.vista.botones;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.AltoTemplario;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.vista.acciones.VistaAccionesBarraca;

public class VistaBotonBarraca extends VistaBotonRepresentante {

	private static final String NOMBRE = "Barraca";
	private static final String CODIGO = "Ba";

	public VistaBotonBarraca(Barraca barraca){
		super(barraca);
		this.setText(CODIGO);
	}

    @Override
    public VistaAccionesBarraca getVistaDeAcciones(Juego modelo) {
    	Barraca representado = (Barraca) this.elementoRepresentado;
    	VistaAccionesBarraca vistaAcciones = new VistaAccionesBarraca(modelo,representado);
    	vistaAcciones.setTitulo(NOMBRE);
    	
    	vistaAcciones.setVida(representado.VIDA_INICIAL, this.elementoRepresentado.getVida());
        return vistaAcciones;
    }
}
