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
	
	public AtaqueRadiacion(Interactuable enemigo, Mapa mapa){
		this.mapa = mapa;
		this.enemigo = enemigo;
	}
	@Override
	//hacer refactor aca para poder meter mas cosas en ataque
	public void ejecutarAtaque() throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa {
//		this.cantidadDeAtaques += 1;
		ArrayList<Parcela> listaParcelas = mapa.devolverParcelasEnRadioUno(enemigo.getParcela());
		for (int i = 0; i < listaParcelas.size(); i++) {
    		Parcela parcela = (listaParcelas).get(i);
			if(!parcela.estaVacia()){
				Interactuable enemigo = parcela.devolverElemento();
				enemigo.recibirAtaque(this);
			}
		}
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
