package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearScoutListener implements ActionListener {
    private Juego modelo;
    private PuertoEstelarProtoss representado;
	public CrearScoutListener(Juego modelo, PuertoEstelarProtoss representado){
		this.modelo = modelo;
		this.representado = representado;
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
			this.representado.crearScout(modelo.getMapa());
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
