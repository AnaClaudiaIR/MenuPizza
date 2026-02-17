public class Bebida extends Producto{
    public Bebida(String nombre, double precioBase) {
        super(nombre, precioBase);
    }
    @Override
    public String toString() {
        return "---BEBIDA---\n"+
                "· Nombre: " + getNombre().toUpperCase() + "\n" +
                "Precio...." + getPrecioBase() + "\n" +
                "*********************************\n";
    }
}
