package fiuba.algo3.algocraft.protoss.unidades;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.excepciones.ExcepcionUnidadEnemiga;
import fiuba.algo3.algocraft.mapa.Mapa;

public class AltoTemplario extends UnidadMagica {

    public static final int VIDA_INICIAL = 40;
    public static final int ESCUDO_INICIAL = 40;
    public static final int VISION = 7;
    public static final int CUPO_DE_TRANSPORTE = 2;
    public static final int TIEMPO_DE_CONSTRUCCION = 7;
    public static final int SUMINISTRO = 2;
    public static final int ENERGIA_MAXIMA = 200;
    public static final int ENERGIA_INICIAL = 50;
    public static final int REGENERACION_ENERGIA = 15;

    public static int COSTO_MINERAL = 50;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public AltoTemplario(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, ENERGIA_MAXIMA, ENERGIA_INICIAL, REGENERACION_ENERGIA);
    }
    
    public void crearAlucinacion(UnidadAgresora unidadAClonar, Mapa mapa) throws ExcepcionUnidadEnemiga, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles {
        if (!(this.propietario).equals(unidadAClonar.getPropietario()))
            throw new ExcepcionUnidadEnemiga();
        //chequear que sea agresor
        Clon clon = new Clon(unidadAClonar, this.propietario);
        mapa.ubicarCercaDeParcela(unidadAClonar.getParcela(), clon);
        Clon clon2 = new Clon(unidadAClonar, this.propietario);
        mapa.ubicarCercaDeParcela(unidadAClonar.getParcela(), clon2);
    }
    
}
