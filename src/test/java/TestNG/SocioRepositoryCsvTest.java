package TestNG;

import entities.Socio;
import entities.EdadInvalidaException;
import entities.NombreMuyLargoException;
import entities.DniInvalidoException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import repositories.SocioRepository;
import utils.CsvUtils;

import static org.testng.Assert.*;

public class SocioRepositoryCsvTest {

    private SocioRepository repo = new SocioRepository();

    @DataProvider(name = "sociosCSV")
    public Object[][] sociosCSV() throws Exception {
        return CsvUtils.leerSociosCSV("src/test/resources/socios.csv");
    }

    @Test(dataProvider = "sociosCSV")
    public void testAgregarSocioDesdeCSV(String nombre, int edad, String direccion, String dni) throws NombreMuyLargoException, EdadInvalidaException, DniInvalidoException {
        Socio s = new Socio(nombre, edad, direccion, dni);
        repo.agregar(s);

        Socio encontrado = repo.buscarPorDni(dni);
        assertNotNull(encontrado);
        assertEquals(encontrado.getNombre(), nombre);
    }
}
