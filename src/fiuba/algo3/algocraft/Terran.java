package fiuba.algo3.algocraft;

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
}
