package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaAcciones;
import fiuba.algo3.algocraft.vista.VistaBarraLateral;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminarTurnoListener implements ActionListener {
    private Juego modelo;
    private JPanel frame;
    private VistaBarraLateral vistaBarraLateral;

    public TerminarTurnoListener(Juego modelo, JPanel frame, VistaBarraLateral vistaBarraLateral) {
        this.modelo = modelo;
        this.frame = frame;
        this.vistaBarraLateral = vistaBarraLateral;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.modelo.getJugadorQueJuega().terminarTurno(this.modelo);
            this.vistaBarraLateral.refrescar(this.modelo);
            this.vistaBarraLateral.setPanelAcciones(this.frame);//prueba
            this.vistaBarraLateral.setSelectedIndex(0);
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
