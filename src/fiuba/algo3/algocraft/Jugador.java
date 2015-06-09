package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;

import java.util.ArrayList;

public class Jugador {
    static final int GAS_VESPENO_INICIAL = 0;
    static final int MINERAL_INICIAL = 200;
    static final int CAPACIDAD_DE_POBLACION_MAXIMA = 200;
    static final int CAPACIDAD_DE_POBLACION_INICIAL = 0;
    static final int POBLACION_INICIAL = 0;

    private String nombre;
    private Color color;
    private Raza raza;
    private ArrayList<Construccion> construcciones = new ArrayList<Construccion>();
    private ArrayList<Unidad> unidades = new ArrayList<Unidad>();
    private int gasVespeno;
    private int mineral;
    private int capacidadDePoblacion;
    private int poblacion;
    
    
    public Jugador(String nombre, Color color, Raza raza) {
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
        this.gasVespeno = GAS_VESPENO_INICIAL;
        this.mineral = MINERAL_INICIAL;
        this.capacidadDePoblacion = CAPACIDAD_DE_POBLACION_INICIAL;
        this.poblacion = POBLACION_INICIAL;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public Color obtenerColor() {
        return this.color;
    }

	public Interactuable crearExtractorGas(Mapa mapa, Coordenada coordenada) throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        ExtractorGas unExtractorGas = raza.crearExtractorGas(this);

        mapa.ubicarElementoEnParcela(coordenada, unExtractorGas);
		construcciones.add(unExtractorGas);

        return unExtractorGas;
	}

	public Interactuable crearExtractorMineral(Mapa mapa, Coordenada coordenada) throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
		ExtractorMineral unExtractorMineral = raza.crearExtractorMineral(this);

        mapa.ubicarElementoEnParcela(coordenada, unExtractorMineral);
		construcciones.add(unExtractorMineral);

        return unExtractorMineral;
	}

    public Interactuable crearAdicionalDeSuministro(Mapa mapa, Coordenada coordenada) throws ExcepcionRecursosInsuficientes, ExcepcionCoordenadaFueraDelMapa, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela {
        AdicionalSuministros adicionalSuministros = raza.crearAdicionalDeSuministros(this);

        mapa.ubicarElementoEnParcela(coordenada, adicionalSuministros);
        construcciones.add(adicionalSuministros);

        return adicionalSuministros;
    }

    public Interactuable crearCreadorDeSoldados(Mapa mapa, Coordenada coordenada) throws ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        CreadorDeSoldados creadorDeSoldados = raza.crearCreadorDeSoldados(this);

        mapa.ubicarElementoEnParcela(coordenada, creadorDeSoldados);
        construcciones.add(creadorDeSoldados);

        return creadorDeSoldados;
    }

    public Interactuable crearCreadorDeUnidadesTerrestres(Mapa mapa, Coordenada coordenada) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        CreadorDeUnidadesTerrestres creadorDeUnidadesTerrestres = raza.crearCreadorDeUnidadesTerrestres(this);

        mapa.ubicarElementoEnParcela(coordenada, creadorDeUnidadesTerrestres);
        construcciones.add(creadorDeUnidadesTerrestres);

        return creadorDeUnidadesTerrestres;
    }

    public Interactuable crearCreadorDeUnidadesAereas(Mapa mapa, Coordenada coordenada) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        CreadorDeUnidadesAereas creadorDeUnidadesAereas = raza.crearCreadorDeUnidadesAereas(this);

        mapa.ubicarElementoEnParcela(coordenada, creadorDeUnidadesAereas);
        construcciones.add(creadorDeUnidadesAereas);

        return creadorDeUnidadesAereas;
    }
	
	public int cantidadDeConstrucciones() {
        return construcciones.size();
	}

    public void sumarGasVespeno(int cantidad) {
        this.gasVespeno = this.gasVespeno +  cantidad;
    }

    public int obtenerGasVespeno() {
        return this.gasVespeno;
    }

    public void sumarMinerales(int cantidad) {
        this.mineral = this.mineral+ cantidad;
    }

    public int obtenerMineral() {
        return this.mineral;
    }

    public void incrementarCapacidadDePoblacion(int cantidad) {
        if ( (this.capacidadDePoblacion + cantidad) > CAPACIDAD_DE_POBLACION_MAXIMA)
            this.capacidadDePoblacion = CAPACIDAD_DE_POBLACION_MAXIMA;
        else
            this.capacidadDePoblacion += cantidad;
    }

    public int capacidadDePoblacion() {
        return this.capacidadDePoblacion;
    }

    public boolean tieneConstruccionDeTipo(TipoDeConstruccion tipo) {
        for (Construccion c : construcciones) {
            if (c.obtenerTipoDeConstruccion() == tipo)
                return true;
        }

        return false;
    }

    public int obtenerPoblacion() {
        return this.poblacion;
    }

    public void agregarUnidad(Unidad unidad) throws ExcepcionNoHaySuministrosDisponibles {
        int total = this.poblacion += unidad.SUMINISTRO;
        if (total > this.capacidadDePoblacion)
            throw new ExcepcionNoHaySuministrosDisponibles();
        else if (this.unidades.add(unidad))
                this.poblacion = total;
    }

    public int cantidadDeUnidades() {
        return this.unidades.size();
    }

    public void eliminarUnidad(Unidad unidad) {
        if ((this.unidades).remove(unidad))
            this.poblacion -= unidad.SUMINISTRO;
    }

    public void eliminarConstruccion(Construccion construccion) {
        (this.construcciones).remove(construccion);
    }

    public void decrementarPoblacion(int cantidad) {
        this.capacidadDePoblacion -= cantidad;
    }
}
