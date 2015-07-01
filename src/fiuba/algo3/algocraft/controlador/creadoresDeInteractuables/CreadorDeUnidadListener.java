package fiuba.algo3.algocraft.controlador.creadoresDeInteractuables;

import fiuba.algo3.algocraft.controlador.JuegoListener;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;

public abstract class CreadorDeUnidadListener extends JuegoListener {
    protected Construccion construccion;
//    protected final String msjNoHaySuministrosDisponible = "No hay suministros disponibles";
//    protected final String msjNoHayLugarDisponible = "El edificio no tiene lugar para crear la unidad. Libere espacio alrededor";
//    protected final String msjEntidadEnConstruccion = "El elemento esta en construccion";

    public CreadorDeUnidadListener(Juego modelo, Construccion construccion) {
        super(modelo);
        this.construccion = construccion;
    }
}
