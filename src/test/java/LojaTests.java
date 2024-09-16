import org.junit.Test;
import etapa1.Loja;
import static org.junit.Assert.assertEquals;

public class LojaTests {
    @Test
    public void gastosComSalario_SalarioBaseNegativo() {
        Loja loja = new Loja("loja1", 10);
        assertEquals(-1, loja.gastosComSalario(), 0);
    }

    @Test
    public void gastosComSalario_SalarioBase3000() {
        Loja loja = new Loja("loja1", 6, 3000);
        assertEquals(18000, loja.gastosComSalario(), 0);
    }

    @Test
    public void tamanhoDaLoja_Pequena() {
        Loja loja = new Loja("loja1", 5);
        loja.setQuantidadeFuncionarios(5);
        assertEquals('P', loja.tamanhoDaLoja());
    }

    @Test
    public void tamanhoDaLoja_Media() {
        Loja loja = new Loja("loja1", 20);
        loja.setQuantidadeFuncionarios(20);
        assertEquals('M', loja.tamanhoDaLoja());
    }

    @Test
    public void tamanhoDaLoja_Grande() {
        Loja loja = new Loja("loja1", 40);
        loja.setQuantidadeFuncionarios(40);
        assertEquals('G', loja.tamanhoDaLoja());
    }
}

