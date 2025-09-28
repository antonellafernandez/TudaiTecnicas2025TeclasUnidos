package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    // Leer socios desde CSV
    // CSV esperado: nombre,edad,direccion,dni
    public static Object[][] leerSociosCSV(String ruta) throws IOException {
        List<Object[]> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String line;

        // Saltar cabecera
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] campos = line.split(",");
            String nombre = campos[0].trim();
            int edad = Integer.parseInt(campos[1].trim());
            String direccion = campos[2].trim();
            String dni = campos[3].trim();

            lista.add(new Object[]{nombre, edad, direccion, dni});
        }
        br.close();
        return lista.toArray(new Object[0][]);
    }

    // Leer actividades desde CSV
    // CSV esperado: nombre,encargado,horario,edadMinima,lugar,cupo
    public static Object[][] leerActividadesCSV(String ruta) throws IOException {
        List<Object[]> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String line;

        // Saltar cabecera
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] campos = line.split(",");
            String nombre = campos[0].trim();
            String encargado = campos[1].trim();
            String horario = campos[2].trim();
            int edadMinima = Integer.parseInt(campos[3].trim());
            String lugar = campos[4].trim();
            int cupo = Integer.parseInt(campos[5].trim());

            lista.add(new Object[]{nombre, encargado, horario, edadMinima, lugar, cupo});
        }
        br.close();
        return lista.toArray(new Object[0][]);
    }
}
