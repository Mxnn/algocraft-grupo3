package fiuba.algo3.algocraft.utilidades.unidades;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.Mapa;
import fiuba.algo3.algocraft.mapa.Parcela;
import fiuba.algo3.algocraft.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.utilidades.Vitalidad;

import java.util.ArrayList;

public abstract class NaveTransporte extends Unidad {
    protected int lugaresOcupados;
    protected int capacidad;
    protected ArrayList<Unidad> unidades = new ArrayList<Unidad>();

    public NaveTransporte(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro, int capacidad) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, vitalidad, tiempoDeConstruccion, cupoDeTransporte, vision, suministro);
        this.lugaresOcupados = 0;
        this.capacidad = capacidad;
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
        }
        else
            throw new ExcepcionNaveDeTransporteLlena();
    }

    public void destruir() {
        for (Unidad u : unidades) {
            u.destruir();
        }
        super.destruir();
    }

    public int cantidadDeUnidades() {
        return this.unidades.size();
    }

    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	parcela.setElemento(this);
    }

    public int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnAire();
    }

    public int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnAire();
    }
    
    public void recibirAtaque(Ataque ataque) throws ExcepcionEstadoMuerto, ExcepcionEnemigoFueraDeAlcance{
		ataque.atacar(this);
	}

    public void sacarUnidad(Mapa mapa, Unidad unidad) throws ExcepcionNoHayLugarDisponible, ExcepcionEntidadEnConstruccion {
        if (!this.estaCreado())
            throw new ExcepcionEntidadEnConstruccion();

        int index = unidades.indexOf(unidad);
        Unidad unidadSacada = unidades.get(index);
        unidades.remove(unidad);

        mapa.ubicarCercaDeParcela(this.parcelaUbicacion, unidadSacada);
    }
    
}