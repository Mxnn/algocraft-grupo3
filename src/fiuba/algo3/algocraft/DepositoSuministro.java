package fiuba.algo3.algocraft;

public class DepositoSuministro extends AdicionalSuministros {

    public DepositoSuministro(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 500;
        this.tiempoDeConstruccion = 6;
        this.cantidadDeSuministrosAdicionales = 5;
        propietario.incrementarCapacidadDePoblacion(this.cantidadDeSuministrosAdicionales);
        //Costo = 100M
    }

    public TipoDeConstruccion obtenerTipoDeConstruccion() {
        return TipoDeConstruccion.ADICIONAL_SUMINISTROS;
    }
}
