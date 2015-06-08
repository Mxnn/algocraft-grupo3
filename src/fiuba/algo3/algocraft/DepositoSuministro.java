package fiuba.algo3.algocraft;

public class DepositoSuministro extends AdicionalSuministros {

    private static final int VIDA_INICIAL = 500;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public DepositoSuministro(Jugador propietario) {
        this.propietario = propietario;
        this.estado = new Estado(VIDA_INICIAL);
        this.tiempoDeConstruccion = 6;
        this.cantidadDeSuministrosAdicionales = 5;
        propietario.incrementarCapacidadDePoblacion(this.cantidadDeSuministrosAdicionales);

    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}
