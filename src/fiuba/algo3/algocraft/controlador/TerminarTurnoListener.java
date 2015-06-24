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
    private Controlador controlador;
    public TerminarTurnoListener(Juego modelo, JPanel frame, VistaBarraLateral vistaBarraLateral, Controlador controlador) {
        this.modelo = modelo;
        this.frame = frame;
        this.vistaBarraLateral = vistaBarraLateral;
        this.controlador = controlador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
//            this.modelo.getJugadorQueJuega().terminarTurno(this.modelo); //esto creo que lo tiene que ahcer el controlador
//            this.vistaBarraLateral.refrescar(this.modelo);
        	controlador.terminarTurno();
            this.vistaBarraLateral.setSelectedIndex(0);
            
            //estos los podemos hacer runtime, no podrian pasar nunca creo
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
