package fiuba.algo3.algocraft;

public abstract class Unidad extends Interactuable {
    protected Jugador propietario;
    protected int vida; //Va a ser vida
    protected int vision;
    protected int tiempoDeConstruccion;
    protected RangoAtaque rangoAtaque;
    protected int cupoDeTransporte;
    protected Coordenada posicion;

    /*protected Danyo danyo; //INTERFAZ ATACANTE
    protected Costo costo; //Interfaz ObjetoCostoso ? -> se encargaria de restar plata de todos lados
    */
}