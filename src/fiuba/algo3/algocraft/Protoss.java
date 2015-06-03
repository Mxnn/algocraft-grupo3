package fiuba.algo3.algocraft;

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

	public ExtractorGas crearExtractorGas(Jugador jugador) {
		return null;
	}

	public ExtractorMineral crearExtractorMineral(Jugador propietario) {
		return null;
	}

    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) {
        return null;
    }

    public CreadorDeSoldados crearCreadorDeSoldados(Jugador propietario) {
        return null;
    }

    public CreadorDeUnidadesTerrestres crearCreadorDeUnidadesTerrestres(Jugador propietario) {
        return null;
    }
}
