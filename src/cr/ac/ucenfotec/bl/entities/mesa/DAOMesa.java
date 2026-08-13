package cr.ac.ucenfotec.bl.entities.mesa;

import cr.ac.ucenfotec.dl.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOMesa {

    // Variables que almacenan las instrucciones SQL
    private static String statement;
    private static String query;

    // Inserta una mesa en la base de datos
    public static String insertarMesa(Mesa mesaInsertar) throws Exception {

        // Se crea la instrucción SQL con los datos de la mesa
        statement = "INSERT INTO t_mesas(numero, capacidad, disponible) VALUES ("
                + mesaInsertar.getNumero() + ", "
                + mesaInsertar.getCapacidad() + ", "
                + mesaInsertar.isDisponible() + ");";

        // Se ejecuta la instrucción en la base de datos
        Connector.getConnection().ejecutarStatement(statement);

        return "La mesa se registró en la base de datos correctamente.\n";
    }

    // Obtiene todas las mesas registradas
    public static ArrayList<Mesa> listarMesas() throws Exception {

        // Se crea una lista para almacenar las mesas encontradas
        ArrayList<Mesa> listaMesas = new ArrayList<>();

        // Se consultan todos los registros de la tabla mesas
        query = "SELECT * FROM t_mesas;";

        // Se ejecuta la consulta
        ResultSet resultado = Connector.getConnection().ejecutarQuery(query);

        // Si no hay registros se retorna null
        if (!resultado.next()) {
            return null;
        }

        // Se recorren todos los registros encontrados
        do {

            // Se crea un objeto Mesa con los datos obtenidos
            Mesa mesaTemp = new Mesa(
                    resultado.getByte("numero"),
                    resultado.getByte("capacidad")
            );

            // Se ajusta el estado de disponibilidad según la base de datos
            if (!resultado.getBoolean("disponible")) {
                mesaTemp.ocuparMesa();
            }

            // Se agrega la mesa a la lista
            listaMesas.add(mesaTemp);

        } while (resultado.next());

        // Se retorna la lista de mesas
        return listaMesas;
    }

    // Obtiene los ID de todas las mesas registradas
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se crea una lista para almacenar los ID
        ArrayList<Integer> listaIDs = new ArrayList<>();

        // Se consultan todas las mesas
        query = "SELECT * FROM t_mesas;";

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

    // Modifica una mesa existente utilizando su ID
    public static String modificarMesa(int idMesa, Mesa mesaModificar) throws Exception {

        // Se crea la instrucción SQL con los nuevos datos de la mesa
        statement = "UPDATE t_mesas SET "
                + "numero = " + mesaModificar.getNumero() + ", "
                + "capacidad = " + mesaModificar.getCapacidad() + ", "
                + "disponible = " + mesaModificar.isDisponible()
                + " WHERE id = " + idMesa + ";";

        // Se ejecuta la modificación
        Connector.getConnection().ejecutarStatement(statement);

        return "La mesa se modificó en la base de datos correctamente.";
    }

    // Elimina una mesa utilizando su ID
    public static String eliminarMesa(int idMesa) throws Exception {

        // Se crea la instrucción SQL para eliminar la mesa
        statement = "DELETE FROM t_mesas WHERE id = " + idMesa + ";";

        // Se ejecuta la instrucción
        Connector.getConnection().ejecutarStatement(statement);

        return "La mesa se eliminó de la base de datos correctamente (si existía).";
    }
}
