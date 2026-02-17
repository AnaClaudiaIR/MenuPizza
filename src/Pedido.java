import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> listaProductos = new ArrayList<>();
    private double total;

    public void agregarProducto(Producto p) {
        listaProductos.add(p);
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public double getTotal() {
        return total;
    }

    public void calcularTotal() {
        this.total = 0;
        for (Producto p : listaProductos) {
            this.total += p.getPrecioBase();
        }
    }
}

