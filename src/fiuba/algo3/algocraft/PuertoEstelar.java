package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.RazaTerran.Espectro;
import fiuba.algo3.algocraft.RazaTerran.NaveCiencia;
import fiuba.algo3.algocraft.RazaTerran.NaveTransporte;

public class PuertoEstelar extends CreadorDeUnidadesAereas {
    public PuertoEstelar(Jugador propietario) {
        this.propietario = propietario;
        this.vida = 1300;
        this.tiempoDeConstruccion = 10;
        //Costo = 150M/100G
    }

    public Espectro crearEspectro() {
        return new Espectro(this.propietario);
    }

    public NaveTransporte crearNaveTransporte() {
        return new NaveTransporte(this.propietario);
    }

    public NaveCiencia crearNaveCiencia() {
        return new NaveCiencia(this.propietario);
    }
}
