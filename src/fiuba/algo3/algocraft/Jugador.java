package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.mapa.Coordenada;
import fiuba.algo3.algocraft.mapa.Mapa;

import java.util.ArrayList;

public class Jugador {
    private final int LONGITUD_MINIMA_PARA_EL_NOMBRE = 4;
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

    public Interactuable crearCreadorDeUnidadesBasicas(Mapa mapa, Coordenada coordenada) throws ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Construccion creadorDeSoldados = raza.crearCreadorDeSoldados(this);

        mapa.ubicarElementoEnParcela(coordenada, creadorDeSoldados);
        construcciones.add(creadorDeSoldados);

        return creadorDeSoldados;
    }

    public Interactuable crearCreadorDeUnidadesAvanzadas(Mapa mapa, Coordenada coordenada) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Construccion creadorDeUnidadesTerrestres = raza.crearCreadorDeUnidadesTerrestres(this);

        mapa.ubicarElementoEnParcela(coordenada, creadorDeUnidadesTerrestres);
        construcciones.add(creadorDeUnidadesTerrestres);

        return creadorDeUnidadesTerrestres;
    }

    public Interactuable crearCreadorDeUnidadesMagicas(Mapa mapa, Coordenada coordenada) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes, ExcepcionParcelaOcupada, ExcepcionElementoNoAdmitidoEnParcela, ExcepcionCoordenadaFueraDelMapa {
        Construccion creadorDeUnidadesAereas = raza.crearCreadorDeUnidadesAereas(this);

        mapa.ubicarElementoEnParcela(coordenada, creadorDeUnidadesAereas);
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
            if (c.getTipoDeConstruccion() == TipoDeConstruccion.ADICIONAL_SUMINISTROS)
                cantidad += ( (AdicionalSuministros) c).getCantidadDeSuministrosAdicionales();
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
            if (c.getTipoDeConstruccion() == tipo)
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

    public int getCantidadDeUnidades() {
        return this.unidades.size();
    }

    public void eliminarUnidad(Unidad unidad) {
        (this.unidades).remove(unidad);
    }

    public void eliminarConstruccion(Construccion construccion) {
        (this.construcciones).remove(construccion);
    }

	public void tareaDelTurnoGenerarRecursos() {
        for (Construccion c: this.construcciones)
            c.collectarRecursos();
		
	}

    /*public ArrayList<Construccion> getConstrucciones() {
        return this.construcciones;
    }

    public ArrayList<Unidad> getUnidades() {
        return this.unidades;
    }*/
}
