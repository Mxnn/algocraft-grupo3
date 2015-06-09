package fiuba.algo3.algocraft;

public class DepositoSuministro extends AdicionalSuministros {

    public static final int VIDA_INICIAL = 500;
    public static int COSTO_MINERAL = 100;
    public static int COSTO_GAS = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL, COSTO_GAS);
    
    public DepositoSuministro(Jugador propietario, Parcela parcela) {
        this.propietario = propietario;
        this.parcela = parcela;
        this.estado = new Estado(VIDA_INICIAL);
        this.tiempoDeConstruccion = 6;
        this.CANTIDAD_DE_SUMINISTROS_ADICIONALES = 5;
        propietario.incrementarCapacidadDePoblacion(this.CANTIDAD_DE_SUMINISTROS_ADICIONALES);
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}
