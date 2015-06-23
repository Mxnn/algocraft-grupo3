package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.juego.Juego;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminarTurnoListener implements ActionListener {
    private Juego modelo;
    private JPanel frame;

    public TerminarTurnoListener(Juego modelo, JPanel frame) {
        this.modelo = modelo;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.modelo.getJugadorQueJuega().terminarTurno(this.modelo);
        } catch (ExcepcionNoEsElTurnoDelJugador excepcionNoEsElTurnoDelJugador) {
            JOptionPane.showMessageDialog(this.frame, "No se puede pasar turno en tu turno");
        } catch (ExcepcionEstadoMuerto excepcionEstadoMuerto) {
            JOptionPane.showMessageDialog(this.frame, "...");
        } catch (ExcepcionEnemigoFueraDeAlcance excepcionEnemigoFueraDeAlcance) {
            JOptionPane.showMessageDialog(this.frame, "...");
        } catch (ExcepcionCoordenadaFueraDelMapa excepcionCoordenadaFueraDelMapa) {
            JOptionPane.showMessageDialog(this.frame, "...");
        }
    }
}
