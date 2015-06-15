package fiuba.algo3.algocraft.razas;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.utilidades.Costo;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.utilidades.unidades.AdicionalSuministros;

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

    public Construccion crearCreadorDeUnidadesBasicas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
		return null;
	}

    public Construccion crearCreadorDeUnidadesAvanzadas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
		return null;
	}

    public Construccion crearCreadorDeUnidadesMagicas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
		return null;
	}
}
