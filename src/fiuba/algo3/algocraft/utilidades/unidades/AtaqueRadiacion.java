package fiuba.algo3.algocraft.utilidades.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public class AtaqueRadiacion extends Ataque {
	private Mapa mapa;
	private Interactuable enemigo;
	public static final int DANYO_POR_TURNO = 15;
	
	public AtaqueRadiacion(Parcela target){
		super(target);
//		this.mapa = mapa;
//		this.target = target;
		this.enemigo = target.devolverElemento();
	}
	@Override
	//hacer refactor aca para poder meter mas cosas en ataque
//	public void ejecutarAtaque() throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa {
//		this.refreshParcelas();
//		super.ejecutarAtaque();
//	}
	
	public void tareaDeEntreTurno(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		this.listaParcelas = new ArrayList<Parcela>();
		(this.listaParcelas).addAll(mapa.devolverParcelasEnRadioUno(enemigo.getParcela()));
		super.tareaDeEntreTurno(mapa);
	}
	
	private void refreshParcelas() throws ExcepcionCoordenadaFueraDelMapa{
		this.listaParcelas = mapa.devolverParcelasEnRadioUno(enemigo.getParcela());
	}

	@Override
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
	}

	@Override
	public void atacar(UnidadAgresora enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(DANYO_POR_TURNO);
	}

	@Override
	public void atacar(UnidadMagica enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(DANYO_POR_TURNO);
	}

	@Override
	public void atacar(NaveTransporte enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(DANYO_POR_TURNO);
	}
	
	@Override
	public boolean esDescartable(){
		return (enemigo.getVida() <= 0);
	}

}
