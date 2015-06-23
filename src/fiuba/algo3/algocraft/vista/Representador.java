package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.util.HashMap;

import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaEspacio;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaMineral;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaTierra;
import fiuba.algo3.algocraft.modelo.mapa.ParcelaVolcan;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.*;

public class Representador {
	private HashMap<Class, String> codigoElementos;
	private HashMap<Class, Color> coloresParcelas;
    private HashMap<fiuba.algo3.algocraft.modelo.juego.Color, Color> coloresDeTextos;
	
	public Representador(){
		this.codigoElementos = new HashMap<Class, String>();
		this.codigoElementos.put(Barraca.class, "Ba");
		this.codigoElementos.put(CentroDeMineral.class, "CM");
		this.codigoElementos.put(DepositoSuministro.class, "DS");
		this.codigoElementos.put(Fabrica.class, "Fa");
		this.codigoElementos.put(PuertoEstelar.class, "PET");
		this.codigoElementos.put(Refineria.class, "Re");
		
		this.codigoElementos.put(Espectro.class, "Es");
		this.codigoElementos.put(Golliat.class, "Go");
		this.codigoElementos.put(Marine.class, "Ma");
		this.codigoElementos.put(NaveCiencia.class, "NC");
		this.codigoElementos.put(NaveTransporteTerran.class, "NTT");
		
		this.codigoElementos.put(Acceso.class, "Ac");
		this.codigoElementos.put(ArchivosTemplarios.class, "ArT");
		this.codigoElementos.put(Asimilador.class, "As");
		this.codigoElementos.put(NexoMineral.class, "NM");
		this.codigoElementos.put(Pilon.class, "Pi");
		this.codigoElementos.put(PuertoEstelarProtoss.class, "PEP");
		
		this.codigoElementos.put(AltoTemplario.class, "AT");
		this.codigoElementos.put(Dragon.class, "Dr");
		this.codigoElementos.put(NaveTransporteProtoss.class, "NTP");
		this.codigoElementos.put(Scout.class, "Sc");
		this.codigoElementos.put(Zealot.class, "Ze");

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
	
	public String getCodigo(Object o){
		return this.codigoElementos.get(o.getClass());
	}

	public Color getColorParcela(Object o) {
		// TODO Auto-generated method stub
		return this.coloresParcelas.get(o.getClass());
	}

    public Color getColorTexto(Jugador j) {
        return this.coloresDeTextos.get(j.getColor());
    }
}
