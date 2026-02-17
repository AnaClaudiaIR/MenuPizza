import java.util.*;

public class PizzaMain {
    public static void main(String[] args){
        Map<String, List<String>> pizza = new HashMap<>();
        String fichero = "recibo.txt";
        Pedido pedido = new Pedido();
        String opcion = "";

        Scanner scanner = new Scanner(System.in);
        int menu;

        do {
            System.out.println("---MENÚ---");
            System.out.println("1. Pizza.");
            System.out.println("2. Bebida.");
            System.out.println("3. Complementos adicionales.");
            System.out.println("0. salir.");
            System.out.println("¿Qué desea pedir?");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu){
                case 1:
                    String topping ="";
                    double precioPizza = 0;

                    System.out.println("Escoja el tamaño: ");
                    System.out.println("· Pequeña --> 7,99€");
                    System.out.println("· Mediana --> 9,99€");
                    System.out.println("· Grande --> 12,99€");
                    String size = scanner.nextLine();

                    switch (size.toLowerCase()){
                        case "pequeña":
                            precioPizza = 7.99;
                            break;
                        case "mediana":
                            precioPizza = 9.99;
                            break;
                        case "grande":
                            precioPizza = 12.99;
                            break;
                        default:
                            System.out.println("Escoja un tamaño válido.");
                    }

                    System.out.println("Escoja la salsa: ");
                    System.out.println("· Tomate");
                    System.out.println("· Barbacoa");
                    String salsa = scanner.nextLine();

                    System.out.println("¿Desea añadir toppings? (s/n)");
                    String opcionTop = scanner.nextLine();

                    List<String> toppings = new ArrayList<>();
                    List<String> sinToppings = new ArrayList<>();

                    if (opcionTop.equalsIgnoreCase("n")){
                        topping = "Sin toppings";
                        sinToppings.add(topping);
                        Pizza pizza1 = new Pizza(size,precioPizza,sinToppings,salsa);
                        pedido.agregarProducto(pizza1);
                    } else {
                        do {
                            try {
                                if (toppings.size() == 4) {
                                    throw new LimiteToppingsException("Máximo de 4 toppings alcanzado.");
                                }
                                do {
                                    System.out.println("Escoja los toppings (hasta 4): ");
                                    System.out.println("· Jamón");
                                    System.out.println("· Piña");
                                    System.out.println("· Pepperoni");
                                    System.out.println("· Carne picada");
                                    System.out.println("· Cuatro quesos");
                                    System.out.println("· Salchichas");
                                    topping = scanner.nextLine();
                                } while(!topping.equalsIgnoreCase("jamón")&&
                                        !topping.equalsIgnoreCase("piña")&&
                                        !topping.equalsIgnoreCase("pepperoni")&&
                                        !topping.equalsIgnoreCase("carne picada")&&
                                        !topping.equalsIgnoreCase("cuatro quesos")&&
                                        !topping.equalsIgnoreCase("salchichas"));
                                toppings.add(topping);

                                System.out.println("¿Desea agregar más toppings? (s/n)");
                                opcion = scanner.nextLine();

                            } catch (LimiteToppingsException e) {
                                System.out.println(e.getMessage());
                                opcion = "n";
                            }
                        } while (opcion.equalsIgnoreCase("s"));
                        Pizza pizza1 = new Pizza(size,precioPizza,toppings,salsa);
                        pedido.agregarProducto(pizza1);
                    }
                    break;
                case 2:
                    String bebida;
                    double precioBebida = 0;
                    do {
                        System.out.println("\n---MENÚ BEBIDAS---");
                        System.out.println("· Coca Cola --> 1,90€");
                        System.out.println("· Fanta --> 1,50€");
                        System.out.println("· Agua --> 1,00€");
                        System.out.println("· Nestea --> 1,30€");
                        bebida = scanner.nextLine();
                    } while(!bebida.equalsIgnoreCase("coca cola") &&
                        !bebida.equalsIgnoreCase("fanta") &&
                        !bebida.equalsIgnoreCase("agua") &&
                        !bebida.equalsIgnoreCase("nestea"));

                    switch (bebida.toLowerCase()){
                        case "coca cola":
                            precioBebida = 1.90;
                            break;
                        case "fanta":
                            precioBebida = 1.50;
                            break;
                        case "agua":
                            precioBebida = 1.00;
                            break;
                        case "nestea":
                            precioBebida = 1.30;
                            break;
                    }
                    Bebida bebida1 = new Bebida(bebida,precioBebida);
                    pedido.agregarProducto(bebida1);
                    break;
                case 3:
                    double precioAdi = 0;
                    String adicional = "";
                    do {
                        System.out.println("---MENÚ COMPLEMENTOS---");
                        System.out.println("· Patatas fritas --> 2,50€");
                        System.out.println("· Bolas de queso --> 1,85€");
                        System.out.println("· Nuggets --> 1,70€");
                        System.out.println("· Empanadillas de carne --> 3,50€");
                        adicional = scanner.nextLine();
                    } while(!adicional.equalsIgnoreCase("patatas fritas")&&
                            !adicional.equalsIgnoreCase("bolas de queso")&&
                            !adicional.equalsIgnoreCase("nuggets")&&
                            !adicional.equalsIgnoreCase("empanadillas de carne"));
                    switch (adicional.toLowerCase()){
                        case "patatas fritas":
                            precioAdi = 2.50;
                            break;
                        case "bolas de queso":
                            precioAdi = 1.85;
                            break;
                        case "nuggets":
                            precioAdi = 1.70;
                            break;
                        case "empanadillas de carne":
                            precioAdi = 3.50;
                            break;
                    }
                    Extras extras = new Extras(adicional,precioAdi);
                    pedido.agregarProducto(extras);
                    break;
                case 0:
                    System.out.println("Has salido.");
                    break;
            }
        } while (menu != 0);

        pedido.calcularTotal();
        GuardarRecibo.escribir(fichero,pedido);
        LeerRecibo.leer(fichero);
    }
}
