package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearGolliatListener implements ActionListener {
    private Juego modelo;
	private Fabrica representado;

	public CrearGolliatListener(Juego modelo, Fabrica representado){
		this.modelo = modelo;
		this.representado = representado;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			this.representado.crearGolliat(modelo.getMapa());
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
