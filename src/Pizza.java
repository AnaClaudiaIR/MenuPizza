import java.util.List;

public class Pizza extends Producto {
    private List<String> toppings;
    private String salsa;

    public Pizza(String nombre, double precioBase, List<String> toppings, String salsa) {
        super(nombre, precioBase);
        this.toppings = toppings;
        this.salsa = salsa;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public String getSalsa() {
        return salsa;
    }

    @Override
    public String toString() {
        return "---PIZZA---\n" +
                "· Tamaño: " + getNombre().toUpperCase()+"\n"+
                "· Salsa: " + getSalsa().toUpperCase()+"\n"+
                "· Toppings: " + getToppings() + "\n" +
                "Precio.... " + getPrecioBase() + "\n"+
                "*********************************\n";
    }
}


