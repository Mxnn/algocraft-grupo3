package fiuba.algo3.algocraft;

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
}
