package fiuba.algo3.algocraft.utilidades.unidades;

import java.util.ArrayList;
import fiuba.algo3.algocraft.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public class AtaqueTormentaPsionica extends Ataque {
	public static final int TURNOS_DE_DURACION = 2;
	public static final int DANYO_POR_TURNO = 50;
	
	public AtaqueTormentaPsionica(Parcela target){
		super(target);
		this.duracionDeAtaque = TURNOS_DE_DURACION;
	}
	
	public void tareaDeEntreTurno(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		this.listaParcelas = new ArrayList<Parcela>();
		(this.listaParcelas).addAll(mapa.devolverParcelasEnRadioUno(this.target));
		super.tareaDeEntreTurno(mapa);
	}

    @Override
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
	}

    @Override
	public void atacar(Unidad enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(DANYO_POR_TURNO);
	}
}
