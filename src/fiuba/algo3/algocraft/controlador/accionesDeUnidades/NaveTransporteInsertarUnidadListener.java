package fiuba.algo3.algocraft.controlador.accionesDeUnidades;

import fiuba.algo3.algocraft.controlador.comandos.AccionPorTurnoListener;
import fiuba.algo3.algocraft.controlador.JuegoListener;
import fiuba.algo3.algocraft.controlador.comandos.ComandoIngresarALaNave;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import java.awt.event.ActionEvent;

public class NaveTransporteInsertarUnidadListener extends JuegoListener {
    private Unidad representado;
    private AccionPorTurnoListener accionPorTurnoListener;

    public NaveTransporteInsertarUnidadListener(Juego modelo, Unidad representado) {
        super(modelo);
        this.representado = representado;
        this.accionPorTurnoListener = AccionPorTurnoListener.createInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.accionPorTurnoListener.setUnidad(this.representado);
        this.accionPorTurnoListener.setComando(new ComandoIngresarALaNave(this));
    }
}
