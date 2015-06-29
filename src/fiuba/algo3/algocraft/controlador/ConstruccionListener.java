package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;

public abstract class ConstruccionListener extends JuegoListener {
    protected Coordenada ubicacion;
    protected final String msjParcelaOcupada = "La parcela esta ocupada";
    protected final String msjElementoNoAdmitido = "Elemento no admitido en parcela";
    protected final String msjRecursosInsuficientes = "Recursos insuficientes";
    protected final String msjCoordenadaFueraDelMapa = "Coordenada fuera del mapa";

    public ConstruccionListener(Juego modelo, Coordenada ubicacion) {
        super(modelo);
        this.ubicacion = ubicacion;
    }
}
