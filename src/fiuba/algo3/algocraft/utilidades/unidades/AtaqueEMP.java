package fiuba.algo3.algocraft.utilidades.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.Vitalidad;
import fiuba.algo3.algocraft.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public class AtaqueEMP extends Ataque {
	public static final int TURNOS_DE_DURACION = 1;
	
	public AtaqueEMP(Parcela target){
		super(target);
		this.duracionDeAtaque = TURNOS_DE_DURACION;

	}

	public void tareaDeEntreTurno(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		this.listaParcelas = new ArrayList<Parcela>();
		(this.listaParcelas).addAll(mapa.devolverParcelasEnRadioUno(this.target));
		super.tareaDeEntreTurno(mapa);
	}
	
	public void atacar(UnidadAgresora enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance{
		(enemigo.getVitalidad()).recibirEmp();
	}
	
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto{
	}
	
//	public void atacar(Unidad enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance{
//		(enemigo.getVitalidad()).recibirEmp();
//		this.vaciarMagia(enemigo);
//	}
	
	public void atacar(UnidadMagica enemigo) throws ExcepcionEstadoMuerto{
		(enemigo.getVitalidad()).recibirEmp();
		this.vaciarMagia(enemigo);
	}
	
	public void atacar(NaveTransporte enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance{
		(enemigo.getVitalidad()).recibirEmp();
	}
	
	private void vaciarMagia(UnidadMagica enemigo){
//		enemigo.gastarEnergia(enemigo.getEnergia());
		
		enemigo.recibirEmp();
	}
	

//	@Override
//	public void ejecutarAtaque() throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
//		this.cantidadDeAtaques += 1;
//		for (int i = 0; i < this.listaParcelas.size(); i++) {
//    		Parcela parcela = (this.listaParcelas).get(i);
//			if(!parcela.estaVacia()){
//				Interactuable enemigo = parcela.devolverElemento();
//				enemigo.recibirAtaque(this);
//			}
//		}
//	}

	
//	public boolean descartarAtaque() {
//		// TODO Auto-generated method stub
//		return false;
//	}



}
