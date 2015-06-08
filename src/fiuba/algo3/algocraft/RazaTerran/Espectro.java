package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public class Espectro extends UnidadVoladora {
    public static int COSTO_MINERAL = 150;
    public static int COSTO_GAS = 100;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public static final int SUMINISTRO = 2;
    public static final int VIDA_INICIAL = 120;
    public static final int VISION = 7;
    public static final int TIEMPO_DE_CONSTRUCCION = 8;

    public Espectro(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        propietario.incrementarPoblacion(SUMINISTRO);
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);
        /*this.danyo = new Danyo(20, 8);*/
        this.vision = VISION;
        this.rangoAtaque = new RangoAtaque(5, 0);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
    }
}
