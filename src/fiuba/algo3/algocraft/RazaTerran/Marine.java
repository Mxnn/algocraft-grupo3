package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public class Marine extends UnidadTerrestre {
    public static int COSTO_MINERAL = 50;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public static final int VIDA_INICIAL = 40;
    public static final int VISION = 7;
    public static final int CUPO_TRANSPORTE = 1;
    public static final int TIEMPO_DE_CONSTRUCCION = 3;

    public Marine(Jugador propietario, Parcela parcela) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 1;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);
        /*this.danyo = new Danyo(6, 6);*/
        this.vision = VISION;
        this.cupoDeTransporte = CUPO_TRANSPORTE;
        this.rangoAtaque = new RangoAtaque(4, 0);
        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
        this.parcela = parcela;
    }
}
