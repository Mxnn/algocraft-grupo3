package fiuba.algo3.algocraft;

public abstract class AdicionalSuministros extends Construccion {
    protected int suministrosAdicionales;

    public AdicionalSuministros(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int suministrosAdicionales) {
        super(propietario, vitalidad, tiempoDeConstruccion);
        this.suministrosAdicionales = suministrosAdicionales;
    }


    public int getCantidadDeSuministrosAdicionales() {
        return this.suministrosAdicionales;
    }
}
