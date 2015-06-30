package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.NaveTransporte;
import fiuba.algo3.algocraft.vista.VistaMapa;

import java.awt.event.ActionEvent;

public class CrearNaveTransporteProtossListener extends CreadorDeUnidadListener {

	public CrearNaveTransporteProtossListener(Juego modelo, PuertoEstelarProtoss representado) {
        super(modelo, representado);
    }

	public void actionPerformed(ActionEvent arg0) {
		try {
            NaveTransporte nave = ((PuertoEstelarProtoss) (this.construccion)).crearNaveTransporte(modelo.getMapa());
            nave.setObservador(VistaMapa.getInstance());
        } catch (ExcepcionNoHaySuministrosDisponibles e) {
            this.mostrarError(e.getMessage());
        } catch (ExcepcionNoHayLugarDisponible e) {
            this.mostrarError(e.getMessage());
        } catch (ExcepcionRecursosInsuficientes e) {
            this.mostrarError(e.getMessage());
        }
    }
}
