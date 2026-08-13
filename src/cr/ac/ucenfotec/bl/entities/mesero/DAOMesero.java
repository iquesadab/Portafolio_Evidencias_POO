package cr.ac.ucenfotec.bl.entities.mesero;

import cr.ac.ucenfotec.dl.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOMesero {

    // Variables que almacenan las instrucciones SQL
    private static String statement;
    private static String query;

    // Inserta un mesero en la base de datos
    public static String insertarMesero(Mesero meseroInsertar) throws Exception {

        // Se crea la instrucción SQL con los datos del mesero
        statement = "INSERT INTO t_meseros(nombre, apellidos, experiencia) VALUES ('"
                + meseroInsertar.getNombre() + "', '"
                + meseroInsertar.getApellidos() + "', "
                + meseroInsertar.getExperiencia() + ");";

        // Se ejecuta la instrucción en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "El mesero se registró en la base de datos correctamente.\n";
    }

    // Obtiene todos los meseros registrados en la base de datos
    public static ArrayList<Mesero> listarMeseros() throws Exception {

        // Se crea una lista para almacenar los meseros encontrados
        ArrayList<Mesero> listaMeseros = new ArrayList<>();

        // Se consultan todos los registros de la tabla meseros
        query = "SELECT * FROM t_meseros;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren todos los registros encontrados
        do {

            // Se crea un objeto Mesero con los datos obtenidos
            Mesero meseroTemp = new Mesero(
                    resultado.getString("nombre"),
                    resultado.getString("apellidos"),
                    resultado.getByte("experiencia")
            );

            // Se agrega el mesero a la lista
            listaMeseros.add(meseroTemp);

        } while (resultado.next());

        // Se retorna la lista de meseros
        return listaMeseros;
    }

    // Obtiene los ID de todos los meseros registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se crea una lista para almacenar los ID
        ArrayList<Integer> listaIDs = new ArrayList<>();

        // Se consultan todos los meseros
        query = "SELECT * FROM t_meseros;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no existen registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren todos los resultados
        do {

            // Se obtiene el ID y se agrega a la lista
            listaIDs.add(resultado.getInt("id"));

        } while (resultado.next());

        // Se retorna la lista de ID
        return listaIDs;
    }

    // Modifica un mesero existente utilizando su ID
    public static String modificarMesero(int idMesero, Mesero meseroModificar) throws Exception {

        // Se crea la instrucción SQL con los nuevos datos del mesero
        statement = "UPDATE t_meseros SET "
                + "nombre = '" + meseroModificar.getNombre() + "', "
                + "apellidos = '" + meseroModificar.getApellidos() + "', "
                + "experiencia = " + meseroModificar.getExperiencia()
                + " WHERE id = " + idMesero + ";";

        // Se ejecuta la modificación en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "El mesero se modificó en la base de datos correctamente.";
    }

    // Elimina un mesero utilizando su ID
    public static String eliminarMesero(int idMesero) throws Exception {

        // Se crea la instrucción SQL para eliminar el mesero
        statement = "DELETE FROM t_meseros WHERE id = " + idMesero + ";";

        // Se ejecuta la instrucción
        Connector.getConnection().ejecutarStatement(statement);

        return "El mesero se eliminó de la base de datos correctamente (si existía).";
    }
}