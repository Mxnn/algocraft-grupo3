package fiuba.algo3.algocraft.utilidades.unidades;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;

public abstract class Ataque{	
	protected int duracionDeAtaque;
	protected int cantidadDeAtaques;
	protected Parcela target;
	protected ArrayList<Parcela> listaParcelas;

	public Ataque(Parcela target){
		this.listaParcelas = new ArrayList<Parcela>();
		this.target = target;
	}
	
	public void tareaDeEntreTurno(Mapa mapa) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa{
		ejecutarAtaque();
	}
	
	public void ejecutarAtaque() throws ExcepcionEstadoMuerto,ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa {
		this.cantidadDeAtaques += 1;
		for (int i = 0; i < this.listaParcelas.size(); i++) {
    		Parcela parcela = (this.listaParcelas).get(i);
			if(!parcela.estaVacia()){
				Interactuable enemigo = parcela.devolverElemento();
				enemigo.recibirAtaque(this);
			}
		}
	}
	
	public boolean esDescartable(){
		return ((this.duracionDeAtaque - this.cantidadDeAtaques) == 0);
	}
//	public void destruir() {
//        (this.propietario).eliminarUnidad(this);
//    }
	public abstract void atacar(Construccion enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;
//	public abstract void atacar(Unidad enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;
	public abstract void atacar(UnidadAgresora enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;
	public abstract void atacar(UnidadMagica enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;
	public abstract void atacar(NaveTransporte enemigo) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance;

}
