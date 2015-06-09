package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.ConstruccionesProtoss.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;

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

 
    
	public ExtractorGas crearExtractorGas(Jugador propietario, Parcela parcela) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Asimilador.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,Asimilador.COSTO);
		return new Asimilador(propietario, parcela);
	}

	public ExtractorMineral crearExtractorMineral(Jugador propietario, Parcela parcela) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,NexoMineral.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,NexoMineral.COSTO);
		return new NexoMineral(propietario, parcela);
	}

    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario, Parcela parcela) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Pilon.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario, Pilon.COSTO);
        return new Pilon(propietario, parcela);
    }

    public CreadorDeSoldados crearCreadorDeSoldados(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Acceso.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,Acceso.COSTO);
        return new Acceso(propietario);
    }

    public CreadorDeUnidadesTerrestres crearCreadorDeUnidadesTerrestres(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes{
        if (recursosInsuficientes(propietario, ArchivosTemplarios.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario, ArchivosTemplarios.COSTO);
    	return new ArchivosTemplarios(propietario);
    }

    public CreadorDeUnidadesAereas crearCreadorDeUnidadesAereas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes{
        if (recursosInsuficientes(propietario,PuertoEstelarProtoss.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,PuertoEstelarProtoss.COSTO);
    	return new PuertoEstelarProtoss(propietario);
    }
}
