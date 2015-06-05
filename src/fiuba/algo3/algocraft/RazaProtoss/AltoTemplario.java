package fiuba.algo3.algocraft.RazaProtoss;

import fiuba.algo3.algocraft.UnidadTerrestre;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;

public class AltoTemplario extends UnidadTerrestre{
	private int escudo;

    public AltoTemplario(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 40;
        this.escudo = 40;
        this.suministro = 2;
        /*this.danyo = new Danyo();
        this.costo = new Costo();*/
        this.vision = 7;
        this.cupoDeTransporte = 2;
        this.rangoAtaque = new RangoAtaque(0,0);
        this.tiempoDeConstruccion = 7;
    }
}
