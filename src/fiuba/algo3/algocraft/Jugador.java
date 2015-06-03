package fiuba.algo3.algocraft;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Color color;
    private Raza raza;
    private ArrayList<Construccion> construcciones = new ArrayList<Construccion>();
    
    
    public Jugador(String nombre, Color color, Raza raza) {
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public Color obtenerColor() {
        return this.color;
    }

	public void crearExtractorGas(Jugador propietario) {
		ExtractorGas unExtractorGas = raza.crearExtractorGas(propietario);
		unExtractorGas.setProprietario(this);
		construcciones.add(unExtractorGas);
	}

	public int cantidadDeConstrucciones() {
        return construcciones.size();
	}
}
