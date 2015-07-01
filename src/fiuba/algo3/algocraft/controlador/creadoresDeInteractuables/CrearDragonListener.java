package fiuba.algo3.algocraft.controlador.creadoresDeInteractuables;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import java.awt.event.ActionEvent;

public class CrearDragonListener extends CreadorDeUnidadListener {

	public CrearDragonListener(Juego modelo, Acceso representado){
        super(modelo, representado);
	}
	public void actionPerformed(ActionEvent arg0) {
		try {
            ((Acceso) (this.construccion)).crearDragon(modelo.getMapa());
        } catch (ExcepcionNoHaySuministrosDisponibles e) {
            this.mostrarError(e.getMessage());
        } catch (ExcepcionNoHayLugarDisponible e) {
            this.mostrarError(e.getMessage());
        } catch (ExcepcionRecursosInsuficientes e) {
            this.mostrarError(e.getMessage());
        }
    }
}

