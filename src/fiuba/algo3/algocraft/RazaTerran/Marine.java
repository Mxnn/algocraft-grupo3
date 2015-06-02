package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadTerrestre;

public class Marine extends UnidadTerrestre {
    public Marine() {
        this.vida = 40;
        this.suministro = 1;
        /*this.danyo = new Danyo(6, 6);
        this.costo = new Costo(50, 0);*/
        this.vision = 7;
        this.cupoDeTransporte = 1;
        this.rangoAtaque = new RangoAtaque(4, 0);
        this.tiempoDeConstruccion = 3;
    }
}
