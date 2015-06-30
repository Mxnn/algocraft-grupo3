package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionEstadoMuerto;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import java.awt.event.ActionEvent;

public class TerminarTurnoListener extends JuegoListener {
    private Juego modelo;
    public TerminarTurnoListener(Juego modelo) {
    	super(modelo);
        this.modelo = modelo;

    }
//por ahora le paso la vista para que siga funcionando pasar el turno
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
				modelo.pasarTurno(this.modelo.getJugadorQueJuega());

        	ControladorAccionPorTurno.createInstance().resetControlador();
            //estos los podemos hacer runtime, no podrian pasar nunca creo
        } catch (ExcepcionEstadoMuerto excepcionEstadoMuerto) {
//            JOptionPane.showMessageDialog(this.frame, "...");
        }
    }
}
