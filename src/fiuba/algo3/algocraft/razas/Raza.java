package fiuba.algo3.algocraft.razas;

import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.AdicionalSuministros;

public abstract class Raza {

    public boolean recursosInsuficientes(Jugador propietario, Costo costo) {
	    return((propietario.getGasVespeno()<costo.getCostoGas()) || (propietario.getMinerales()<costo.getCostoMineral()));
	}

	public void restarCosto(Jugador propietario, Costo costo) {
		propietario.sumarGasVespeno(-(costo.getCostoGas()));
	   	propietario.sumarMinerales(-(costo.getCostoMineral()));
	}
		    
    public abstract AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) throws ExcepcionRecursosInsuficientes;

	public abstract ExtractorGas crearExtractorGas(Jugador propietario) throws ExcepcionRecursosInsuficientes;

	public abstract ExtractorMineral crearExtractorMineral(Jugador propietario) throws ExcepcionRecursosInsuficientes;

    public abstract Construccion crearCreadorDeUnidadesBasicas(Jugador propietario) throws ExcepcionRecursosInsuficientes;

    public abstract Construccion crearCreadorDeUnidadesAvanzadas(Jugador propietario) throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas;

    public abstract Construccion crearCreadorDeUnidadesMagicas(Jugador propietario) throws ExcepcionRecursosInsuficientes, ExcepcionConstruccionesRequeridasNoCreadas;
}
