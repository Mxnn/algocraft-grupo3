package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionElementoNoAdmitidoEnParcela;

public class Fabrica extends Construccion {
    public Fabrica(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 1250;
        this.tiempoDeConstruccion = 12;
        //Costo = 200M/100G
        //Crea a Golliat
    }

    public void guardarEnParcela(Parcela parcela) throws ExcepcionElementoNoAdmitidoEnParcela {
        parcela.guardarElemento(this);
    }
}
