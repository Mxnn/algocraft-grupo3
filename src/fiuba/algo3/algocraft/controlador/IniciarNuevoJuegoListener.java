package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.NuevoJugadorVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarNuevoJuegoListener implements ActionListener {
    Juego modelo;

    public IniciarNuevoJuegoListener(Juego modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Abrir pantalla previa al mapa
        new NuevoJugadorVista(this.modelo, "Agregando jugador 2");
        new NuevoJugadorVista(this.modelo, "Agregando jugador 1");
    }
}
