package fiuba.algo3.algocraft.RazaTerran;

import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadVoladora;

public class NaveTransporte extends UnidadVoladora {
    /*private int capacidad;
    private int plazasOcupadas;*/

    public NaveTransporte(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 150;
        this.suministro = 2;
        /*this.danyo = new Danyo(0,0);
        this.costo = new Costo(100, 100);*/
        this.vision = 8;
        this.cupoDeTransporte = 0;
        this.rangoAtaque = new RangoAtaque(0, 0);
        this.tiempoDeConstruccion = 7;

        /*this.capacidad = 8;
        this.plazasOcupadas = 0;*/
    }
}
