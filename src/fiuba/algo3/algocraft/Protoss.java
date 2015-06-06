package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.ConstruccionesProtoss.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;

public class Protoss implements Raza {
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

	public ExtractorGas crearExtractorGas(Jugador propietario) {
		return new Asimilador(propietario);
	}

	public ExtractorMineral crearExtractorMineral(Jugador propietario) {
		return new NexoMineral(propietario);
	}

    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) {
        return new Pilon(propietario);
    }

    public CreadorDeSoldados crearCreadorDeSoldados(Jugador propietario) {
        return new Acceso(propietario);
    }

    public CreadorDeUnidadesTerrestres crearCreadorDeUnidadesTerrestres(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas{
        return new ArchivosTemplarios(propietario);
    }

    public CreadorDeUnidadesAereas crearCreadorDeUnidadesAereas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas{
        return new PuertoEstelar(propietario);
    }
}
