package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.ConstruccionesProtoss.ArchivosTemplarios;
import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionNoHaySuministrosDisponibles;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.RazaProtoss.AltoTemplario;

public class ArchivosTemplariosTest {

	@Test
	public void crearAltoTemplariotCreaUnAltoTemplario() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionNoHaySuministrosDisponibles, ExcepcionRecursosInsuficientes {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesAereas();
        ArchivosTemplarios archivo = new ArchivosTemplarios(unJugador);

        Assert.assertTrue(archivo.crearAltoTemplario() instanceof AltoTemplario);
    }
	
	@Test
    public void obtenerTipoDeConstruccionDevuelveElTipoDeConstruccionCorrecto() throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        Jugador unJugador = new Jugador("Juan", Color.ROJO, Protoss.getInstance());
        unJugador.crearCreadorDeSoldados();
        unJugador.crearCreadorDeUnidadesAereas();
        ArchivosTemplarios archivo = new ArchivosTemplarios(unJugador);

        Assert.assertEquals(archivo.obtenerTipoDeConstruccion(), TipoDeConstruccion.CREADOR_DE_UNIDADES_TERRESTRES);
    }

}
