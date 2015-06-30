package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import java.awt.event.ActionEvent;

public class CrearScoutListener extends CreadorDeUnidadListener {

	public CrearScoutListener(Juego modelo, PuertoEstelarProtoss representado){
		super(modelo, representado);
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
            ((PuertoEstelarProtoss) (this.construccion)).crearScout(modelo.getMapa());
        } catch (ExcepcionNoHaySuministrosDisponibles e) {
            this.mostrarError(e.getMessage());
        } catch (ExcepcionNoHayLugarDisponible e) {
            this.mostrarError(e.getMessage());
        } catch (ExcepcionRecursosInsuficientes e) {
            this.mostrarError(e.getMessage());
        }
    }
}
