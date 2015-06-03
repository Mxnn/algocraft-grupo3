package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;

import java.util.ArrayList;

public class Jugador {
    static final int GAS_VESPENO_INICIAL = 0;
    static final int MINERAL_INICIAL = 200;
    static final int CAPACIDAD_DE_POBLACION_MAXIMA = 200;

    private String nombre;
    private Color color;
    private Raza raza;
    private ArrayList<Construccion> construcciones = new ArrayList<Construccion>();
    private int gasVespeno;
    private int mineral;
    private int capacidadDePoblacion;
    //private int poblacion;
    
    
    public Jugador(String nombre, Color color, Raza raza) {
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
        this.gasVespeno = GAS_VESPENO_INICIAL;
        this.mineral = MINERAL_INICIAL;
        this.capacidadDePoblacion = 0;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public Color obtenerColor() {
        return this.color;
    }

    //Deberia crear la construccion en un lugar del mapa (coordenadas) y el jugador tiene que tener acceso al mapa (lo usa)
	public Interactuable crearExtractorGas() {
		ExtractorGas unExtractorGas = raza.crearExtractorGas(this);
		construcciones.add(unExtractorGas);

        return unExtractorGas;
	}

	public Interactuable crearExtractorMineral() {
		ExtractorMineral unExtractorMineral = raza.crearExtractorMineral(this);
		construcciones.add(unExtractorMineral);

        return unExtractorMineral;
	}

    public Interactuable crearAdicionalDeSuministro() {
        AdicionalSuministros adicionalSuministros = raza.crearAdicionalDeSuministros(this);
        construcciones.add(adicionalSuministros);

        return adicionalSuministros;
    }

    public Interactuable crearCreadorDeSoldados() {
        CreadorDeSoldados creadorDeSoldados = raza.crearCreadorDeSoldados(this);
        construcciones.add(creadorDeSoldados);

        return creadorDeSoldados;
    }

    public Interactuable crearCreadorDeUnidadesTerrestres() throws ExcepcionConstruccionesRequeridasNoCreadas {
        CreadorDeUnidadesTerrestres creadorDeUnidadesTerrestres = raza.crearCreadorDeUnidadesTerrestres(this);
        construcciones.add(creadorDeUnidadesTerrestres);

        return creadorDeUnidadesTerrestres;
    }

    public Interactuable crearCreadorDeUnidadesAereas() throws ExcepcionConstruccionesRequeridasNoCreadas {
        CreadorDeUnidadesAereas creadorDeUnidadesAereas = raza.crearCreadorDeUnidadesAereas(this);
        construcciones.add(creadorDeUnidadesAereas);

        return creadorDeUnidadesAereas;
    }
	
	public int cantidadDeConstrucciones() {
        return construcciones.size();
	}

    public void sumarGasVespeno(int cantidad) {
        this.gasVespeno =+ cantidad;
    }

    public int obtenerGasVespeno() {
        return this.gasVespeno;
    }

    public void sumarMinerales(int cantidad) {
        this.mineral += cantidad;
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
}
