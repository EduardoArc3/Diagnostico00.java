import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Diagnostico {
    public static void main(String[] args) {
        // El Path del archivo
        String archivo = "C:\\Users\\Rafael Arce Gaxiola\\Desktop\\DSIII\\untitled\\src\\codigos_postales_hmo";

        // Almacenar el archivo en un ArrayList // Almacenar los asentamientos
        ArrayList<String> ListaCodigos = new ArrayList<>();  ArrayList<Integer> asentamientos = new ArrayList<>();

        try { // LEER EL ARCHIVO LINEA POR LINEA Mediante BufferedReader
            FileReader CSV = new FileReader(archivo);
            BufferedReader bf = new BufferedReader(CSV);
            String LectorDeLinea;
            while ((LectorDeLinea = bf.readLine()) != null) { // Almacenarlas dentro de un while
                String[] Parteslineas = LectorDeLinea.split("\t");
                if (Parteslineas.length >= 2) { String codigoPostal = Parteslineas[0].trim();
                    int index = ListaCodigos.indexOf(codigoPostal);
                    if (index == -1) {
                        ListaCodigos.add(codigoPostal);
                        asentamientos.add(1);
                    } else {
                        asentamientos.set(index, asentamientos.get(index) + 1);
                    }
                }
            }
            bf.close();

            //Información en pantalla, aquí sucede la magia

            for (int i = 0; i <ListaCodigos.size() ; i++) {
                String codigito = ListaCodigos.get(i);
                int totalAsentamientos = asentamientos.get(i);
                System.out.println("Codigo Postal dado " + codigito + " : " + totalAsentamientos + " Asentamientos totales  ");

            }
                //EXEPCIONES OBLIGATORIOS POR QUE NO ME CORRE EL PROGRAMA SIN ELLAS
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}





