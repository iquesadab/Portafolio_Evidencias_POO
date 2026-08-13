package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.cliente.Cliente;
import cr.ac.ucenfotec.bl.entities.factura.Factura;
import cr.ac.ucenfotec.bl.entities.mesa.Mesa;
import cr.ac.ucenfotec.bl.entities.mesero.Mesero;
import cr.ac.ucenfotec.bl.entities.pedido.Pedido;
import cr.ac.ucenfotec.bl.entities.plato.Plato;
import cr.ac.ucenfotec.bl.entities.restaurante.Restaurante;
import cr.ac.ucenfotec.bl.logic.*;
import cr.ac.ucenfotec.ui.Menu;

import java.util.ArrayList;

public class Controller {

    // Procesa la opción seleccionada en el menú principal
    public static void procesarSeleccionPrincipal(byte seleccion) throws Exception {

        switch (seleccion) {

            case 1:
                agregarRestaurante();
                break;

            case 2:
                agregarCliente();
                break;

            case 3:
                agregarMesa();
                break;

            case 4:
                agregarMesero();
                break;

            case 5:
                agregarPlato();
                break;

            case 6:
                agregarPedido();
                break;

            case 7:
                agregarFactura();
                break;

            case 8:
                Menu.menuListar();
                break;

            case 9:
                Menu.menuModificar();
                break;

            case 10:
                Menu.menuEliminar();
                break;

            case 0:
                System.out.println("\nGracias por utilizar el sistema.");
                break;

            default:
                System.out.println("\nLa opción ingresada no es válida.");
        }
    }


    // =========================
    // AGREGAR
    // =========================

    // Solicita los datos para registrar un restaurante
    public static void agregarRestaurante() throws Exception {

        System.out.println("\n--- REGISTRAR RESTAURANTE ---");

        System.out.print("Ingrese el nombre del restaurante: ");
        String nombre = Menu.leerTexto.readLine();

        // Se envían los datos al gestor
        System.out.println(
                GestorRestaurante.agregarRestaurante(nombre)
        );
    }


    // Solicita los datos para registrar un cliente
    public static void agregarCliente() throws Exception {

        System.out.println("\n--- REGISTRAR CLIENTE ---");

        System.out.print("Ingrese el nombre: ");
        String nombre = Menu.leerTexto.readLine();

        System.out.print("Ingrese los apellidos: ");
        String apellidos = Menu.leerTexto.readLine();

        // Se envían los datos al gestor
        System.out.println(
                GestorCliente.agregarCliente(nombre, apellidos)
        );
    }


    // Solicita los datos para registrar una mesa
    public static void agregarMesa() throws Exception {

        System.out.println("\n--- REGISTRAR MESA ---");

        try {

            System.out.print("Ingrese el número de la mesa: ");
            byte numero = Byte.parseByte(Menu.leerTexto.readLine());

            System.out.print("Ingrese la capacidad de la mesa: ");
            byte capacidad = Byte.parseByte(Menu.leerTexto.readLine());

            // Se valida que los valores sean mayores que cero
            if (numero <= 0 || capacidad <= 0) {

                System.out.println(
                        "El número y la capacidad deben ser mayores que 0."
                );

                return;
            }

            // Se envían los datos al gestor
            System.out.println(
                    GestorMesa.agregarMesa(numero, capacidad)
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "El formato del dato ingresado no es válido."
            );
        }
    }


    // Solicita los datos para registrar un mesero
    public static void agregarMesero() throws Exception {

        System.out.println("\n--- REGISTRAR MESERO ---");

        try {

            System.out.print("Ingrese el nombre: ");
            String nombre = Menu.leerTexto.readLine();

            System.out.print("Ingrese los apellidos: ");
            String apellidos = Menu.leerTexto.readLine();

            System.out.print("Ingrese los años de experiencia: ");
            byte experiencia =
                    Byte.parseByte(Menu.leerTexto.readLine());

            if (experiencia < 0) {

                System.out.println(
                        "La experiencia no puede ser menor que 0."
                );

                return;
            }

            // Se envían los datos al gestor
            System.out.println(
                    GestorMesero.agregarMesero(
                            nombre,
                            apellidos,
                            experiencia
                    )
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "El formato del dato ingresado no es válido."
            );
        }
    }


