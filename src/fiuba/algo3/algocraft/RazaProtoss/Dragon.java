package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.UnidadTerrestre;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;

public class Dragon extends UnidadTerrestre{
	//private int escudo;
	
    public static int COSTO_MINERAL= 125;
    public static int COSTO_GAZ = 50;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    

    public Dragon(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 100;
        //this.escudo = 80;
        /*this.danyo = new Danyo(20,20);*/
        this.vision = 8;
        this.cupoDeTransporte = 4;
        this.rangoAtaque = new RangoAtaque(4, 4);
        this.tiempoDeConstruccion = 9;
    }
}
