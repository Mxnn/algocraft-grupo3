package fiuba.algo3.algocraft.utilidades.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public class AtaqueTormentaPsionica extends Ataque {
	
	private ArrayList<Parcela> listaParcelas;
	
	public AtaqueTormentaPsionica(ArrayList<Parcela> listaParcelas){
		this.listaParcelas = listaParcelas;
	}
	
	
	public void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
	}

	
	public void atacar(UnidadAgresora enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(100);
	}

	public void atacar(UnidadMagica enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(100);
	}

	public void atacar(NaveTransporte enemigo) throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		enemigo.recibirDanyo(100);
	}

	@Override
	public void ejecutarAtaque() throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance {
		for (int i = 0; i < this.listaParcelas.size(); i++) {
    		Parcela parcela = (this.listaParcelas).get(i);
			if(!parcela.estaVacia()){
				Interactuable enemigo = parcela.devolverElemento();
				enemigo.recibirAtaque(this);
			}
		}
	}

	@Override
	public boolean descartarAtaque() {
		// TODO Auto-generated method stub
		return false;
	}

}
