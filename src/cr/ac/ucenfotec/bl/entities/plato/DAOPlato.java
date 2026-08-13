package cr.ac.ucenfotec.bl.entities.plato;

import cr.ac.ucenfotec.dl.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOPlato {

    // Variables que almacenan las instrucciones SQL
    private static String statement;
    private static String query;

    // Inserta un plato en la base de datos
    public static String insertarPlato(Plato platoInsertar) throws Exception {

        // Se crea la instrucción SQL con los datos del plato recibido
        statement = "INSERT INTO t_platos(nombre, categoria, precio) VALUES ('"
                + platoInsertar.getNombre() + "', '"
                + platoInsertar.getCategoria() + "', "
                + platoInsertar.getPrecio() + ");";

        // Se ejecuta la instrucción en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "El plato se registró en la base de datos correctamente.\n";
    }

    // Obtiene todos los platos registrados en la base de datos
    public static ArrayList<Plato> listarPlatos() throws Exception {

        // Se crea un ArrayList para almacenar los platos encontrados
        ArrayList<Plato> listaPlatos = new ArrayList<>();

        // Consulta todos los registros de la tabla platos
        query = "SELECT * FROM t_platos;";

        // Se ejecuta la consulta y se guarda el resultado
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren todos los registros encontrados
        do {

            // Se crea un objeto Plato con los datos obtenidos de la base de datos
            Plato platoTemp = new Plato(
                    resultado.getString("nombre"),
                    resultado.getString("categoria"),
                    resultado.getFloat("precio")
            );

            // Se agrega el plato al ArrayList
            listaPlatos.add(platoTemp);

        } while (resultado.next());

        // Se retorna la lista de platos
        return listaPlatos;
    }

    // Obtiene los ID de todos los platos registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se crea un ArrayList para almacenar los ID
        ArrayList<Integer> listaIDs = new ArrayList<>();

        // Consulta todos los platos
        query = "SELECT * FROM t_platos;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren los resultados
        do {

            // Se obtiene el ID y se agrega al ArrayList
            listaIDs.add(resultado.getInt("id"));

        } while (resultado.next());

        // Se retorna la lista de ID
        return listaIDs;
    }

    // Modifica un plato existente utilizando su ID
    public static String modificarPlato(int idPlato, Plato platoModificar) throws Exception {

        // Se crea la instrucción SQL con los nuevos datos del plato
        statement = "UPDATE t_platos SET "
                + "nombre = '" + platoModificar.getNombre() + "', "
                + "categoria = '" + platoModificar.getCategoria() + "', "
                + "precio = " + platoModificar.getPrecio()
                + " WHERE id = " + idPlato + ";";

        // Se ejecuta la modificación en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "El plato se modificó en la base de datos correctamente.";
    }

    // Elimina un plato utilizando su ID
    public static String eliminarPlato(int idPlato) throws Exception {

        // Se crea la instrucción SQL para eliminar el plato
        statement = "DELETE FROM t_platos WHERE id = " + idPlato + ";";

        // Se ejecuta la instrucción en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "El plato se eliminó de la base de datos correctamente (si existía).";
    }
}
