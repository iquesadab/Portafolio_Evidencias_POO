package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.tl.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {

    // Se utiliza para leer los datos ingresados por el usuario
    public static BufferedReader leerTexto =
            new BufferedReader(new InputStreamReader(System.in));


    // Muestra el menú principal del sistema
    public static void menuPrincipal() throws Exception {

        byte seleccion;

        do {

            System.out.println("\n==============================");
            System.out.println("   SISTEMA DEL RESTAURANTE");
            System.out.println("==============================");

            System.out.println("1. Registrar restaurante");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Registrar mesa");
            System.out.println("4. Registrar mesero");
            System.out.println("5. Registrar plato");
            System.out.println("6. Registrar pedido");
            System.out.println("7. Registrar factura");
            System.out.println("8. Listar información");
            System.out.println("9. Modificar información");
            System.out.println("10. Eliminar información");
            System.out.println("0. Salir");

            System.out.print("\nSeleccione una opción: ");

            try {

                seleccion =
                        Byte.parseByte(leerTexto.readLine());

                // Se envía la opción seleccionada al Controller
                Controller.procesarSeleccionPrincipal(seleccion);

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nDebe ingresar un número válido."
                );

                seleccion = -1;
            }

        } while (seleccion != 0);
    }


    // Muestra el menú para listar la información registrada
    public static void menuListar() throws Exception {

        byte seleccion;

        do {

            System.out.println("\n==============================");
            System.out.println("       LISTAR INFORMACIÓN");
            System.out.println("==============================");

            System.out.println("1. Restaurantes");
            System.out.println("2. Clientes");
            System.out.println("3. Mesas");
            System.out.println("4. Meseros");
            System.out.println("5. Platos");
            System.out.println("6. Pedidos");
            System.out.println("7. Facturas");
            System.out.println("0. Regresar");

            System.out.print("\nSeleccione una opción: ");

            try {

                seleccion =
                        Byte.parseByte(leerTexto.readLine());

                // Se envía la opción al Controller
                Controller.procesarListar(seleccion);

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nDebe ingresar un número válido."
                );

                seleccion = -1;
            }

        } while (seleccion != 0);
    }


    // Muestra el menú para modificar la información
    public static void menuModificar() throws Exception {

        byte seleccion;

        do {

            System.out.println("\n==============================");
            System.out.println("     MODIFICAR INFORMACIÓN");
            System.out.println("==============================");

            System.out.println("1. Restaurante");
            System.out.println("2. Cliente");
            System.out.println("3. Mesa");
            System.out.println("4. Mesero");
            System.out.println("5. Plato");
            System.out.println("0. Regresar");

            System.out.print("\nSeleccione una opción: ");

            try {

                seleccion =
                        Byte.parseByte(leerTexto.readLine());

                // Se envía la opción seleccionada al Controller
                Controller.procesarModificar(seleccion);

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nDebe ingresar un número válido."
                );

                seleccion = -1;
            }

        } while (seleccion != 0);
    }


    // Muestra el menú para eliminar información
    public static void menuEliminar() throws Exception {

        byte seleccion;

        do {

            System.out.println("\n==============================");
            System.out.println("      ELIMINAR INFORMACIÓN");
            System.out.println("==============================");

            System.out.println("1. Restaurante");
            System.out.println("2. Cliente");
            System.out.println("3. Mesa");
            System.out.println("4. Mesero");
            System.out.println("5. Plato");
            System.out.println("6. Factura");
            System.out.println("7. Pedido");
            System.out.println("0. Regresar");

            System.out.print("\nSeleccione una opción: ");

            try {

                seleccion =
                        Byte.parseByte(leerTexto.readLine());

                // Se envía la opción seleccionada al Controller
                Controller.procesarEliminar(seleccion);

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nDebe ingresar un número válido."
                );

                seleccion = -1;
            }

        } while (seleccion != 0);
    }
}
