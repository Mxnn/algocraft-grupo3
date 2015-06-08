package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadVoladora;

public class Scout extends UnidadVoladora {
	//private int escudo;
    public static int COSTO_MINERAL= 300;
    public static int COSTO_GAZ = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    
    public Scout(Jugador propietario) {
        this.propietario = propietario;
        //this.escudo = 100;
        this.vida = 150;
        /*this.danyo = new Danyo();*/
        this.vision = 7;
        this.cupoDeTransporte = 0;
        this.rangoAtaque = new RangoAtaque(4, 4);
        this.tiempoDeConstruccion = 9;
    }
}
