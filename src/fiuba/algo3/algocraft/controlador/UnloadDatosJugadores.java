package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionAlcanzadoElMaximoCupoDeJugadores;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionCoordenadaFueraDelMapa;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreCorto;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNombreEnUso;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.vista.IngresoJugadoresVista;
import fiuba.algo3.algocraft.vista.VistaJuego;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UnloadDatosJugadores implements ActionListener {

    private Juego modelo;
    private IngresoJugadoresVista frame;
    private VistaJuego vista;

    public UnloadDatosJugadores(Juego modelo, IngresoJugadoresVista frame, VistaJuego vista) {
        this.modelo = modelo;
        this.frame = frame;
        this.vista = vista;
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
        ArrayList<Jugador> jugadores = this.getJugadores();

        if (jugadores != null && jugadores.size() == 2) {
            try {
                this.modelo.agregarJugador(jugadores.get(0));
                this.modelo.agregarJugador(jugadores.get(1));
                for (Jugador jugador: this.modelo.getJugadores()) {
                    jugador.setObservadores(vista.getObservadorMapa());
                    jugador.setObservadorJugador(vista.getObservadorJugador());
                }

                vista.refrescar();
                
                this.frame.dispose();
            } catch (ExcepcionNombreEnUso excepcionNombreEnUso) {
                JOptionPane.showMessageDialog(this.frame, "Los nombres de los jugadores no pueden ser iguales");
                this.modelo.limpiarJugadores();
            } catch (ExcepcionColorEnUso excepcionColorEnUso) {
                JOptionPane.showMessageDialog(this.frame, "Los colores de los jugadores no pueden ser iguales");
                this.modelo.limpiarJugadores();
            } catch (ExcepcionAlcanzadoElMaximoCupoDeJugadores excepcionAlcanzadoElMaximoCupoDeJugadores) {
                JOptionPane.showMessageDialog(this.frame, "Imposible crear nuevo juego. Ya hay un juego en curso");
            } catch (ExcepcionCoordenadaFueraDelMapa e) {
				// Ver que onda con esta excepcion
            	this.modelo.limpiarJugadores();
			} 
        }
	}

    private ArrayList<Jugador> getJugadores() {
        ArrayList<Jugador> jugadores = null;
        try {
            jugadores = this.frame.getJugadores();
        }
        catch (ExcepcionNombreCorto excepcionNombreCorto) {
            JOptionPane.showMessageDialog(this.frame, "El nombre del jugador debe superar los " + (Jugador.LONGITUD_MINIMA_PARA_EL_NOMBRE - 1) + " caracteres");
        }

        return jugadores;
    }
}
