package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.Excepciones.ExcepcionConstruccionesRequeridasNoCreadas;
import fiuba.algo3.algocraft.Excepciones.ExcepcionRecursosInsuficientes;

public class Terran implements Raza {
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

    public boolean recursosInsuficientes(Jugador propietario, Costo costo){

    	return((propietario.obtenerGasVespeno()<costo.getCostoGas()) || (propietario.obtenerMineral()<costo.getCostoMineral()));
   
    }

    public void restarCosto(Jugador propietario, Costo costo){
    	propietario.sumarGasVespeno(-costo.getCostoGas());
    	propietario.sumarMinerales(-costo.getCostoMineral());
    }
    
	public ExtractorGas crearExtractorGas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,Refineria.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,Refineria.COSTO);
		return new Refineria(propietario);
	}


	public ExtractorMineral crearExtractorMineral(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (recursosInsuficientes(propietario,CentroDeMineral.COSTO)) 
            throw new ExcepcionRecursosInsuficientes();
		
        restarCosto(propietario,CentroDeMineral.COSTO);
		return new CentroDeMineral(propietario);
	}

    public AdicionalSuministros crearAdicionalDeSuministros(Jugador propietario) {
        return new DepositoSuministro(propietario);
    }

    public CreadorDeSoldados crearCreadorDeSoldados(Jugador propietario) {
        return new Barraca(propietario);
    }

    public CreadorDeUnidadesTerrestres crearCreadorDeUnidadesTerrestres(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        return new Fabrica(propietario);
    }

    public CreadorDeUnidadesAereas crearCreadorDeUnidadesAereas(Jugador propietario) throws ExcepcionConstruccionesRequeridasNoCreadas {
        return new PuertoEstelar(propietario);
    }
}
