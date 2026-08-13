package cr.ac.ucenfotec.bl.entities.restaurante;

import cr.ac.ucenfotec.dl.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAORestaurante {

    // Variables que almacenan las instrucciones SQL
    private static String statement;
    private static String query;

    // Inserta un restaurante en la base de datos
    public static String insertarRestaurante(Restaurante restauranteInsertar) throws Exception {

        // Se crea la instrucción SQL con el nombre del restaurante
        statement = "INSERT INTO t_restaurantes(nombre) VALUES ('"
                + restauranteInsertar.getNombre() + "');";

        // Se ejecuta la instrucción en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "El restaurante se registró en la base de datos correctamente.\n";
    }

    // Obtiene todos los restaurantes registrados
    public static ArrayList<Restaurante> listarRestaurantes() throws Exception {

        // Se crea una lista para almacenar los restaurantes encontrados
        ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();

        // Se consultan todos los registros de la tabla
        query = "SELECT * FROM t_restaurantes;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren todos los registros encontrados
        do {

            /*
             * Para recuperar el restaurante desde la base de datos
             * se utiliza el nombre guardado.
             *
             * Los tamaños se colocan en 0 porque las mesas, meseros
             * y platos se administran por separado en sus propias tablas.
             */
            Restaurante restauranteTemp = new Restaurante(
                    resultado.getString("nombre"),
                    (byte) 0,
                    (byte) 0,
                    (byte) 0
            );

            // Se agrega el restaurante a la lista
            listaRestaurantes.add(restauranteTemp);

        } while (resultado.next());

        // Se retorna la lista de restaurantes
        return listaRestaurantes;
    }

    // Obtiene los ID de todos los restaurantes registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se crea una lista para almacenar los ID
        ArrayList<Integer> listaIDs = new ArrayList<>();

        // Se consultan todos los restaurantes
        query = "SELECT * FROM t_restaurantes;";

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

    // Modifica el nombre de un restaurante utilizando su ID
    public static String modificarRestaurante(int idRestaurante,
                                              Restaurante restauranteModificar) throws Exception {

        // Se crea la instrucción SQL con el nuevo nombre
        statement = "UPDATE t_restaurantes SET "
                + "nombre = '" + restauranteModificar.getNombre() + "' "
                + "WHERE id = " + idRestaurante + ";";

        // Se ejecuta la modificación
        Connector.getConnection().ejecutarStatement(statement);

        return "El restaurante se modificó en la base de datos correctamente.";
    }

    // Elimina un restaurante utilizando su ID
    public static String eliminarRestaurante(int idRestaurante) throws Exception {

        // Se crea la instrucción SQL para eliminar el restaurante
        statement = "DELETE FROM t_restaurantes WHERE id = " + idRestaurante + ";";

        // Se ejecuta la instrucción
        Connector.getConnection().ejecutarStatement(statement);

        return "El restaurante se eliminó de la base de datos correctamente (si existía).";
    }
}