    // Solicita los datos para registrar un plato
    public static void agregarPlato() throws Exception {

        System.out.println("\n--- REGISTRAR PLATO ---");

        try {

            System.out.print("Ingrese el nombre del plato: ");
            String nombre = Menu.leerTexto.readLine();

            System.out.print("Ingrese la categoría: ");
            String categoria = Menu.leerTexto.readLine();

            System.out.print("Ingrese el precio: ");
            float precio =
                    Float.parseFloat(Menu.leerTexto.readLine());

            if (precio <= 0) {

                System.out.println(
                        "El precio debe ser mayor que 0."
                );

                return;
            }

            // Se envían los datos al gestor
            System.out.println(
                    GestorPlato.agregarPlato(
                            nombre,
                            categoria,
                            precio
                    )
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "El formato del dato ingresado no es válido."
            );
        }
    }


    // Solicita los datos para registrar un pedido
    public static void agregarPedido() throws Exception {

        System.out.println("\n--- REGISTRAR PEDIDO ---");

        // Se obtienen los ID de los clientes registrados
        ArrayList<Integer> listaIDs =
                GestorPedido.listarIDsClientes();

        if (listaIDs == null) {

            System.out.println(
                    "No existen clientes registrados. " +
                            "Debe registrar un cliente primero."
            );

            return;
        }

        // Se muestran los ID disponibles
        System.out.println("ID de clientes disponibles: "
                + listaIDs);

        try {

            System.out.print("Ingrese el código del pedido: ");
            String codigo = Menu.leerTexto.readLine();

            System.out.print(
                    "Ingrese la cantidad máxima de platos: "
            );

            byte cantidadMaximaPlatos =
                    Byte.parseByte(Menu.leerTexto.readLine());

            System.out.print(
                    "Ingrese el ID del cliente: "
            );

            int idCliente =
                    Integer.parseInt(Menu.leerTexto.readLine());

            if (cantidadMaximaPlatos <= 0) {

                System.out.println(
                        "La cantidad de platos debe ser mayor que 0."
                );

                return;
            }

            // Se envían los datos al gestor
            System.out.println(
                    GestorPedido.agregarPedido(
                            codigo,
                            cantidadMaximaPlatos,
                            idCliente
                    )
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "El formato del dato ingresado no es válido."
            );
        }
    }


    // Solicita los datos para registrar una factura
    public static void agregarFactura() throws Exception {

        System.out.println("\n--- REGISTRAR FACTURA ---");

        // Se obtienen los ID de pedidos existentes
        ArrayList<Integer> listaIDs =
                GestorFactura.listarIDsPedidos();

        if (listaIDs == null) {

            System.out.println(
                    "No existen pedidos registrados. " +
                            "Debe registrar un pedido primero."
            );

            return;
        }

        System.out.println(
                "ID de pedidos disponibles: " + listaIDs
        );

        try {

            System.out.print(
                    "Ingrese el número de factura: "
            );

            String numero =
                    Menu.leerTexto.readLine();

            System.out.print(
                    "Ingrese el método de pago: "
            );

            String metodoPago =
                    Menu.leerTexto.readLine();

            System.out.print(
                    "Ingrese el total de la factura: "
            );

            float total =
                    Float.parseFloat(Menu.leerTexto.readLine());

            System.out.print(
                    "Ingrese el ID del pedido: "
            );

            int idPedido =
                    Integer.parseInt(Menu.leerTexto.readLine());

            if (total < 0) {

                System.out.println(
                        "El total no puede ser menor que 0."
                );

                return;
            }

            // Se envían los datos al gestor
            System.out.println(
                    GestorFactura.agregarFactura(
                            numero,
                            metodoPago,
                            total,
                            idPedido
                    )
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "El formato del dato ingresado no es válido."
            );
        }
    }


