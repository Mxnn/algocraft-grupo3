package fiuba.algo3.algocraft.razas.protoss;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.razas.protoss.construcciones.Acceso;
import fiuba.algo3.algocraft.razas.protoss.construcciones.ArchivosTemplarios;
import fiuba.algo3.algocraft.razas.protoss.construcciones.Asimilador;
import fiuba.algo3.algocraft.razas.protoss.construcciones.NexoMineral;
import fiuba.algo3.algocraft.razas.protoss.construcciones.Pilon;
import fiuba.algo3.algocraft.razas.protoss.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.razas.Raza;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.utilidades.unidades.AdicionalSuministros;

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

	public ExtractorGas crearExtractorGas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Asimilador.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,Asimilador.COSTO);
		return new Asimilador(propietario);
	}

	public ExtractorMineral crearExtractorMineral(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,NexoMineral.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,NexoMineral.COSTO);
		return new NexoMineral(propietario);
	}

    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Pilon.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario, Pilon.COSTO);
        return new Pilon(propietario);
    }

    public Construccion crearCreadorDeSoldados(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Acceso.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,Acceso.COSTO);
        return new Acceso(propietario);
    }

    public Construccion crearCreadorDeUnidadesTerrestres(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes{
        if (recursosInsuficientes(propietario, PuertoEstelarProtoss.COSTO))
            throw new ExcepcionRecursosInsuficientes();

        restarCosto(propietario,PuertoEstelarProtoss.COSTO);
        return new PuertoEstelarProtoss(propietario);
    }

    public Construccion crearCreadorDeUnidadesAereas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes{
        if (recursosInsuficientes(propietario, ArchivosTemplarios.COSTO))
            throw new ExcepcionRecursosInsuficientes();

        restarCosto(propietario, ArchivosTemplarios.COSTO);
        return new ArchivosTemplarios(propietario);
    }
}
