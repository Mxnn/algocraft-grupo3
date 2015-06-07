package fiuba.algo3.algocraft;

public class DepositoSuministro extends AdicionalSuministros {

    public static int COSTO_MINERAL= 100;
    public static int COSTO_GAZ = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    public DepositoSuministro(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 500;
        this.tiempoDeConstruccion = 6;
        this.cantidadDeSuministrosAdicionales = 5;
        propietario.incrementarCapacidadDePoblacion(this.cantidadDeSuministrosAdicionales);

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}
