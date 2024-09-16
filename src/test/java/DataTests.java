import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import etapa1.Data;

public class DataTests {
    @Test
    public void construtorDataValida() {
        Data data = new Data(15, 8, 2023);
        assertEquals(15, data.getDia());
        assertEquals(8, data.getMes());
        assertEquals(2023, data.getAno());
    }

    @Test
    public void construtorDataInvalida() {
        Data data = new Data(29, 2, 2023);
        assertEquals(1, data.getDia());
        assertEquals(1, data.getMes());
        assertEquals(2000, data.getAno());
    }

    @Test
    public void verificaAnoBissexto_ShouldReturn_True_When2024() {
        Data anoBissexto = new Data(29, 2, 2024);
        assertTrue(anoBissexto.verificaAnoBissexto());
    }

    @Test
    public void verificaAnoBissexto_ShouldReturn_False_When2023() {
        Data anoNaoBissexto = new Data(28, 2, 2023);
        assertFalse(anoNaoBissexto.verificaAnoBissexto());
    }

    @Test
    public void toString_ShouldReturn_StringFormated() {
        Data data = new Data(15, 8, 2023);
        assertEquals("15/8/2023", data.toString());
    }
}
