package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.UnidadTerrestre;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;

public class AltoTemplario extends UnidadTerrestre{
	//private int escudo;
    public static int COSTO_MINERAL= 50;
    public static int COSTO_GAZ = 150;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    

    public AltoTemplario(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 40;
        //this.escudo = 40;
        /*this.danyo = new Danyo();*/
        this.vision = 7;
        this.cupoDeTransporte = 2;
        this.rangoAtaque = new RangoAtaque(0,0);
        this.tiempoDeConstruccion = 7;
    }
}
