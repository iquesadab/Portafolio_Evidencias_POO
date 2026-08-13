package cr.ac.ucenfotec.bl.entities.pedido;

import cr.ac.ucenfotec.dl.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOPedido {

    // Variables que almacenan las instrucciones SQL
    private static String statement;
    private static String query;

    // Inserta un pedido en la base de datos
    public static String insertarPedido(Pedido pedidoInsertar, int idCliente) throws Exception {

        // Se crea la instrucción SQL con los datos del pedido
        // y el ID del cliente al que pertenece
        statement = "INSERT INTO t_pedidos(codigo, cantidad_platos, id_cliente) VALUES ('"
                + pedidoInsertar.getCodigo() + "', "
                + pedidoInsertar.getCantidadPlatos() + ", "
                + idCliente + ");";

        // Se ejecuta la instrucción en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "El pedido se registró en la base de datos correctamente.\n";
    }

    // Obtiene todos los pedidos registrados
    public static ArrayList<Pedido> listarPedidos() throws Exception {

        // Se crea una lista para almacenar los pedidos encontrados
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        // Se consultan todos los registros de la tabla pedidos
        query = "SELECT * FROM t_pedidos;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren todos los registros encontrados
        do {

            // Se obtiene la cantidad de platos registrada
            byte cantidadPlatos = resultado.getByte("cantidad_platos");

            // Se utiliza al menos una posición para poder crear el arreglo del pedido
            if (cantidadPlatos == 0) {
                cantidadPlatos = 1;
            }

            // Se crea un objeto Pedido con los datos obtenidos
            Pedido pedidoTemp = new Pedido(
                    resultado.getString("codigo"),
                    cantidadPlatos
            );

            // Se agrega el pedido a la lista
            listaPedidos.add(pedidoTemp);

        } while (resultado.next());

        // Se retorna la lista de pedidos
        return listaPedidos;
    }

    // Obtiene los ID de todos los pedidos registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se crea una lista para almacenar los ID
        ArrayList<Integer> listaIDs = new ArrayList<>();

        // Se consultan todos los pedidos
        query = "SELECT * FROM t_pedidos;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren los resultados
        do {

            // Se obtiene el ID y se agrega a la lista
            listaIDs.add(resultado.getInt("id"));

        } while (resultado.next());

        // Se retorna la lista de ID
        return listaIDs;
    }

    // Obtiene los ID de los clientes registrados
    // Esto permite seleccionar un cliente al momento de crear un pedido
    public static ArrayList<Integer> listarIDsClientes() throws Exception {

        // Se crea una lista para almacenar los ID de los clientes
        ArrayList<Integer> listaIDsClientes = new ArrayList<>();

        // Se consultan todos los clientes
        query = "SELECT * FROM t_clientes;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen clientes se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren los resultados
        do {

            // Se agrega cada ID a la lista
            listaIDsClientes.add(resultado.getInt("id"));

        } while (resultado.next());

        // Se retorna la lista de ID de clientes
        return listaIDsClientes;
    }

    // Modifica un pedido existente utilizando su ID
    public static String modificarPedido(int idPedido,
                                         Pedido pedidoModificar,
                                         int idCliente) throws Exception {

        // Se crea la instrucción SQL con los nuevos datos
        statement = "UPDATE t_pedidos SET "
                + "codigo = '" + pedidoModificar.getCodigo() + "', "
                + "cantidad_platos = " + pedidoModificar.getCantidadPlatos() + ", "
                + "id_cliente = " + idCliente
                + " WHERE id = " + idPedido + ";";

        // Se ejecuta la modificación
        Connector.getConnection().ejecutarStatement(statement);

        return "El pedido se modificó en la base de datos correctamente.";
    }

    // Elimina un pedido utilizando su ID
    public static String eliminarPedido(int idPedido) throws Exception {

        // Se crea la instrucción SQL para eliminar el pedido
        statement = "DELETE FROM t_pedidos WHERE id = " + idPedido + ";";

        // Se ejecuta la instrucción
        Connector.getConnection().ejecutarStatement(statement);

        return "El pedido se eliminó de la base de datos correctamente (si existía).";
    }
}
