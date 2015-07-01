package fiuba.algo3.algocraft.controlador;

import fiuba.algo3.algocraft.controlador.comandos.ComandoIngresarALaNave;
import fiuba.algo3.algocraft.modelo.juego.Juego;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;
import java.awt.event.ActionEvent;

public class NaveTransporteInsertarUnidadListener extends JuegoListener {
    private Unidad representado;
    private ControladorAccionPorTurno controladorAccionPorTurno;

    public NaveTransporteInsertarUnidadListener(Juego modelo, Unidad representado) {
        super(modelo);
        this.representado = representado;
        this.controladorAccionPorTurno = ControladorAccionPorTurno.createInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controladorAccionPorTurno.setUnidad(this.representado);
        this.controladorAccionPorTurno.setComando(new ComandoIngresarALaNave(this));
    }
}
