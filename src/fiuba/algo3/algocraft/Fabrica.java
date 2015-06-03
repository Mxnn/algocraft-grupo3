package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.RazaTerran.Golliat;

public class Fabrica extends CreadorDeUnidadesTerrestres {
    public Fabrica(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        this.propietario = propietario;
        this.vida = 1250;
        this.tiempoDeConstruccion = 12;
        //Costo = 200M/100G
    }

    public Golliat crearGolliat() {
        return new Golliat(this.propietario);
    }
}
