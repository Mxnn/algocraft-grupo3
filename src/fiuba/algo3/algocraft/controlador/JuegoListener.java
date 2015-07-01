package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.observadores.juego.VistaJuego;

import java.awt.event.ActionListener;

public abstract class JuegoListener implements ActionListener {
    protected Juego modelo;

    public JuegoListener(Juego modelo) {
        this.modelo = modelo;
    }

    public void mostrarError(String msg) {
        VistaJuego.getInstance().displayError(msg);
    }
}
