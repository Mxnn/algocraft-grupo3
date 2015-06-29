package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.util.HashMap;
import fiuba.algo3.algocraft.modelo.juego.Jugador;

public class Representador {
    private HashMap<fiuba.algo3.algocraft.modelo.juego.Color, Color> coloresDeTextos;

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
	}

    public Color getColorTexto(Jugador j) {
        return this.coloresDeTextos.get(j.getColor());
    }
}
