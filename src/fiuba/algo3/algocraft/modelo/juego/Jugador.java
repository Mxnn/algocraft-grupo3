package fiuba.algo3.algocraft.modelo.juego;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.razas.Raza;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.TipoDeConstruccion;
import fiuba.algo3.algocraft.modelo.utilidades.construcciones.AdicionalSuministros;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Ataque;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class Jugador {
    public int LONGITUD_MINIMA_PARA_EL_NOMBRE = 4;
    public static final int GAS_VESPENO_INICIAL = 0;
    public static final int MINERAL_INICIAL = 200;
    public static final int CAPACIDAD_DE_POBLACION_MAXIMA = 200;
    public static final int CAPACIDAD_DE_POBLACION_INICIAL = 0;
    public static final int POBLACION_INICIAL = 0;

    private String nombre;
    private Color color;
    private Raza raza;
    private ArrayList<Construccion> construcciones = new ArrayList<Construccion>();
    private ArrayList<Unidad> unidades = new ArrayList<Unidad>();
    private ArrayList<Ataque> ataques = new ArrayList<Ataque>();
    private int gasVespeno;
    private int mineral;
    
    public Jugador(String nombre, Color color, Raza raza) throws ExcepcionNombreCorto {
        if (nombre.length() < this.LONGITUD_MINIMA_PARA_EL_NOMBRE)
            throw new ExcepcionNombreCorto();

        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
        this.gasVespeno = GAS_VESPENO_INICIAL;
        this.mineral = MINERAL_INICIAL;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Color getColor() {
        return this.color;
    }

	public Interactuable crearExtractorGas(Mapa mapa, Coordenada coordenada) throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        ExtractorGas unExtractorGas = raza.crearExtractorGas(this);

        mapa.ubicarElementoEnParcela(coordenada, unExtractorGas);
        this.deducirCostos(unExtractorGas.getCosto());
		construcciones.add(unExtractorGas);

        return unExtractorGas;
	}

	public Interactuable crearExtractorMineral(Mapa mapa, Coordenada coordenada) throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
		ExtractorMineral unExtractorMineral = raza.crearExtractorMineral(this);

        mapa.ubicarElementoEnParcela(coordenada, unExtractorMineral);
        this.deducirCostos(unExtractorMineral.getCosto());
		construcciones.add(unExtractorMineral);

        return unExtractorMineral;
	}

    public Interactuable crearAdicionalDeSuministro(Mapa mapa, Coordenada coordenada) throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela {
        AdicionalSuministros adicionalSuministros = raza.crearAdicionalDeSuministros(this);

        mapa.ubicarElementoEnParcela(coordenada, adicionalSuministros);
        this.deducirCostos(adicionalSuministros.getCosto());
        construcciones.add(adicionalSuministros);

        return adicionalSuministros;
    }

    public Interactuable crearCreadorDeUnidadesBasicas(Mapa mapa, Coordenada coordenada) throws ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Construccion creadorDeUnidadesBasicas = raza.crearCreadorDeUnidadesBasicas(this);

        mapa.ubicarElementoEnParcela(coordenada, creadorDeUnidadesBasicas);
        this.deducirCostos(creadorDeUnidadesBasicas.getCosto());
        construcciones.add(creadorDeUnidadesBasicas);

        return creadorDeUnidadesBasicas;
    }

    public Interactuable crearCreadorDeUnidadesAvanzadas(Mapa mapa, Coordenada coordenada) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Construccion creadorDeUnidadesTerrestres = raza.crearCreadorDeUnidadesAvanzadas(this);

        mapa.ubicarElementoEnParcela(coordenada, creadorDeUnidadesTerrestres);
        this.deducirCostos(creadorDeUnidadesTerrestres.getCosto());
        construcciones.add(creadorDeUnidadesTerrestres);

        return creadorDeUnidadesTerrestres;
    }

    public Interactuable crearCreadorDeUnidadesMagicas(Mapa mapa, Coordenada coordenada) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Construccion creadorDeUnidadesAereas = raza.crearCreadorDeUnidadesMagicas(this);

        mapa.ubicarElementoEnParcela(coordenada, creadorDeUnidadesAereas);
        this.deducirCostos(creadorDeUnidadesAereas.getCosto());
        construcciones.add(creadorDeUnidadesAereas);

        return creadorDeUnidadesAereas;
    }
	
	public int cantidadDeConstrucciones() {
        return construcciones.size();
	}

    public void sumarGasVespeno(int cantidad) {
        this.gasVespeno = this.gasVespeno + cantidad;
    }

    public int getGasVespeno() {
        return this.gasVespeno;
    }

    public void sumarMinerales(int cantidad) {
        this.mineral = this.mineral+ cantidad;
    }

    public int getMinerales() {
        return this.mineral;
    }

    public int getCapacidadDePoblacion() {
        int cantidad = 0;
        for (Construccion c: this.construcciones) {
        	if ( (c.getTipoDeConstruccion() == TipoDeConstruccion.ADICIONAL_SUMINISTROS) && c.estaCreado()){
        		if (c.getTipoDeConstruccion() == TipoDeConstruccion.ADICIONAL_SUMINISTROS)
        			cantidad += ( (AdicionalSuministros) c).getCantidadDeSuministrosAdicionales();
        	}
        }

        if (cantidad < CAPACIDAD_DE_POBLACION_INICIAL)
            return CAPACIDAD_DE_POBLACION_INICIAL;
        else if (cantidad > CAPACIDAD_DE_POBLACION_MAXIMA)
            return CAPACIDAD_DE_POBLACION_MAXIMA;
        else
            return cantidad;
    }

    public boolean tieneConstruccionDeTipo(TipoDeConstruccion tipo) {
        for (Construccion c : construcciones) {
            if (c.getTipoDeConstruccion() == tipo && c.estaCreado())
                return true;
        }

        return false;
    }

    public int getPoblacion() {
        int cantidad = 0;
        for (Unidad u: this.unidades) {
            cantidad += u.getSuministro();
        }

        return cantidad;
    }

    public void agregarUnidad(Unidad unidad) throws ExcepcionNoHaySuministrosDisponibles {
        int total = this.getPoblacion() + unidad.getSuministro();
        if (total > this.getCapacidadDePoblacion())
            throw new ExcepcionNoHaySuministrosDisponibles();
        else
            this.unidades.add(unidad);
    }
    
    public void agregarAtaque(Ataque ataque){
    	this.ataques.add(ataque);
    }

    public int getCantidadDeUnidades() {
        return this.unidades.size();
    }

    public void eliminarUnidad(Unidad unidad) {
        (this.unidades).remove(unidad);
    }

    public void eliminarConstruccion(Construccion construccion) {
        (this.construcciones).remove(construccion);
    }

    public Collection<Construccion> getConstrucciones() {
        return this.construcciones;
    }

    public Collection<Unidad> getUnidades() {
        return this.unidades;
    }

    public Collection<Ataque> getAtaques() {
        return this.ataques;
    }

    public void terminarTurno(Juego juego) throws ExcepcionNoEsElTurnoDelJugador, ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance, ExcepcionCoordenadaFueraDelMapa {
    	juego.pasarTurno(this);
    }
    
    public boolean esPerdedor(){
    	//boolean tieneGas = this.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_GAS);
    	boolean tieneMineral = this.tieneConstruccionDeTipo(TipoDeConstruccion.EXTRACTOR_MINERAL);

    	return(this.mineral<100 && !tieneMineral);
    }

    public void deducirCostos(Costo costo) {
        this.mineral -= costo.getCostoMineral();
        this.gasVespeno -= costo.getCostoGas();
    }
}