    // =========================
    // LISTAR
    // =========================

    // Procesa la opción seleccionada en el menú de listar
    public static void procesarListar(byte seleccion)
            throws Exception {

        switch (seleccion) {

            case 1:
                listarRestaurantes();
                break;

            case 2:
                listarClientes();
                break;

            case 3:
                listarMesas();
                break;

            case 4:
                listarMeseros();
                break;

            case 5:
                listarPlatos();
                break;

            case 6:
                listarPedidos();
                break;

            case 7:
                listarFacturas();
                break;

            case 0:
                System.out.println(
                        "Regresando al menú principal..."
                );
                break;

            default:
                System.out.println(
                        "La selección realizada no es válida."
                );
        }
    }


    // Muestra todos los restaurantes registrados
    public static void listarRestaurantes() throws Exception {

        ArrayList<Restaurante> lista =
                GestorRestaurante.listarRestaurantes();

        if (lista == null) {

            System.out.println(
                    "No existen restaurantes registrados."
            );

            return;
        }

        System.out.println("\n--- RESTAURANTES ---");

        for (Restaurante restaurante : lista) {

            System.out.println(
                    "Nombre: "
                            + restaurante.getNombre()
            );
        }
    }


    // Muestra todos los clientes registrados
    public static void listarClientes() throws Exception {

        ArrayList<Cliente> lista =
                GestorCliente.listarClientes();

        if (lista == null) {

            System.out.println(
                    "No existen clientes registrados."
            );

            return;
        }

        System.out.println("\n--- CLIENTES ---");

        for (Cliente cliente : lista) {

            System.out.println(
                    "Nombre: "
                            + cliente.getNombre()
                            + " "
                            + cliente.getApellidos()
            );
        }
    }


    // Muestra todas las mesas registradas
    public static void listarMesas() throws Exception {

        ArrayList<Mesa> lista =
                GestorMesa.listarMesas();

        if (lista == null) {

            System.out.println(
                    "No existen mesas registradas."
            );

            return;
        }

        System.out.println("\n--- MESAS ---");

        for (Mesa mesa : lista) {

            System.out.println(
                    "Mesa: " + mesa.getNumero()
                            + " | Capacidad: "
                            + mesa.getCapacidad()
                            + " | Disponible: "
                            + mesa.isDisponible()
            );
        }
    }


    // Muestra todos los meseros registrados
    public static void listarMeseros() throws Exception {

        ArrayList<Mesero> lista =
                GestorMesero.listarMeseros();

        if (lista == null) {

            System.out.println(
                    "No existen meseros registrados."
            );

            return;
        }

        System.out.println("\n--- MESEROS ---");

        for (Mesero mesero : lista) {

            System.out.println(
                    "Nombre: "
                            + mesero.getNombre()
                            + " "
                            + mesero.getApellidos()
                            + " | Experiencia: "
                            + mesero.getExperiencia()
                            + " años"
            );
        }
    }


    // Muestra todos los platos registrados
    public static void listarPlatos() throws Exception {

        ArrayList<Plato> lista =
                GestorPlato.listarPlatos();

        if (lista == null) {

            System.out.println(
                    "No existen platos registrados."
            );

            return;
        }

        System.out.println("\n--- PLATOS ---");

        for (Plato plato : lista) {

            System.out.println(
                    "Nombre: "
                            + plato.getNombre()
                            + " | Categoría: "
                            + plato.getCategoria()
                            + " | Precio: ₡"
                            + plato.getPrecio()
            );
        }
    }


    // Muestra todos los pedidos registrados
    public static void listarPedidos() throws Exception {

        ArrayList<Pedido> lista =
                GestorPedido.listarPedidos();

        if (lista == null) {

            System.out.println(
                    "No existen pedidos registrados."
            );

            return;
        }

        System.out.println("\n--- PEDIDOS ---");

        for (Pedido pedido : lista) {

            System.out.println(
                    "Código: "
                            + pedido.getCodigo()
                            + " | Cantidad de platos: "
                            + pedido.getCantidadPlatos()
            );
        }
    }


