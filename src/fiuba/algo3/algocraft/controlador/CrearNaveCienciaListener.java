package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import java.awt.event.ActionEvent;

public class CrearNaveCienciaListener extends CreadorDeUnidadListener {

	public CrearNaveCienciaListener(Juego modelo, PuertoEstelar representado){
		super(modelo, representado);
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
            ((PuertoEstelar) (this.construccion)).crearNaveCiencia(modelo.getMapa());
		} catch (ExcepcionNoHaySuministrosDisponibles e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionNoHayLugarDisponible e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionEntidadEnConstruccion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
