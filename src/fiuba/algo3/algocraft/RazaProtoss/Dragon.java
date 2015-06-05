package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.UnidadTerrestre;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;

public class Dragon extends UnidadTerrestre{
	private int escudo;

    public Dragon(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 100;
        this.escudo = 80;
        /*this.danyo = new Danyo(20,20);
        this.costo = new Costo();*/
        this.vision = 8;
        this.cupoDeTransporte = 4;
        this.rangoAtaque = new RangoAtaque(4, 4);
        this.tiempoDeConstruccion = 9;
    }
}
