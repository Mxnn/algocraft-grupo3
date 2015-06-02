package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadVoladora;

public class NaveCiencia extends UnidadVoladora {
    public NaveCiencia() {
        this.vida = 200;
        this.suministro = 2;
        /*this.danyo = new Danyo(0,0);
        this.costo = new Costo(100, 225);*/
        this.vision = 10;
        this.cupoDeTransporte = 0;
        this.rangoAtaque = new RangoAtaque(0, 0);
        this.tiempoDeConstruccion = 10;
    }
}
