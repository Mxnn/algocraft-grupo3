package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public class DepositoSuministro extends Construccion {

    public DepositoSuministro(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 500;
        this.tiempoDeConstruccion = 6;
        //Costo = 100M
        //DA +5 POBLACION
    }

    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
        parcela.guardarElemento(this);
    }
}
