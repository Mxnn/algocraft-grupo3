package fiuba.algo3.algocraft.modelo.utilidades.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;

public class AtaqueEMP extends Ataque {
	public static final int TURNOS_DE_DURACION = 1;
	
	public AtaqueEMP(Parcela target){
		super(target);
		this.duracionDeAtaque = TURNOS_DE_DURACION;
	}

    @Override
	public void tareaDeEntreTurno(Mapa mapa) throws ExcepcionCoordenadaFueraDelMapa, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		this.listaParcelas = new ArrayList<Parcela>();
		(this.listaParcelas).addAll(mapa.devolverParcelasEnRadioUno(this.target));
		super.tareaDeEntreTurno(mapa);
	}

    @Override
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto{
	}

    @Override
	public void atacar(Unidad enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance{
    	enemigo.recibirEmp();
	}
}

