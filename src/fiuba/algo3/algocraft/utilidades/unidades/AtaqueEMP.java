package fiuba.algo3.algocraft.utilidades.unidades;


import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.Vitalidad;
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public class AtaqueEMP extends Ataque {

	@Override
	public void atacar(UnidadAgresora enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance{
		(enemigo.getVitalidad()).recibirEmp();
	}
	
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto{
	}
	
	public void atacar(UnidadMagica enemigo){
		this.vaciarMagia(enemigo);
	}
	
	public void atacar(NaveTransporte enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance{
		(enemigo.getVitalidad()).recibirEmp();
	}
	
	private void vaciarMagia(UnidadMagica enemigo){
//		enemigo.gastarEnergia(enemigo.getEnergia());
		enemigo.recibirEmp();
	}
	
	



}
