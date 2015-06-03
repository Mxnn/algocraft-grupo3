package fiuba.algo3.algocraft;

public class Terran implements Raza {
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
		return new Refineria(propietario);
	}

	public ExtractorMineral crearExtractorMineral(Jugador propietario) {
		return new CentroDeMineral(propietario);
	}

    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) {
        return new DepositoSuministro(propietario);
    }
}
