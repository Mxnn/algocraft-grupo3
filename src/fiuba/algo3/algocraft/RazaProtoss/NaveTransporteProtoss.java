package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadVoladora;

public class NaveTransporteProtoss extends UnidadVoladora {
    /*private int capacidad;
    private int plazasOcupadas;*/
	//private int escudo;
	
    public NaveTransporteProtoss(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 80;
        //this.escudo = 60;
        /*this.danyo = new Danyo(0,0);
        this.costo = new Costo(100, 100);*/
        this.vision = 8;
        this.cupoDeTransporte = 0;
        this.rangoAtaque = new RangoAtaque(0, 0);
        this.tiempoDeConstruccion = 8;

        /*this.capacidad = 8;
        this.plazasOcupadas = 0;*/
    }
}
