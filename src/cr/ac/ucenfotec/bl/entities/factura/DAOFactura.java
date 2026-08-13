package cr.ac.ucenfotec.bl.entities.factura;

import cr.ac.ucenfotec.dl.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOFactura {

    // Variables que almacenan las instrucciones SQL
    private static String statement;
    private static String query;

    // Inserta una factura en la base de datos
    public static String insertarFactura(Factura facturaInsertar, int idPedido) throws Exception {

        // Se crea la instrucción SQL con los datos de la factura
        // y el ID del pedido al que pertenece
        statement = "INSERT INTO t_facturas(numero, metodo_pago, total, pagada, id_pedido) VALUES ('"
                + facturaInsertar.getNumero() + "', '"
                + facturaInsertar.getMetodoPago() + "', "
                + facturaInsertar.getTotal() + ", "
                + facturaInsertar.isPagada() + ", "
                + idPedido + ");";

        // Se ejecuta la instrucción en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "La factura se registró en la base de datos correctamente.\n";
    }

    // Obtiene todas las facturas registradas
    public static ArrayList<Factura> listarFacturas() throws Exception {

        // Se crea una lista para almacenar las facturas encontradas
        ArrayList<Factura> listaFacturas = new ArrayList<>();

        // Se consultan todos los registros de la tabla facturas
        query = "SELECT * FROM t_facturas;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren todos los registros encontrados
        do {

            // Se crea una factura con los datos obtenidos
            Factura facturaTemp = new Factura(
                    resultado.getString("numero"),
                    resultado.getString("metodo_pago"),
                    resultado.getFloat("total")
            );

            // Si la factura aparece pagada en la base de datos,
            // se actualiza su estado utilizando el método original de la clase
            if (resultado.getBoolean("pagada")) {
                facturaTemp.pagarFactura();
            }

            // Se agrega la factura a la lista
            listaFacturas.add(facturaTemp);

        } while (resultado.next());

        // Se retorna la lista de facturas
        return listaFacturas;
    }

    // Obtiene los ID de todas las facturas registradas
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se crea una lista para almacenar los ID
        ArrayList<Integer> listaIDs = new ArrayList<>();

        // Se consultan todas las facturas
        query = "SELECT * FROM t_facturas;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren todos los registros encontrados
        do {

            // Se obtiene el ID y se agrega a la lista
            listaIDs.add(resultado.getInt("id"));

        } while (resultado.next());

        // Se retorna la lista de ID
        return listaIDs;
    }

    // Obtiene los ID de los pedidos registrados
    // Esto permite seleccionar el pedido al crear una factura
    public static ArrayList<Integer> listarIDsPedidos() throws Exception {

        // Se crea una lista para almacenar los ID de pedidos
        ArrayList<Integer> listaIDsPedidos = new ArrayList<>();

        // Se consultan todos los pedidos
        query = "SELECT * FROM t_pedidos;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen pedidos se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren los resultados
        do {

            // Se agrega el ID de cada pedido
            listaIDsPedidos.add(resultado.getInt("id"));

        } while (resultado.next());

        // Se retorna la lista de ID
        return listaIDsPedidos;
    }

    // Modifica una factura existente utilizando su ID
    public static String modificarFactura(int idFactura,
                                          Factura facturaModificar,
                                          int idPedido) throws Exception {

        // Se crea la instrucción SQL con los nuevos datos
        statement = "UPDATE t_facturas SET "
                + "numero = '" + facturaModificar.getNumero() + "', "
                + "metodo_pago = '" + facturaModificar.getMetodoPago() + "', "
                + "total = " + facturaModificar.getTotal() + ", "
                + "pagada = " + facturaModificar.isPagada() + ", "
                + "id_pedido = " + idPedido
                + " WHERE id = " + idFactura + ";";

        // Se ejecuta la modificación
        Connector.getConnection().ejecutarStatement(statement);

        return "La factura se modificó en la base de datos correctamente.";
    }

    // Elimina una factura utilizando su ID
    public static String eliminarFactura(int idFactura) throws Exception {

        // Se crea la instrucción SQL para eliminar la factura
        statement = "DELETE FROM t_facturas WHERE id = " + idFactura + ";";

        // Se ejecuta la instrucción
        Connector.getConnection().ejecutarStatement(statement);

        return "La factura se eliminó de la base de datos correctamente (si existía).";
    }
}