    // Muestra todas las facturas registradas
    public static void listarFacturas() throws Exception {

        ArrayList<Factura> lista =
                GestorFactura.listarFacturas();

        if (lista == null) {

            System.out.println(
                    "No existen facturas registradas."
            );

            return;
        }

        System.out.println("\n--- FACTURAS ---");

        for (Factura factura : lista) {

            System.out.println(
                    "Número: "
                            + factura.getNumero()
                            + " | Método de pago: "
                            + factura.getMetodoPago()
                            + " | Total: ₡"
                            + factura.getTotal()
                            + " | Pagada: "
                            + factura.isPagada()
            );
        }
    }


    // =========================
    // MODIFICAR
    // =========================

    // Procesa la opción seleccionada en el menú modificar
    public static void procesarModificar(byte seleccion)
            throws Exception {

        switch (seleccion) {

            case 1:
                modificarRestaurante();
                break;

            case 2:
                modificarCliente();
                break;

            case 3:
                modificarMesa();
                break;

            case 4:
                modificarMesero();
                break;

            case 5:
                modificarPlato();
                break;

            case 0:
                break;

            default:
                System.out.println(
                        "La selección realizada no es válida."
                );
        }
    }


    public static void modificarRestaurante()
            throws Exception {

        System.out.println(
                "ID disponibles: "
                        + GestorRestaurante.listarIDs()
        );

        System.out.print(
                "Ingrese el ID del restaurante: "
        );

        int id =
                Integer.parseInt(Menu.leerTexto.readLine());

        System.out.print(
                "Ingrese el nuevo nombre: "
        );

        String nombre =
                Menu.leerTexto.readLine();

        System.out.println(
                GestorRestaurante.modificarRestaurante(
                        id,
                        nombre
                )
        );
    }


    public static void modificarCliente()
            throws Exception {

        System.out.println(
                "ID disponibles: "
                        + GestorCliente.listarIDs()
        );

        System.out.print(
                "Ingrese el ID del cliente: "
        );

        int id =
                Integer.parseInt(Menu.leerTexto.readLine());

        System.out.print(
                "Ingrese el nuevo nombre: "
        );

        String nombre =
                Menu.leerTexto.readLine();

        System.out.print(
                "Ingrese los nuevos apellidos: "
        );

        String apellidos =
                Menu.leerTexto.readLine();

        System.out.println(
                GestorCliente.modificarCliente(
                        id,
                        nombre,
                        apellidos
                )
        );
    }


    public static void modificarMesa()
            throws Exception {

        System.out.println(
                "ID disponibles: "
                        + GestorMesa.listarIDs()
        );

        System.out.print(
                "Ingrese el ID de la mesa: "
        );

        int id =
                Integer.parseInt(Menu.leerTexto.readLine());

        System.out.print(
                "Ingrese el nuevo número: "
        );

        byte numero =
                Byte.parseByte(Menu.leerTexto.readLine());

        System.out.print(
                "Ingrese la nueva capacidad: "
        );

        byte capacidad =
                Byte.parseByte(Menu.leerTexto.readLine());

        System.out.print(
                "¿La mesa está disponible? (true/false): "
        );

        boolean disponible =
                Boolean.parseBoolean(
                        Menu.leerTexto.readLine()
                );

        System.out.println(
                GestorMesa.modificarMesa(
                        id,
                        numero,
                        capacidad,
                        disponible
                )
        );
    }


    public static void modificarMesero()
            throws Exception {

        System.out.println(
                "ID disponibles: "
                        + GestorMesero.listarIDs()
        );

        System.out.print(
                "Ingrese el ID del mesero: "
        );

        int id =
                Integer.parseInt(Menu.leerTexto.readLine());

        System.out.print(
                "Ingrese el nuevo nombre: "
        );

        String nombre =
                Menu.leerTexto.readLine();

        System.out.print(
                "Ingrese los nuevos apellidos: "
        );

        String apellidos =
                Menu.leerTexto.readLine();

        System.out.print(
                "Ingrese los años de experiencia: "
        );

        byte experiencia =
                Byte.parseByte(Menu.leerTexto.readLine());

        System.out.println(
                GestorMesero.modificarMesero(
                        id,
                        nombre,
                        apellidos,
                        experiencia
                )
        );
    }


