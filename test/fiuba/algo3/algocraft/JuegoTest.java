package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.*;

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
    public void crearJugadorConNombreAgregaJugadorAlJuego() throws ExcepcionColorEnUso, ExcepcionNombreEnUso, ExcepcionNombreCorto {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Pedro", Color.VERDE, Protoss.getInstance());

        Assert.assertEquals(juego.cantidadDeJugadores(), 2);
    }

    @Test(expected = ExcepcionNombreEnUso.class)
    public void crearJugadoresConNombresIgualesLanzaExcepcionNombreEnUso() throws ExcepcionColorEnUso, ExcepcionNombreEnUso, ExcepcionNombreCorto {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Juan", Color.VERDE, Protoss.getInstance());
    }

    @Test(expected = ExcepcionColorEnUso.class)
    public void crearJugadoresConColoresIgualesLanzaExcepcionColorEnUso() throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNombreCorto {
        Juego juego = new Juego();

        juego.crearJugador("Juan", Color.ROJO, Terran.getInstance());
        juego.crearJugador("Pedro", Color.ROJO, Protoss.getInstance());
    }

    @Test(expected = ExcepcionNombreCorto.class)
    public void crearJugadorConNombreConMenosDe4LetrasLanzaExcepcion() throws ExcepcionNombreEnUso, ExcepcionColorEnUso, ExcepcionNombreCorto {
        Juego juego = new Juego();

        juego.crearJugador("TRE", Color.ROJO, Terran.getInstance());
    }
}
