package fiuba.algo3.algocraft.modelo.razas.terran;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.razas.Raza;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Asimilador;
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
import fiuba.algo3.algocraft.vista.ObservadorMapa;

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

	public ExtractorGas crearExtractorGas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario, Refineria.COSTO))
            throw new ExcepcionRecursosInsuficientes();

        Refineria refineria = new Refineria(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(refineria);
    	}
        
		return refineria;
	}

    @Override
	public ExtractorMineral crearExtractorMineral(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,CentroDeMineral.COSTO))
            throw new ExcepcionRecursosInsuficientes();

        CentroDeMineral centroDeMineral = new CentroDeMineral(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(centroDeMineral);
    	}
        
		return centroDeMineral;
	}

    @Override
    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,DepositoSuministro.COSTO))
            throw new ExcepcionRecursosInsuficientes();

        DepositoSuministro depositoSuministro = new DepositoSuministro(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(depositoSuministro);
    	}
        
        return depositoSuministro;
    }

    @Override
    public Construccion crearCreadorDeUnidadesBasicas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Barraca.COSTO))
            throw new ExcepcionRecursosInsuficientes();

        Barraca barraca = new Barraca(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(barraca);
    		barraca.setObservador(this.observadores.get(i));
    	}
        
        return barraca;
    }

    @Override
    public Construccion crearCreadorDeUnidadesAvanzadas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Fabrica.COSTO))
            throw new ExcepcionRecursosInsuficientes();
       
        Fabrica fabrica = new Fabrica(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(fabrica);
    		fabrica.setObservador(this.observadores.get(i));
    	}
    	return fabrica;
    }

    @Override
    public Construccion crearCreadorDeUnidadesMagicas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,PuertoEstelar.COSTO))
            throw new ExcepcionRecursosInsuficientes();

        PuertoEstelar puertoEstelar = new PuertoEstelar(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(puertoEstelar);
    		puertoEstelar.setObservador(this.observadores.get(i));
    	}
        
    	return new PuertoEstelar(propietario);
    }
}
