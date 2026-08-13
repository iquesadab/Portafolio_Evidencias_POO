package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.mesa.DAOMesa;
import cr.ac.ucenfotec.bl.entities.mesa.Mesa;

import java.util.ArrayList;

public class GestorMesa {

    // Agrega una mesa a la base de datos
    public static String agregarMesa(byte numero, byte capacidad) throws Exception {

        // Se crea un objeto Mesa con los datos recibidos
        Mesa mesaNueva = new Mesa(numero, capacidad);

        // Se envía el objeto al DAO para guardarlo
        return DAOMesa.insertarMesa(mesaNueva);
    }

    // Obtiene todas las mesas registradas
    public static ArrayList<Mesa> listarMesas() throws Exception {

        // Se solicita la lista de mesas al DAO
        return DAOMesa.listarMesas();
    }

    // Obtiene los ID de todas las mesas registradas
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se solicita la lista de ID al DAO
        return DAOMesa.listarIDs();
    }

    // Modifica una mesa existente
    public static String modificarMesa(int idMesa, byte numero, byte capacidad, boolean disponible) throws Exception {

        // Se crea un objeto Mesa con los nuevos datos
        Mesa mesaModificar = new Mesa(numero, capacidad);

        // Si la mesa debe quedar ocupada, se cambia su estado
        if (!disponible) {
            mesaModificar.ocuparMesa();
        }

        // Se envía el ID y el objeto modificado al DAO
        return DAOMesa.modificarMesa(idMesa, mesaModificar);
    }

    // Elimina una mesa utilizando su ID
    public static String eliminarMesa(int idMesa) throws Exception {

        // Se envía el ID al DAO para eliminar la mesa
        return DAOMesa.eliminarMesa(idMesa);
    }
}
