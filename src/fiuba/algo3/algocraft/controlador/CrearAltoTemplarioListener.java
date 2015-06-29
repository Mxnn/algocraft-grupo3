package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import java.awt.event.ActionEvent;

public class CrearAltoTemplarioListener extends CreadorDeUnidadListener {

	public CrearAltoTemplarioListener(Juego modelo, ArchivosTemplarios representado) {
        super(modelo, representado);
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
            ((ArchivosTemplarios) (this.construccion)).crearAltoTemplario(modelo.getMapa());
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			this.mostrarError(e.getMessage());
		} catch (ExcepcionNoHayLugarDisponible e) {
            this.mostrarError(e.getMessage());
		} 
	}
}

