package TestNG;

import entities.Actividad;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import repositories.ActividadRepository;
import utils.CsvUtils;

import static org.testng.Assert.*;

public class ActividadRepositoryCsvTest {

    private ActividadRepository repo = new ActividadRepository();

    @DataProvider(name = "actividadesCSV")
    public Object[][] actividadesCSV() throws Exception {
        return CsvUtils.leerActividadesCSV("src/test/resources/actividades.csv");
    }

    @Test(dataProvider = "actividadesCSV")
    public void testAgregarActividadDesdeCSV(String nombre, String encargado, String horario, int edadMinima, String lugar, int cupo) {
        Actividad a = new Actividad(nombre, encargado, horario, edadMinima, lugar, cupo);
        repo.agregar(a);

        Actividad encontrado = repo.buscarPorNombre(nombre);
        assertNotNull(encontrado);
        assertEquals(encontrado.getNombre(), nombre);
    }
}
