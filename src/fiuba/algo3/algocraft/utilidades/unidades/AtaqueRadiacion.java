package fiuba.algo3.algocraft.utilidades.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public class AtaqueRadiacion extends Ataque {
	private Interactuable enemigo;
	public static final int DANYO_POR_TURNO = 15;
	
	public AtaqueRadiacion(Parcela target){
		super(target);
		this.enemigo = target.devolverElemento();
	}

    @Override
	public void tareaDeEntreTurno(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		this.listaParcelas = new ArrayList<Parcela>();
		(this.listaParcelas).addAll(mapa.devolverParcelasEnRadioUno(enemigo.getParcela()));
		super.tareaDeEntreTurno(mapa);
	}

	@Override
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
	}

	@Override
	public void atacar(Unidad enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(DANYO_POR_TURNO);
	}

	
	@Override
	public boolean esDescartable(){
		return (enemigo.getVida() <= 0);
	}

}
