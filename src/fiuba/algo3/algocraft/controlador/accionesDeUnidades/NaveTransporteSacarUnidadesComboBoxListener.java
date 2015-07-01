package fiuba.algo3.algocraft.controlador.accionesDeUnidades;

import fiuba.algo3.algocraft.controlador.JuegoListener;
import fiuba.algo3.algocraft.modelo.excepciones.ExcepcionNoHayLugarDisponible;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.NaveTransporte;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class NaveTransporteSacarUnidadesComboBoxListener extends JuegoListener {
    private NaveTransporte nave;
    private Mapa mapa;

    public NaveTransporteSacarUnidadesComboBoxListener(Juego modelo, NaveTransporte nave) {
        super(modelo);
        this.mapa = modelo.getMapa();
        this.nave = nave;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        Unidad unidadSeleccionada = (Unidad) cb.getSelectedItem();
        try {
            nave.sacarUnidad(this.mapa, unidadSeleccionada);
            cb.removeItemAt(cb.getSelectedIndex());
        } catch (ExcepcionNoHayLugarDisponible error) {
            this.mostrarError(error.getMessage());
        }
    }
}
