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


	public ExtractorGas crearExtractorGas(Jugador propietario) throws ExcepcionRecursosInsuficientes {
        if (propietario.obtenerMineral() < Refineria.COSTO_MINERAL) 
            throw new ExcepcionRecursosInsuficientes();
		
        propietario.sumarMinerales(-Refineria.COSTO_MINERAL);
		return new Refineria(propietario);
	}


	public ExtractorMineral crearExtractorMineral(Jugador propietario) {
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
