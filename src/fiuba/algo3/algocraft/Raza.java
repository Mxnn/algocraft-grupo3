package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;

public abstract class Raza {

	
	   public boolean recursosInsuficientes(Jugador propietario, Costo costo){

		    return((propietario.obtenerGasVespeno()<costo.getCostoGas()) || (propietario.obtenerMineral()<costo.getCostoMineral()));
		   
	   }

	   public void restarCosto(Jugador propietario, Costo costo){
		    	propietario.sumarGasVespeno(-(costo.getCostoGas()));
		    	propietario.sumarMinerales(-(costo.getCostoMineral()));
	   }
		    
    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario, Parcela parcela) throws ExcepcionRecursosInsuficientes {
		return null;
	}

	public ExtractorGas crearExtractorGas(Jugador propietario, Parcela parcela) throws ExcepcionRecursosInsuficientes {
		return null;
	}

	public ExtractorMineral crearExtractorMineral(Jugador propietario, Parcela parcela) throws ExcepcionRecursosInsuficientes {
		return null;
	}

    public CreadorDeSoldados crearCreadorDeSoldados(Jugador propietario) throws ExcepcionRecursosInsuficientes {
		return null;
	}

    public CreadorDeUnidadesTerrestres crearCreadorDeUnidadesTerrestres(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
		return null;
	}

    public CreadorDeUnidadesAereas crearCreadorDeUnidadesAereas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
		return null;
	}
}
