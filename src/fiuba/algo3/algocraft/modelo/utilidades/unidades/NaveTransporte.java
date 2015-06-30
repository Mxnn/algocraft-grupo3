package fiuba.algo3.algocraft.modelo.utilidades.unidades;

import java.util.ArrayList;
import fiuba.algo3.algocraft.modelo.excepciones.*;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.Mapa;
import fiuba.algo3.algocraft.modelo.mapa.Parcela;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.utilidades.Costo;
import fiuba.algo3.algocraft.modelo.utilidades.Vitalidad;
import fiuba.algo3.algocraft.vista.ObservadorMapa;

public abstract class NaveTransporte extends Unidad {
    protected int lugaresOcupados;
    protected int capacidad;
    private ObservadorMapa observador;
    protected ArrayList<Unidad> unidades = new ArrayList<Unidad>();

    public NaveTransporte(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro, int capacidad, Costo costo) throws ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes {
        super(propietario, vitalidad, tiempoDeConstruccion, cupoDeTransporte, vision, suministro, costo);
        this.lugaresOcupados = 0;
        this.capacidad = capacidad;
    }

    public void setObservador(ObservadorMapa observador) {
        this.observador = observador;
    }

    public void insertarUnidad(Unidad unidad) throws ExcepcionNaveDeTransporteLlena, ExcepcionUnidadEnemiga, ExcepcionNoEsUnidadTerrestre, ExcepcionEntidadEnConstruccion, ExcepcionUnidadYaSeEncuentraEnLaNave {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        if (!unidad.getPropietario().equals(this.propietario))
            throw new ExcepcionUnidadEnemiga();

        if(this.unidades.contains(unidad))
            throw new ExcepcionUnidadYaSeEncuentraEnLaNave();

        if (unidad.getCupoDeTransporte() == 0)
            throw new ExcepcionNoEsUnidadTerrestre();

        int lugaresTotalesOcupadas = lugaresOcupados + unidad.getCupoDeTransporte();
        if (lugaresTotalesOcupadas <= capacidad) {
            lugaresOcupados = lugaresTotalesOcupadas;
            unidades.add(unidad);
            Parcela parcela = unidad.getParcela();
            if (parcela != null) //Fix medio triste
                parcela.vaciarParcela();

            if (this.observador != null)
                this.observador.removerUnidadDeLaVista(unidad);
        }
        else
            throw new ExcepcionNaveDeTransporteLlena();
    }

    @Override
    public void destruir() {
        for (Unidad u : unidades) {
            u.destruir();
        }
        super.destruir();
    }

    public int cantidadDeUnidades() {
        return this.unidades.size();
    }

    @Override
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }

    @Override
    public int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnAire();
    }

    @Override
    public int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnAire();
    }

    @Override
    public void recibirAtaque(Ataque ataque) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		ataque.atacar(this);
	}

    public void sacarUnidad(Mapa mapa) throws ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        if (this.unidades.size() > 0) {
            Unidad unidadSacada = this.unidades.remove(this.unidades.size() - 1);
            mapa.ubicarCercaDeParcela(this.parcelaUbicacion, unidadSacada);
        }
    }
}