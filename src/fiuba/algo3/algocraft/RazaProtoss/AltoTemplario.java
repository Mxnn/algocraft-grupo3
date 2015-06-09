package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEnemigoNoAtacable;
import fiuba.algo3.algocraft.Excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;

public class AltoTemplario extends UnidadMagica {
    public static final int VIDA_INICIAL = 40;
    public static final int ESCUDO_INICIAL = 40;
    public static final int VISION = 7;
    public static final int CUPO_TRANSPORTE = 2;
    public static final int TIEMPO_DE_CONSTRUCCION = 7;

    public static int COSTO_MINERAL = 50;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAS);

    public AltoTemplario(Jugador propietario, Parcela parcela) throws ExcepcionNoHaySuministrosDisponibles {
        this.SUMINISTRO = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.estado = new EstadoProtoss(VIDA_INICIAL, ESCUDO_INICIAL);

        this.vision = VISION;
        this.cupoDeTransporte = CUPO_TRANSPORTE;

        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;
        this.parcelaUbicacion = parcela;
    }
    
}
