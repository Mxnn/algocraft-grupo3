package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;
import fiuba.algo3.algocraft.terran.construcciones.Barraca;
import fiuba.algo3.algocraft.terran.construcciones.CentroDeMineral;
import fiuba.algo3.algocraft.terran.construcciones.DepositoSuministro;
import fiuba.algo3.algocraft.terran.construcciones.Fabrica;
import fiuba.algo3.algocraft.terran.construcciones.PuertoEstelar;
import fiuba.algo3.algocraft.terran.construcciones.Refineria;

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

    public CreadorDeSoldados crearCreadorDeSoldados(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Barraca.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,Barraca.COSTO);
        return new Barraca(propietario);
    }

    public CreadorDeUnidadesTerrestres crearCreadorDeUnidadesTerrestres(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Fabrica.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,Fabrica.COSTO);
    	return new Fabrica(propietario);
    }

    public CreadorDeUnidadesAereas crearCreadorDeUnidadesAereas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas, ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,PuertoEstelar.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,PuertoEstelar.COSTO);
    	return new PuertoEstelar(propietario);
    }
}
