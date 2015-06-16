package fiuba.algo3.algocraft.utilidades.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public class AtaqueTormentaPsionica extends Ataque {
	public static final int TURNOS_DE_DURACION = 2;
	public static final int DANYO_POR_TURNO = 50;
//	private ArrayList<Parcela> listaParcelas;
	
	public AtaqueTormentaPsionica(Parcela target){
		super(target);
//		this.listaParcelas = listaParcelas;
		this.duracionDeAtaque = TURNOS_DE_DURACION;
	}
	
	public void tareaDeEntreTurno(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		this.listaParcelas = new ArrayList<Parcela>();
		(this.listaParcelas).addAll(mapa.devolverParcelasEnRadioUno(this.target));
		super.tareaDeEntreTurno(mapa);
	}
	
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
	}
	
//	public void atacar(Unidad enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
//		enemigo.recibirDanyo(DANYO_POR_TURNO);
//	}
	
	public void atacar(UnidadAgresora enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(DANYO_POR_TURNO);
	}

	public void atacar(UnidadMagica enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(DANYO_POR_TURNO);
	}

	public void atacar(NaveTransporte enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(DANYO_POR_TURNO);
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

//	@Override
//	public boolean descartarAtaque() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
