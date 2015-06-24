package fiuba.algo3.algocraft.modelo.razas.protoss.unidades;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnergiaInsuficiente;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEntidadEnConstruccion;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadEnemiga;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionUnidadNoClonable;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.VitalidadProtoss;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.AtaqueTormentaPsionica;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Clon;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.NaveTransporte;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadAgresora;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.UnidadMagica;

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
    public static final int COSTO_ENERGIA_ALUCINACION = 100;
    public static final int COSTO_ENERGIA_TORMENTA = 75;
    public static int COSTO_MINERAL = 50;
    public static int COSTO_GAS = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);

    public AltoTemplario(Jugador propietario) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, new VitalidadProtoss(VIDA_INICIAL, ESCUDO_INICIAL), TIEMPO_DE_CONSTRUCCION, CUPO_DE_TRANSPORTE, VISION, SUMINISTRO, ENERGIA_MAXIMA, ENERGIA_INICIAL, REGENERACION_ENERGIA, COSTO);
    }
    
    public void crearAlucinacion(Interactuable unidadAClonar, Mapa mapa) throws ExcepcionUnidadEnemiga, ExcepcionNoHayLugarDisponible, ExcepcionNoHaySuministrosDisponibles, ExcepcionEnergiaInsuficiente, ExcepcionEntidadEnConstruccion, ExcepcionUnidadNoClonable {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        this.gastarEnergia(COSTO_ENERGIA_ALUCINACION);
//    	if (!(this.propietario).equals(unidadAClonar.getPropietario()))
//            throw new ExcepcionUnidadEnemiga();

//        Clon clon = new Clon(unidadAClonar, this.propietario);
        try{
        Clon clon = this.crearClon((UnidadAgresora) unidadAClonar);
        mapa.ubicarCercaDeParcela(unidadAClonar.getParcela(), clon);
//        Clon clon2 = new Clon(unidadAClonar, this.propietario);
        Clon clon2 = this.crearClon((UnidadAgresora) unidadAClonar);
        mapa.ubicarCercaDeParcela(unidadAClonar.getParcela(), clon2);
        }
        catch (ClassCastException e) {
        	throw new ExcepcionUnidadNoClonable();
        }
    }
    
    public Clon crearClon(UnidadAgresora unidadAClonar) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionEnergiaInsuficiente, ExcepcionUnidadEnemiga, ExcepcionNoHayLugarDisponible{
    	if (!(this.propietario).equals(unidadAClonar.getPropietario()))
            throw new ExcepcionUnidadEnemiga();

    	return new Clon(unidadAClonar, this.propietario);
    }

    public void crearClon(UnidadMagica unidadAClonar) throws ExcepcionUnidadNoClonable{
    	throw new ExcepcionUnidadNoClonable();
    }

    public void crearClon(Construccion unidadAClonar) throws ExcepcionUnidadNoClonable{
    	throw new ExcepcionUnidadNoClonable();
    }

    public void crearClon(NaveTransporte unidadAClonar) throws ExcepcionUnidadNoClonable{
    	throw new ExcepcionUnidadNoClonable();
    }
    
    public void lanzarTormentaPsionica(Parcela target) throws ExcepcionEnergiaInsuficiente{
    	this.gastarEnergia(COSTO_ENERGIA_TORMENTA);
    	(this.propietario).agregarAtaque(new AtaqueTormentaPsionica(target));
    }
}
