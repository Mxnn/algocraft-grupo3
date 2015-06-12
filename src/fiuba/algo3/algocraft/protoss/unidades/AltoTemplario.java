package fiuba.algo3.algocraft.protoss.unidades;

import fiuba.algo3.algocraft.*;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.excepciones.ExcepcionUnidadEnemiga;

public class AltoTemplario extends UnidadMagica /*implements Alucinable*/ {
    public static final int VIDA_INICIAL = 40;
    public static final int ESCUDO_INICIAL = 40;
    public static final int VISION = 7;
    public static final int CUPO_TRANSPORTE = 2;
    public static final int TIEMPO_DE_CONSTRUCCION = 7;
    /*public final int VIDA_UNIDAD_ALUCINADA = 0;
    public final int CANTIDAD_ALUCINACIONES = 2;*/

    public static int COSTO_MINERAL = 50;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAS);

    public AltoTemplario(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        this.suministro = 2;
        propietario.agregarUnidad(this);
        this.propietario = propietario;
        this.vitalidad = new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL);

        this.vision = VISION;
        this.cupoDeTransporte = CUPO_TRANSPORTE;

        this.tiempoDeConstruccion = TIEMPO_DE_CONSTRUCCION;

        this.ENERGIA_INICIAL = 50;
        this.REGENERACION_ENERGIA = 15;
        this.energiaMaxima = 200;
        this.energia = ENERGIA_INICIAL;
    }
    
    public void crearAlucinacion(UnidadAgresora unidadAClonar, Mapa mapa) throws ExcepcionUnidadEnemiga, ExcepcionNoHayLugarDisponible {
        if (!(this.propietario).equals(unidadAClonar.getPropietario()))
            throw new ExcepcionUnidadEnemiga();
        //chequear que sea agresor
        Clon clon = new Clon(unidadAClonar, this.propietario);
        mapa.ubicarCercaDeParcela(unidadAClonar.getParcela(), clon);
        Clon clon2 = new Clon(unidadAClonar, this.propietario);
        mapa.ubicarCercaDeParcela(unidadAClonar.getParcela(), clon2);
    }
    
}
