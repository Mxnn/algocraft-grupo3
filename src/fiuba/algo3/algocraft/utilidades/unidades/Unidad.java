package fiuba.algo3.algocraft.utilidades.unidades;

import java.util.LinkedList;

import fiuba.algo3.algocraft.excepciones.ExcepcionElementoNoAdmitidoEnParcela;
import fiuba.algo3.algocraft.excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.excepciones.ExcepcionParcelaOcupada;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.mapa.*;
import fiuba.algo3.algocraft.utilidades.Interactuable;
import fiuba.algo3.algocraft.utilidades.Vitalidad;

public abstract class Unidad extends Interactuable {
	protected int cupoDeTransporte;
    protected int vision;
    protected int suministro;
    protected LinkedList<Coordenada> itinerario = new LinkedList<Coordenada>();

    public Unidad(Jugador propietario, Vitalidad vitalidad, int tiempoDeConstruccion, int cupoDeTransporte, int vision, int suministro) throws ExcepcionNoHaySuministrosDisponibles {
        super(propietario, vitalidad, tiempoDeConstruccion);
        this.cupoDeTransporte = cupoDeTransporte;
        this.vision = vision;
        this.suministro = suministro;
        propietario.agregarUnidad(this);
    }

    public int getVision() {
        return this.vision;
    }

    public void destruir() {
        (this.propietario).eliminarUnidad(this);
    }

    public int getCupoDeTransporte() { return this.cupoDeTransporte; }
    
    public void guardarEnParcela(ParcelaTierra parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        parcela.setElemento(this);
    }
    
    public void guardarEnParcela(ParcelaEspacio parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
    	throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaMineral parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public void guardarEnParcela(ParcelaVolcan parcela) throws ExcepcionElementoNoAdmitidoEnParcela, ExcepcionParcelaOcupada {
        throw new ExcepcionElementoNoAdmitidoEnParcela();
    }
    
    public int seleccionarDanyo(Danyo danyo){
    	return danyo.getDanyoDeAtaqueEnTierra();
    }
    
    public int seleccionarRango(RangoAtaque rango){
    	return rango.getRangoDeAtaqueEnTierra();
    }

    public Jugador getPropietario() {
        return this.propietario;
    }

    public int getSuministro() { return this.suministro; }

	public void calcularItinerario(Mapa mapa, Coordenada desde, Coordenada hasta) {
		/*LinkedList<Coordenada> elItinerario = new LinkedList<Coordenada>();

		int auxX = desde.getX();
		int auxY = desde.getY();

		int hastaX = hasta.getX();
		int hastaY= hasta.getY();
		elItinerario.add(new Coordenada(auxX,auxY));

		while ((auxX!=hasta.getX())||(auxY!=hasta.getY())){
			System.out.println("avant llego auxX=");
			System.out.println(auxX);
			System.out.println("nollego");
			System.out.println("auxX=");
			System.out.println(auxX);
			System.out.println("hastaX=");
			System.out.println(hasta.getX());
			if (auxX!=hasta.getX()){
				int direccion;
				if (auxX<hastaX){
					direccion = 1;
				}else{
					direccion = -1;
				}

				System.out.println(direccion);

				while ((this.devolverElementoEnParcela(new Coordenada(auxX+ direccion, auxY))==null) && (auxX!=hastaX)){
					auxX = auxX + direccion;
					elItinerario.add(new Coordenada(auxX,auxY));
					System.out.println("x");
					System.out.println("auxX=");
					System.out.println(auxX);
				}
				System.out.println("apres while auxX=");
				System.out.println(auxX);
			}
			System.out.println("apres while et sorti if auxX=");
			System.out.println(auxX);

			if(auxY!=hasta.getY()){

				int direccion;
				if (auxY<hastaY){
					direccion = 1;
				}else{
					direccion = -1;
				}

				System.out.println(direccion);

				while ((this.devolverElementoEnParcela(new Coordenada(auxX, direccion+ auxY))==null)&& (auxY!=hastaY)){
					auxY=auxY + direccion;
					elItinerario.add(new Coordenada(auxX,auxY));
					System.out.println("y");
				}

			}

			System.out.println("a while auxX=");
			System.out.println(auxX);
		}*/

		Parcela parcelaDestinacion = mapa.getTablero().get(hasta);
		if (this.destinacionPermitida(parcelaDestinacion)){
			this.itinerario.clear();
			this.itinerario.add(desde); // la unidad se teleporta , tenemos que hacer un mejor calcul de itinerario
			this.itinerario.add(hasta);
		}
	}

	public boolean destinacionPermitida(Parcela parcelaDestinacion) {
		return true;
	}

    public LinkedList<Coordenada> getItinerario() {
        return this.itinerario;
    }
}