package fiuba.algo3.algocraft.utilidades.unidades;


import fiuba.algo3.algocraft.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.Vitalidad;
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;

public class AtaqueEMP extends Ataque {
	
	public void atacar(Interactuable enemigo) throws ExcepcionEstadoMuerto{
		this.vaciarEscudo(enemigo.getVitalidad());
	}
	
	public void atacar(UnidadMagica enemigo) throws ExcepcionEnergiaInsuficiente{
		this.vaciarMagia(enemigo);
	}
	
	private void vaciarEscudo(VitalidadProtoss vitalidad) throws ExcepcionEstadoMuerto {
		vitalidad.recibirDanyo(vitalidad.getEscudo());
	}
	
	private void vaciarEscudo(Vitalidad vitalidad) throws ExcepcionEstadoMuerto {
	}

	
	private void vaciarMagia(UnidadMagica enemigo) throws ExcepcionEnergiaInsuficiente{
		enemigo.gastarEnergia(enemigo.getEnergia());
	}



}
