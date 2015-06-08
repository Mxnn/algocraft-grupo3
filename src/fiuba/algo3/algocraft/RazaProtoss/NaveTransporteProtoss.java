package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.Costo;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadVoladora;

public class NaveTransporteProtoss extends UnidadVoladora {
    /*private int capacidad;
    private int plazasOcupadas;*/
	//private int escudo;
	
    public static int COSTO_MINERAL= 200;
    public static int COSTO_GAZ = 0;
    public static Costo COSTO = new Costo(COSTO_MINERAL,COSTO_GAZ);
    
    
    public NaveTransporteProtoss(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 80;
        //this.escudo = 60;
        /*this.danyo = new Danyo(0,0);*/
        this.vision = 8;
        this.cupoDeTransporte = 0;
        this.rangoAtaque = new RangoAtaque(0, 0);
        this.tiempoDeConstruccion = 8;

        /*this.capacidad = 8;
        this.plazasOcupadas = 0;*/
    }
}
