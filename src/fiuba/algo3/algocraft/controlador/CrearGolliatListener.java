package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import java.awt.event.ActionEvent;

public class CrearGolliatListener extends CreadorDeUnidadListener {

	public CrearGolliatListener(Juego modelo, Fabrica representado){
		super(modelo, representado);
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
            ((Fabrica) (this.construccion)).crearGolliat(modelo.getMapa());
        } catch (ExcepcionNoHaySuministrosDisponibles e) {
            this.mostrarError(msjNoHaySuministrosDisponible);
        } catch (ExcepcionNoHayLugarDisponible e) {
            this.mostrarError(msjNoHayLugarDisponible);
        } catch (ExcepcionEntidadEnConstruccion e) {
            this.mostrarError(msjEntidadEnConstruccion);
        }
	}
}
