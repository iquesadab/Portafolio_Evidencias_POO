public class Main {

    public static void main(String[] args) {

        // Creación del restaurante
        Restaurante restaurante = new Restaurante("Restaurante El Buen Sabor", (byte)5, (byte)2, (byte)5);

        // Creación de mesas
        Mesa mesa1 = new Mesa((byte)1, (byte)4);
        Mesa mesa2 = new Mesa((byte)2, (byte)6);

        // Registro de mesas
        restaurante.registrarMesa(mesa1);
        restaurante.registrarMesa(mesa2);

        // Creación de platos
        Plato plato1 = new Plato("Casado", "Almuerzo", 3500);
        Plato plato2 = new Plato("Pizza", "Cena", 5500);
        Plato plato3 = new Plato("Hamburguesa", "Comida Rápida", 4200);

        // Registro de platos
        restaurante.registrarPlato(plato1);
        restaurante.registrarPlato(plato2);
        restaurante.registrarPlato(plato3);

        // Mostrar menú
        restaurante.mostrarMenu();

        // Creación del mesero
        Mesero mesero = new Mesero("Luis", "Ramírez", (byte)5);

        // Registro del mesero
        restaurante.registrarMesero(mesero);

        // Creación de 2 clientes
        Cliente cliente1 = new Cliente("Amanda", "Álvarez");
        Cliente cliente2 = new Cliente("Samuel", "Bogantes");

        // Cliente 1 ocupa una mesa
        cliente1.ocuparMesa(mesa1);

        // Cliente 2 ocupa otra mesa
        cliente2.ocuparMesa(mesa2);

        // Cliente 1 crea su pedido
        cliente1.crearPedido("P001", (byte)5);

        // Cliente 2 crea su pedido
        cliente2.crearPedido("P002", (byte)5);

        // Cliente 1 agrega platos a su pedido
        cliente1.getPedido().agregarPlato(plato1);
        cliente1.getPedido().agregarPlato(plato2);

        // Cliente 2 agrega platos a su pedido
        cliente2.getPedido().agregarPlato(plato2);
        cliente2.getPedido().agregarPlato(plato3);

        // Cliente 1 genera su factura
        cliente1.getPedido().generarFactura("F001", "Tarjeta");

        // Cliente 2 genera su factura
        cliente2.getPedido().generarFactura("F002", "Efectivo");

        // El mesero sirve ambos pedidos
        mesero.servirPedido(cliente1.getPedido());
        mesero.servirPedido(cliente2.getPedido());

        // Pago de las facturas
        cliente1.getPedido().getFactura().pagarFactura();
        cliente2.getPedido().getFactura().pagarFactura();

        // Mostrar totales
        System.out.println("\nTotal de la factura de " + cliente1.getNombre() + ": ₡" +
                cliente1.getPedido().getFactura().getTotal());

        System.out.println("Total de la factura de " + cliente2.getNombre() + ": ₡" +
                cliente2.getPedido().getFactura().getTotal());
    }
}
