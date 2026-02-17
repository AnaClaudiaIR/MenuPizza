import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarRecibo {
    public static void escribir(String fichero, Pedido pedido) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fichero))) {
            br.write("-----------------------------------------------");
            br.newLine();
            br.write("              RECIBO DE COMPRA                 ");
            br.newLine();
            br.write("-----------------------------------------------");
            br.newLine();
            br.newLine();
            for (Producto p: pedido.getListaProductos()){
                br.write(p.toString());
                br.newLine();
            }
            br.newLine();
            br.write("-------------------------------------");
            br.write("TOTAL: " + String.format("%.2f", pedido.getTotal()) + "€");
        } catch (IOException e) {
            System.out.println("Error: No se pudo escribir en el archivo --> " + e.getMessage());
        }
    }
}
