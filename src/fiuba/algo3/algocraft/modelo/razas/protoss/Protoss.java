package fiuba.algo3.algocraft.modelo.razas.protoss;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.razas.Raza;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Asimilador;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.NexoMineral;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.Pilon;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.AdicionalSuministros;
import fiuba.algo3.algocraft.vista.ObservadorMapa;

public class Protoss extends Raza {
    private static Protoss INSTANCIA = null;

    private Protoss() { }

    private synchronized static void createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new Protoss();
        }
    }

    public static Protoss getInstance() {
        if (INSTANCIA == null)
            createInstance();

        return INSTANCIA;
    }

    @Override
	public ExtractorGas crearExtractorGas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario, Asimilador.COSTO))
            throw new ExcepcionRecursosInsuficientes();

        Asimilador asimilador = new Asimilador(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(asimilador);
    	}
        
		return asimilador;
	}

    @Override
	public ExtractorMineral crearExtractorMineral(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario, NexoMineral.COSTO))
            throw new ExcepcionRecursosInsuficientes();
        
        NexoMineral nexoMineral = new NexoMineral(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(nexoMineral);
    	}

		return nexoMineral;
	}

    @Override
    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario, Pilon.COSTO))
            throw new ExcepcionRecursosInsuficientes();
        
        Pilon pilon = new Pilon(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(pilon);
    	}
        return pilon;
    }

    @Override
    public Construccion crearCreadorDeUnidadesBasicas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario, Acceso.COSTO))
            throw new ExcepcionRecursosInsuficientes();
        
        Acceso acceso = new Acceso(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(acceso);
    	}

        return acceso;
    }

    @Override
    public Construccion crearCreadorDeUnidadesAvanzadas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes{
        if (recursosInsuficientes(propietario, PuertoEstelarProtoss.COSTO))
            throw new ExcepcionRecursosInsuficientes();
        
        PuertoEstelarProtoss puerto = new PuertoEstelarProtoss(propietario);

        for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(puerto);
    	}
        
        return puerto;
    }

    @Override
    public Construccion crearCreadorDeUnidadesMagicas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes{
        if (recursosInsuficientes(propietario, ArchivosTemplarios.COSTO))
            throw new ExcepcionRecursosInsuficientes();
        
        
        ArchivosTemplarios archivo = new ArchivosTemplarios(propietario);
        
        
    	for(int i=0; i<this.observadores.size();i++){
    		ObservadorMapa observador = this.observadores.get(i);
    		observador.crearInteractuable(archivo);
    	}
    	
        return archivo;
    }
    
}
