package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.RazaTerran.Marine;

public class Barraca extends CreadorDeSoldados {

    private static final int VIDA_INICIAL = 1000;
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
	public Barraca(Jugador propietario) {
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);
        this.tiempoDeConstruccion = 12;
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.CREADOR_DE_SOLDADOS;
    }

    public Marine crearMarine() throws ExcepcionNoHaySuministrosDisponibles {
        return new Marine(this.propietario);
    }
}
