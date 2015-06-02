package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionColorEnUso;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNombreEnUso;
import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {

    /*@Test MAS TARDE DEBERIAMOS HACER ESTO
    public void soloHayUnaInstanciaDeJuego() {
        Juego juego1 = Juego.getInstance();
        Juego juego2 = Juego.getInstance();

        Assert.assertSame(juego1, juego2);
    }*/

    @Test
    public void crearJugadorConNombreAgregaJugadorAlJuego() throws ExcepcionColorEnUso, ExcepcionNombreEnUso {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Pedro", Color.VERDE, Protoss.getInstance());

        Assert.assertEquals(juego.cantidadDeJugadores(), 2);
    }

    @Test(expected = ExcepcionNombreEnUso.class)
    public void crearJugadoresConNombresIgualesLanzaExcepcionNombreEnUso() throws ExcepcionColorEnUso, ExcepcionNombreEnUso {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Juan", Color.VERDE, Protoss.getInstance());
    }

    @Test(expected = ExcepcionColorEnUso.class)
    public void crearJugadoresConColoresIgualesLanzaExcepcionColorEnUso() throws ExcepcionNombreEnUso, ExcepcionColorEnUso {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Pedro", Color.ROJO, Protoss.getInstance());
    }
}
