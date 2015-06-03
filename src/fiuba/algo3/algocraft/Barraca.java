package fiuba.algo3.algocraft;

public class Barraca extends ConstruccionParaUnidades {
	public Barraca(Jugador propietario){
        this.propietario = propietario;
        this.vida = 1000;
        this.tiempoDeConstruccion = 12;
        //Costo = 12M
        //Crea a Marine
    }
}
