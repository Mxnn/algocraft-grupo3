package fiuba.algo3.algocraft;

import java.util.ArrayList;

public class Jugador {
    static final int GAS_VESPENO_INICIAL = 0;
    static final int MINERAL_INICIAL = 200;

    private String nombre;
    private Color color;
    private Raza raza;
    private ArrayList<Construccion> construcciones = new ArrayList<Construccion>();
    private int gasVespeno;
    private int mineral;
    
    
    public Jugador(String nombre, Color color, Raza raza) {
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
        this.gasVespeno = GAS_VESPENO_INICIAL;
        this.mineral = MINERAL_INICIAL;
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
}
