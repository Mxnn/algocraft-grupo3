package fiuba.algo3.algocraft.modelo.razas;

import java.util.ArrayList;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.AdicionalSuministros;
import fiuba.algo3.algocraft.vista.ObservadorMapa;

public abstract class Raza {

    protected ArrayList<ObservadorMapa> observadores = new ArrayList<ObservadorMapa>();

	public boolean recursosInsuficientes(Jugador propietario, Costo costo) {
	    return((propietario.getGasVespeno()<costo.getCostoGas()) || (propietario.getMinerales()<costo.getCostoMineral()));
	}
		    
    public abstract AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario);

	public abstract ExtractorGas crearExtractorGas(Jugador propietario);

	public abstract ExtractorMineral crearExtractorMineral(Jugador propietario);

    public abstract Construccion crearCreadorDeUnidadesBasicas(Jugador propietario);

    public abstract Construccion crearCreadorDeUnidadesAvanzadas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas;

    public abstract Construccion crearCreadorDeUnidadesMagicas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas;

	public void setObservadores(ObservadorMapa observador) {
		if(this.observadores.size()<1)
			this.observadores.add(observador);
	}

    public void confirmarCreacionDeConstruccion() {
        for (ObservadorMapa observador: this.observadores) {
            observador.agregarConstruccionEnEspera();
        }
    }
}