    public static void modificarPlato()
            throws Exception {

        System.out.println(
                "ID disponibles: "
                        + GestorPlato.listarIDs()
        );

        System.out.print(
                "Ingrese el ID del plato: "
        );

        int id =
                Integer.parseInt(Menu.leerTexto.readLine());

        System.out.print(
                "Ingrese el nuevo nombre: "
        );

        String nombre =
                Menu.leerTexto.readLine();

        System.out.print(
                "Ingrese la nueva categoría: "
        );

        String categoria =
                Menu.leerTexto.readLine();

        System.out.print(
                "Ingrese el nuevo precio: "
        );

        float precio =
                Float.parseFloat(Menu.leerTexto.readLine());

        System.out.println(
                GestorPlato.modificarPlato(
                        id,
                        nombre,
                        categoria,
                        precio
                )
        );
    }


    // =========================
    // ELIMINAR
    // =========================

    // Procesa la opción seleccionada en el menú eliminar
    public static void procesarEliminar(byte seleccion)
            throws Exception {

        if (seleccion == 0) {
            return;
        }

        int id;

        switch (seleccion) {

            case 1:

                System.out.println(
                        "ID disponibles: "
                                + GestorRestaurante.listarIDs()
                );

                System.out.print(
                        "Ingrese el ID del restaurante: "
                );

                id = Integer.parseInt(
                        Menu.leerTexto.readLine()
                );

                System.out.println(
                        GestorRestaurante
                                .eliminarRestaurante(id)
                );

                break;


            case 2:

                System.out.println(
                        "ID disponibles: "
                                + GestorCliente.listarIDs()
                );

                System.out.print(
                        "Ingrese el ID del cliente: "
                );

                id = Integer.parseInt(
                        Menu.leerTexto.readLine()
                );

                System.out.println(
                        GestorCliente.eliminarCliente(id)
                );

                break;


            case 3:

                System.out.println(
                        "ID disponibles: "
                                + GestorMesa.listarIDs()
                );

                System.out.print(
                        "Ingrese el ID de la mesa: "
                );

                id = Integer.parseInt(
                        Menu.leerTexto.readLine()
                );

                System.out.println(
                        GestorMesa.eliminarMesa(id)
                );

                break;


            case 4:

                System.out.println(
                        "ID disponibles: "
                                + GestorMesero.listarIDs()
                );

                System.out.print(
                        "Ingrese el ID del mesero: "
                );

                id = Integer.parseInt(
                        Menu.leerTexto.readLine()
                );

                System.out.println(
                        GestorMesero.eliminarMesero(id)
                );

                break;


            case 5:

                System.out.println(
                        "ID disponibles: "
                                + GestorPlato.listarIDs()
                );

                System.out.print(
                        "Ingrese el ID del plato: "
                );

                id = Integer.parseInt(
                        Menu.leerTexto.readLine()
                );

                System.out.println(
                        GestorPlato.eliminarPlato(id)
                );

                break;


            case 6:

                System.out.println(
                        "ID disponibles: "
                                + GestorFactura.listarIDs()
                );

                System.out.print(
                        "Ingrese el ID de la factura: "
                );

                id = Integer.parseInt(
                        Menu.leerTexto.readLine()
                );

                System.out.println(
                        GestorFactura.eliminarFactura(id)
                );

                break;


            case 7:

                System.out.println(
                        "ID disponibles: "
                                + GestorPedido.listarIDs()
                );

                System.out.print(
                        "Ingrese el ID del pedido: "
                );

                id = Integer.parseInt(
                        Menu.leerTexto.readLine()
                );

                System.out.println(
                        GestorPedido.eliminarPedido(id)
                );

                break;


            default:

                System.out.println(
                        "La selección realizada no es válida."
                );
        }
    }
}