package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEnemigoFueraDeAlcance;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoEsElTurnoDelJugador;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.vista.VistaMapa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminarTurnoListener implements ActionListener {
    private Juego modelo;
    public TerminarTurnoListener(Juego modelo) {
        this.modelo = modelo;

    }
//por ahora le paso la vista para que siga funcionando pasar el turno
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
        	modelo.pasarTurno(this.modelo.getJugadorQueJuega());
            //estos los podemos hacer runtime, no podrian pasar nunca creo
        } catch (ExcepcionEstadoMuerto excepcionEstadoMuerto) {
//            JOptionPane.showMessageDialog(this.frame, "...");
        } catch (ExcepcionEnemigoFueraDeAlcance excepcionEnemigoFueraDeAlcance) {
//            JOptionPane.showMessageDialog(this.frame, "...");
        } 
    }
}
