package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.utilidades.Costo;

public abstract class Raza {

	
	   public boolean recursosInsuficientes(Jugador propietario, Costo costo){

		    return((propietario.getGasVespeno()<costo.getCostoGas()) || (propietario.getMinerales()<costo.getCostoMineral()));
		   
	   }

	   public void restarCosto(Jugador propietario, Costo costo){
		    	propietario.sumarGasVespeno(-(costo.getCostoGas()));
		    	propietario.sumarMinerales(-(costo.getCostoMineral()));
	   }
		    
    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) throws ExcepcionRecursosInsuficientes {
		return null;
	}

	public ExtractorGas crearExtractorGas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
		return null;
	}

	public ExtractorMineral crearExtractorMineral(Jugador propietario) throws ExcepcionRecursosInsuficientes {
		return null;
	}

    public Construccion crearCreadorDeSoldados(Jugador propietario) throws ExcepcionRecursosInsuficientes {
		return null;
	}

    public Construccion crearCreadorDeUnidadesTerrestres(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
		return null;
	}

    public Construccion crearCreadorDeUnidadesAereas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
		return null;
	}
}
