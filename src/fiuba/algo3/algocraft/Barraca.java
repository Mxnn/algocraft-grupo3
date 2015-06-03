package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.RazaTerran.Marine;

public class Barraca extends CreadorDeSoldados {
	public Barraca(Jugador propietario){
        this.propietario = propietario;
        this.vida = 1000;
        this.tiempoDeConstruccion = 12;
        //Costo = 12M
        //Crea a Marine
    }

    public Marine crearMarine() {
        return new Marine(this.propietario);
    }
}
