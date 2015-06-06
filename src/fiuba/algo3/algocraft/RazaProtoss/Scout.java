package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadVoladora;

public class Scout extends UnidadVoladora {
	//private int escudo;
	
    public Scout(Jugador propietario) {
        this.propietario = propietario;
        //this.escudo = 100;
        this.vida = 150;
        /*this.danyo = new Danyo();
        this.costo = new Costo();*/
        this.vision = 7;
        this.cupoDeTransporte = 0;
        this.rangoAtaque = new RangoAtaque(4, 4);
        this.tiempoDeConstruccion = 9;
    }
}
