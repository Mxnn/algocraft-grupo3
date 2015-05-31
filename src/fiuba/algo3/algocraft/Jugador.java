package fiuba.algo3.algocraft;

public class Jugador {
    private String nombre;
    private Color color;
    private Raza raza;

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
}
