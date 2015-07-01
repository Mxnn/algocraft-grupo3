package fiuba.algo3.algocraft.vista.observadores.mapa;

import java.awt.Color;
import java.util.HashMap;

import fiuba.algo3.algocraft.modelo.juego.Jugador;
import fiuba.algo3.algocraft.modelo.razas.terran.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.terran.unidades.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.construcciones.*;
import fiuba.algo3.algocraft.modelo.razas.protoss.unidades.*;
import fiuba.algo3.algocraft.modelo.utilidades.Interactuable;
import fiuba.algo3.algocraft.modelo.utilidades.unidades.Clon;
import fiuba.algo3.algocraft.vista.botones.*;

public class Representador {
    private HashMap<fiuba.algo3.algocraft.modelo.juego.Color, Color> coloresDeTextos;
    private HashMap<Class<?>, Class<?>> botonesDeClase;

	public Representador() {
        this.coloresDeTextos = new HashMap<fiuba.algo3.algocraft.modelo.juego.Color, Color>();
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.ROJO, Color.red);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.AZUL, Color.blue);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.VERDE, Color.green);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.AMARILLO, Color.yellow);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.NARANJA, new Color(0xFF9900));
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.VIOLETA, new Color(0x9015B2));
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.BLANCO, Color.white);
        this.coloresDeTextos.put(fiuba.algo3.algocraft.modelo.juego.Color.CELESTE, Color.cyan);

        this.botonesDeClase = new HashMap<Class<?>, Class<?>>();
        this.botonesDeClase.put(Barraca.class, VistaBotonBarraca.class);
        this.botonesDeClase.put(CentroDeMineral.class,  VistaBotonCentroMineral.class);
        this.botonesDeClase.put(DepositoSuministro.class,  VistaBotonDepositoSuministro.class);
        this.botonesDeClase.put(Fabrica.class,  VistaBotonFabrica.class);
        this.botonesDeClase.put(PuertoEstelar.class, VistaBotonPuertoEstelar.class);
        this.botonesDeClase.put(Refineria.class,  VistaBotonRefineria.class);

        this.botonesDeClase.put(Espectro.class,  VistaBotonEspectro.class);
        this.botonesDeClase.put(Golliat.class,  VistaBotonGolliat.class);
        this.botonesDeClase.put(Marine.class,  VistaBotonMarine.class);
        this.botonesDeClase.put(NaveCiencia.class,  VistaBotonNaveCiencia.class);
        this.botonesDeClase.put(NaveTransporteTerran.class,  VistaBotonNaveTransporteTerran.class);

        this.botonesDeClase.put(Acceso.class,  VistaBotonAcceso.class);
        this.botonesDeClase.put(ArchivosTemplarios.class,  VistaBotonArchivosTemplarios.class);
        this.botonesDeClase.put(Asimilador.class,  VistaBotonAsimilador.class);
        this.botonesDeClase.put(NexoMineral.class,  VistaBotonNexoMineral.class);
        this.botonesDeClase.put(Pilon.class,  VistaBotonPilon.class);
        this.botonesDeClase.put(PuertoEstelarProtoss.class,  VistaBotonPuertoEstelarProtoss.class);

        this.botonesDeClase.put(AltoTemplario.class,  VistaBotonAltoTemplario.class);
        this.botonesDeClase.put(Clon.class,  VistaBotonClon.class);
        this.botonesDeClase.put(Dragon.class,  VistaBotonDragon.class);
        this.botonesDeClase.put(NaveTransporteProtoss.class,  VistaBotonNaveTransporteProtoss.class);
        this.botonesDeClase.put(Scout.class,  VistaBotonScout.class);
        this.botonesDeClase.put(Zealot.class,  VistaBotonZealot.class);
	}

    public Color getColorTexto(Jugador j) {
        return this.coloresDeTextos.get(j.getColor());
    }

    public Class<?> getClaseBoton(Interactuable interactuable) {
        return this.botonesDeClase.get(interactuable.getClass());
    }
}
