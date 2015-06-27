package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;

public abstract class CreadorDeUnidadListener extends JuegoListener {
    protected Construccion construccion;

    public CreadorDeUnidadListener(Juego modelo, Construccion construccion) {
        super(modelo);
        this.construccion = construccion;
    }
}
