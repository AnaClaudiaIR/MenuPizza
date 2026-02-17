import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerRecibo {
    public static void leer(String fichero){
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e){
            System.out.println("Error al leer el fichero --> " + e.getMessage());
        }
    }
}
