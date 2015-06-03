package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadTerrestre;

public class Golliat extends UnidadTerrestre {
    public Golliat(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 125;
        this.suministro = 2;
        /*this.danyo = new Danyo(10, 12);
        this.costo = new Costo(100, 50);*/
        this.vision = 8;
        this.cupoDeTransporte = 2;
        this.rangoAtaque = new RangoAtaque(5, 6);
        this.tiempoDeConstruccion = 6;
    }
}
