package fiuba.algo3.algocraft.modelo.excepciones;

public class ExcepcionNoEsUnidadTerrestre extends Exception {
    public ExcepcionNoEsUnidadTerrestre() {
        super("Solo se pueden transportar unidades terrestres");
    }
}
