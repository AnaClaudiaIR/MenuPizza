public class Extras extends Producto{
    public Extras(String nombre, double precioBase) {
        super(nombre, precioBase);
    }
    @Override
    public String toString() {
        return "---ADICIONALES---\n"+
                "· Nombre: " + getNombre().toUpperCase() + "\n" +
                "Precio...." + getPrecioBase() + "\n" +
                "*********************************\n";
    }
}
