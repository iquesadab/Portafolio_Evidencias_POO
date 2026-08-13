package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.factura.DAOFactura;
import cr.ac.ucenfotec.bl.entities.factura.Factura;

import java.util.ArrayList;

public class GestorFactura {

    // Agrega una factura a la base de datos
    public static String agregarFactura(String numero,
                                        String metodoPago,
                                        float total,
                                        int idPedido) throws Exception {

        // Se crea un objeto Factura con los datos recibidos
        Factura facturaNueva = new Factura(numero, metodoPago, total);

        // Se envía la factura y el ID del pedido al DAO
        return DAOFactura.insertarFactura(facturaNueva, idPedido);
    }

    // Obtiene todas las facturas registradas
    public static ArrayList<Factura> listarFacturas() throws Exception {

        // Se solicita la lista de facturas al DAO
        return DAOFactura.listarFacturas();
    }

    // Obtiene los ID de todas las facturas registradas
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se solicita la lista de ID al DAO
        return DAOFactura.listarIDs();
    }

    // Obtiene los ID de los pedidos registrados
    public static ArrayList<Integer> listarIDsPedidos() throws Exception {

        // Se solicita al DAO la lista de pedidos disponibles
        return DAOFactura.listarIDsPedidos();
    }

    // Modifica una factura existente
    public static String modificarFactura(int idFactura,
                                          String numero,
                                          String metodoPago,
                                          float total,
                                          boolean pagada,
                                          int idPedido) throws Exception {

        // Se crea una factura con los nuevos datos
        Factura facturaModificar = new Factura(numero, metodoPago, total);

        // Si debe quedar pagada, se actualiza utilizando el método original
        if (pagada) {
            facturaModificar.pagarFactura();
        }

        // Se envía la factura y los ID correspondientes al DAO
        return DAOFactura.modificarFactura(
                idFactura,
                facturaModificar,
                idPedido
        );
    }

    // Elimina una factura utilizando su ID
    public static String eliminarFactura(int idFactura) throws Exception {

        // Se envía el ID al DAO para eliminar la factura
        return DAOFactura.eliminarFactura(idFactura);
    }
}