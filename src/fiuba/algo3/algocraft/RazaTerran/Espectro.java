package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadVoladora;

public class Espectro extends UnidadVoladora {
    public Espectro(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 120;
        this.suministro = 2;
        /*this.danyo = new Danyo(20, 8);
        this.costo = new Costo(150, 100);*/
        this.vision = 7;
        this.cupoDeTransporte = 0;
        this.rangoAtaque = new RangoAtaque(5, 0);
        this.tiempoDeConstruccion = 8;
    }
}
