package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.*;
import fiuba.algo3.algocraft.juego.Color;
import fiuba.algo3.algocraft.juego.Juego;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.razas.protoss.Protoss;
import fiuba.algo3.algocraft.razas.terran.Terran;
import org.junit.Assert;
import org.junit.Test;

public class IntegradoresTest {
    @Test
    public void pruebaIntegracion1() throws ExcepcionNumeroDeBasesInvalido, ExcepcionNombreCorto, ExcepcionColorEnUso, ExcepcionAlcanzadoElMaximoCupoDeJugadores, ExcepcionNombreEnUso {
        Juego juego = new Juego();
        Jugador jTerran = new Jugador("Juan", Color.ROJO, Terran.getInstance());
        Jugador jProtoss = new Jugador("Carlos", Color.AZUL, Protoss.getInstance());
        juego.agregarJugador(jTerran);
        juego.agregarJugador(jProtoss);

        Assert.assertTrue(true);
    }
}
