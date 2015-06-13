package fiuba.algo3.algocraft.terran;

import fiuba.algo3.algocraft.excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.juego.Jugador;
import fiuba.algo3.algocraft.razas.Raza;
import fiuba.algo3.algocraft.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.terran.construcciones.DepositoSuministro;
import fiuba.algo3.algocraft.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.terran.construcciones.Refineria;
import fiuba.algo3.algocraft.utilidades.construcciones.Construccion;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorGas;
import fiuba.algo3.algocraft.utilidades.construcciones.ExtractorMineral;
import fiuba.algo3.algocraft.utilidades.unidades.AdicionalSuministros;

public class Terran extends Raza {
    private static Terran INSTANCIA = null;

    private Terran() { }

    private synchronized static void createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new Terran();
        }
    }

    public static Terran getInstance() {
        if (INSTANCIA == null)
            createInstance();

        return INSTANCIA;
    }

	public ExtractorGas crearExtractorGas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario, Refineria.COSTO))
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario, Refineria.COSTO);
		return new Refineria(propietario);
	}


	public ExtractorMineral crearExtractorMineral(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,CentroDeMineral.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,CentroDeMineral.COSTO);
		return new CentroDeMineral(propietario);
	}

    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,DepositoSuministro.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,DepositoSuministro.COSTO);
        
        return new DepositoSuministro(propietario);
    }

    public Construccion crearCreadorDeSoldados(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Barraca.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,Barraca.COSTO);
        return new Barraca(propietario);
    }

    public Construccion crearCreadorDeUnidadesTerrestres(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Fabrica.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,Fabrica.COSTO);
    	return new Fabrica(propietario);
    }

    public Construccion crearCreadorDeUnidadesAereas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,PuertoEstelar.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,PuertoEstelar.COSTO);
    	return new PuertoEstelar(propietario);
    }
}
