package fiuba.algo3.algocraft.RazaProtoss;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.RangoAtaque;
import fiuba.algo3.algocraft.UnidadTerrestre;

public class Zealot extends UnidadTerrestre {
		//private int escudo;

	    public Zealot(Jugador propietario) {
	        this.propietario = propietario;
	        this.vida = 100;
	        //this.escudo = 60;
	        /*this.danyo = new Danyo();
	        this.costo = new Costo();*/
	        this.vision = 7;
	        this.cupoDeTransporte = 2;
	        this.rangoAtaque = new RangoAtaque(0, 8);
	        this.tiempoDeConstruccion = 4;
	    }
	}


