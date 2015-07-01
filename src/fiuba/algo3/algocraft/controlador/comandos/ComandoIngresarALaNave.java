package fiuba.algo3.algocraft.controlador.comandos;

import fiuba.algo3.algocraft.controlador.accionesDeUnidades.NaveTransporteInsertarUnidadListener;
import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.mapa.Coordenada;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.NaveTransporte;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Unidad;

public class ComandoIngresarALaNave extends ComandoAccionPorTurno {
    private NaveTransporteInsertarUnidadListener listener;

    public ComandoIngresarALaNave(NaveTransporteInsertarUnidadListener listener) {
        this.listener = listener;
    }

    @Override
    public void ejecutar(Unidad nave, Mapa mapa, Coordenada coordenadaObjetivo) throws ExcepcionEnemigoFueraDeAlcance, ExcepcionEstadoMuerto, ExcepcionEnergiaInsuficiente, ExcepcionParcelaVacia {

        try {
            Unidad unidadAIngresar = (Unidad) mapa.devolverElementoEnParcela(coordenadaObjetivo);
            try {
                ((NaveTransporte) nave).insertarUnidad(unidadAIngresar);
            }
            catch (ExcepcionNaveDeTransporteLlena e) {
                this.listener.mostrarError(e.getMessage());
            } catch (ExcepcionUnidadEnemiga e) {
                this.listener.mostrarError(e.getMessage());
            } catch (ExcepcionNoEsUnidadTerrestre e) {
                this.listener.mostrarError(e.getMessage());
            } catch (ExcepcionUnidadMuyLejos e) {
                this.listener.mostrarError(e.getMessage());
            }
        }
        catch (ClassCastException e) {
            this.listener.mostrarError("Solo se pueden insertar unidades");
        }
    }
}
