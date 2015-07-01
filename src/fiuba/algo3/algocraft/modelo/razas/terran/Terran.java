package fiuba.algo3.algocraft.modelo.razas.terran;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.razas.Raza;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.DepositoSuministro;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.AdicionalSuministros;
import fiuba.algo3.algocraft.vista.observadores.mapa.ObservadorMapa;

public class Terran extends Raza {
    private static Terran INSTANCIA = null;
    private Terran() { }

    private synchronized static void createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new Terran();
        }
    }

    public static Terran getInstance() {
        if (INSTANCIA == null)
            createInstance();

        return INSTANCIA;
    }

	public ExtractorGas crearExtractorGas(Jugador propietario) {
        Refineria refineria = new Refineria(propietario);

        for (ObservadorMapa observador: this.observadores) {
    		observador.crearConstruccion(refineria);
    	}
        
		return refineria;
	}

    @Override
	public ExtractorMineral crearExtractorMineral(Jugador propietario) {
        CentroDeMineral centroDeMineral = new CentroDeMineral(propietario);

        for (ObservadorMapa observador: this.observadores) {
    		observador.crearConstruccion(centroDeMineral);
    	}
        
		return centroDeMineral;
	}

    @Override
    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) {
        DepositoSuministro depositoSuministro = new DepositoSuministro(propietario);

        for (ObservadorMapa observador: this.observadores) {
    		observador.crearConstruccion(depositoSuministro);
    	}
        
        return depositoSuministro;
    }

    @Override
    public Construccion crearCreadorDeUnidadesBasicas(Jugador propietario) {
        Barraca barraca = new Barraca(propietario);

        for (ObservadorMapa observador: this.observadores) {
    		observador.crearConstruccion(barraca);
    		barraca.setObservador(observador);
    	}
        
        return barraca;
    }

    @Override
    public Construccion crearCreadorDeUnidadesAvanzadas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        Fabrica fabrica = new Fabrica(propietario);

        for (ObservadorMapa observador: this.observadores) {
    		observador.crearConstruccion(fabrica);
    		fabrica.setObservador(observador);
    	}
    	return fabrica;
    }

    @Override
    public Construccion crearCreadorDeUnidadesMagicas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        PuertoEstelar puertoEstelar = new PuertoEstelar(propietario);

        for (ObservadorMapa observador: this.observadores) {
    		observador.crearConstruccion(puertoEstelar);
    		puertoEstelar.setObservador(observador);
    	}
        
    	return puertoEstelar;
    }
}
