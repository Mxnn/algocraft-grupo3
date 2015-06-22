package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.juego.Color;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.razas.Raza;
import fiuba.algo3.algocraft.modelo.razas.protoss.Protoss;
import fiuba.algo3.algocraft.modelo.razas.terran.Terran;
import fiuba.algo3.algocraft.vista.NuevoJugadorVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevoJugadorControlador implements ActionListener {
    private NuevoJugadorVista frame;
    Juego modelo;

    public NuevoJugadorControlador(Juego modelo, NuevoJugadorVista frame) {
        this.modelo = modelo;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            modelo.crearJugador((this.frame).getNombreElegido(), this.devolverColor((this.frame).getNumeroDeColorElegido()), this.devolverRaza((this.frame).getNumeroDeRazaElegida()));
            this.frame.dispose();
        } catch (ExcepcionNombreEnUso excepcionNombreEnUso) {
            JOptionPane.showMessageDialog(this.frame, "El nombre esta en uso. Por favor, elija otro");
        } catch (ExcepcionAlcanzadoElMaximoCupoDeJugadores excepcionAlcanzadoElMaximoCupoDeJugadores) {
            JOptionPane.showMessageDialog(this.frame, "Se permiten hasta " + Juego.MAXIMO_NUMERO_DE_JUGADORES + " jugadores");
        } catch (ExcepcionNombreCorto excepcionNombreCorto) {
            JOptionPane.showMessageDialog(this.frame, "El nombre debe superar los " + (Jugador.LONGITUD_MINIMA_PARA_EL_NOMBRE - 1) + " caracteres");
        } catch (ExcepcionColorEnUso excepcionColorEnUso) {
            JOptionPane.showMessageDialog(this.frame, "El color esta en uso. Por favor, elija otro");
        }
    }

    private Color devolverColor(int numeroDeColor) {
        switch (numeroDeColor) {
            case 0: return Color.ROJO;
            case 1: return Color.AZUL;
            case 2: return Color.VERDE;
            case 3: return Color.AMARILLO;
            case 5: return Color.VIOLETA;
            case 6: return Color.NARANJA;
            case 7: return Color.BLANCO;
        }
        return Color.CELESTE;
    }

    private Raza devolverRaza(int numeroDeRaza) {
        if (numeroDeRaza == 0)
            return Terran.getInstance();

        return Protoss.getInstance();
    }
}
