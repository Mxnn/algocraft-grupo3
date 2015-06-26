package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.util.HashMap;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.*;
import fiuba.algo3.algocraft.vista.botones.*;

public class Representador {
	private HashMap<Class, Class> codigoElementos;
	private HashMap<Class, Color> coloresParcelas;
    private HashMap<fiuba.algo3.algocraft.modelo.juego.Color, Color> coloresDeTextos;

	public Representador(){

		this.codigoElementos = new HashMap<Class, Class>();
		this.codigoElementos.put(Barraca.class, VistaBotonBarraca.class);
		this.codigoElementos.put(CentroDeMineral.class,  VistaBotonCentroMineral.class);
		this.codigoElementos.put(DepositoSuministro.class,  VistaBotonDepositoSuministro.class);
		this.codigoElementos.put(Fabrica.class,  VistaBotonFabrica.class);
		this.codigoElementos.put(PuertoEstelar.class, VistaBotonPuertoEstelar.class);
		this.codigoElementos.put(Refineria.class,  VistaBotonRefineria.class);
		
		this.codigoElementos.put(Espectro.class,  VistaBotonEspectro.class);
		this.codigoElementos.put(Golliat.class,  VistaBotonGolliat.class);
		this.codigoElementos.put(Marine.class,  VistaBotonMarine.class);
		this.codigoElementos.put(NaveCiencia.class,  VistaBotonNaveCiencia.class);
		this.codigoElementos.put(NaveTransporteTerran.class,  VistaBotonNaveTransporteTerran.class);
		
		this.codigoElementos.put(Acceso.class,  VistaBotonAcceso.class);
		this.codigoElementos.put(ArchivosTemplarios.class,  VistaBotonArchivosTemplarios.class);
		this.codigoElementos.put(Asimilador.class,  VistaBotonAsimilador.class);
		this.codigoElementos.put(NexoMineral.class,  VistaBotonNexoMineral.class);
		this.codigoElementos.put(Pilon.class,  VistaBotonPilon.class);
		this.codigoElementos.put(PuertoEstelarProtoss.class,  VistaBotonPuertoEstelarProtoss.class);
		
		this.codigoElementos.put(AltoTemplario.class,  VistaBotonAltoTemplario.class);
		this.codigoElementos.put(Dragon.class,  VistaBotonDragon.class);
		this.codigoElementos.put(NaveTransporteProtoss.class,  VistaBotonNaveTransporteProtoss.class);
		this.codigoElementos.put(Scout.class,  VistaBotonScout.class);
		this.codigoElementos.put(Zealot.class,  VistaBotonZealot.class);

//		this.coloresParcelas = new HashMap<Class, Color>();
//        this.coloresParcelas.put(ParcelaTierra.class, Color.lightGray);
//        this.coloresParcelas.put(ParcelaEspacio.class, Color.black);
//        this.coloresParcelas.put(ParcelaVolcan.class, new Color(0xA47861));
//        this.coloresParcelas.put(ParcelaMineral.class, new Color(0x80C0D2));
		
		this.coloresParcelas = new HashMap<Class, Color>();
        this.coloresParcelas.put(ParcelaTierra.class, Color.lightGray);
        this.coloresParcelas.put(ParcelaEspacio.class, Color.black);
        this.coloresParcelas.put(ParcelaVolcan.class, new Color(0xA47861));
        this.coloresParcelas.put(ParcelaMineral.class, new Color(0x80C0D2));

        this.coloresDeTextos = new HashMap<fiuba.algo3.algocraft.modelo.juego.Color, Color>();
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.ROJO, Color.red);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.AZUL, Color.blue);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.VERDE, Color.green);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.AMARILLO, Color.yellow);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.NARANJA, new Color(0xFF9900));
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.VIOLETA, new Color(0x9015B2));
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.BLANCO, Color.white);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.CELESTE, Color.cyan);
	}
	
	public VistaBotonInteractuable getCodigo(Object o){
		try {
			return (VistaBotonInteractuable) (this.codigoElementos.get(o.getClass())).newInstance();
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}

	public Color getColorParcela(Object o) {
		// TODO Auto-generated method stub
		return this.coloresParcelas.get(o.getClass());
	}

    public Color getColorTexto(Jugador j) {
        return this.coloresDeTextos.get(j.getColor());
    }
}
