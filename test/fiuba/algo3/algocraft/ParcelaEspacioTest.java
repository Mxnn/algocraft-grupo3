package fiuba.algo3.algocraft;

import org.junit.Test;

public class ParcelaEspacioTest {

    @Test(expected = ExcepcionElementoInvalidoParaParcela.class)
    public void guardarElementoLanzaExcepcionSiElElementoEsUnRecurso() throws ExcepcionElementoInvalidoParaParcela {
        Parcela parcela = new ParcelaEspacio();
        Interactuable recurso = new Recurso();

        parcela.guardarElemento(recurso);
    }
}
