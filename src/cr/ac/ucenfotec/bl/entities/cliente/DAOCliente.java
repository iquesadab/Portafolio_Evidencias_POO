package cr.ac.ucenfotec.bl.entities.cliente;

import cr.ac.ucenfotec.dl.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOCliente {

    // Variables que almacenan las instrucciones SQL
    private static String statement;
    private static String query;

    // Inserta un cliente en la base de datos
    public static String insertarCliente(Cliente clienteInsertar) throws Exception {

        // Se crea la instrucción SQL con los datos del cliente
        statement = "INSERT INTO t_clientes(nombre, apellidos) VALUES ('"
                + clienteInsertar.getNombre() + "', '"
                + clienteInsertar.getApellidos() + "');";

        // Se ejecuta la instrucción en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "El cliente se registró en la base de datos correctamente.\n";
    }

    // Obtiene todos los clientes registrados
    public static ArrayList<Cliente> listarClientes() throws Exception {

        // Se crea una lista para guardar los clientes encontrados
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        // Consulta todos los registros de la tabla clientes
        query = "SELECT * FROM t_clientes;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no hay registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren todos los registros encontrados
        do {

            // Se crea un objeto Cliente con los datos obtenidos
            Cliente clienteTemp = new Cliente(
                    resultado.getString("nombre"),
                    resultado.getString("apellidos")
            );

            // Se agrega el cliente a la lista
            listaClientes.add(clienteTemp);

        } while (resultado.next());

        // Se retorna la lista de clientes
        return listaClientes;
    }

    // Obtiene los ID de todos los clientes registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se crea una lista para almacenar los ID
        ArrayList<Integer> listaIDs = new ArrayList<>();

        // Consulta todos los clientes
        query = "SELECT * FROM t_clientes;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no hay registros se retorna null
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

    // Modifica un cliente existente utilizando su ID
    public static String modificarCliente(int idCliente, Cliente clienteModificar) throws Exception {

        // Se crea la instrucción SQL con los nuevos datos
        statement = "UPDATE t_clientes SET "
                + "nombre = '" + clienteModificar.getNombre() + "', "
                + "apellidos = '" + clienteModificar.getApellidos() + "' "
                + "WHERE id = " + idCliente + ";";

        // Se ejecuta la modificación
        Connector.getConnection().ejecutarStatement(statement);

        return "El cliente se modificó en la base de datos correctamente.";
    }

    // Elimina un cliente utilizando su ID
    public static String eliminarCliente(int idCliente) throws Exception {

        // Se crea la instrucción SQL para eliminarlo
        statement = "DELETE FROM t_clientes WHERE id = " + idCliente + ";";

        // Se ejecuta la instrucción
        Connector.getConnection().ejecutarStatement(statement);

        return "El cliente se eliminó de la base de datos correctamente (si existía).";
    }
}
