package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;

public class Fabrica extends ConstruccionParaUnidades {
    public Fabrica(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        this.propietario = propietario;
        this.vida = 1250;
        this.tiempoDeConstruccion = 12;
        //Costo = 200M/100G
        //Crea a Golliat
    }
}
