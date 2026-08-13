package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.plato.DAOPlato;
import cr.ac.ucenfotec.bl.entities.plato.Plato;

import java.util.ArrayList;

public class GestorPlato {

    // Inserta un plato utilizando el DAO
    public static String agregarPlato(String nombre, String categoria, float precio) throws Exception {

        // Se crea el objeto Plato con los datos recibidos
        Plato platoNuevo = new Plato(nombre, categoria, precio);

        // Se envía el objeto al DAO para guardarlo en la base de datos
        return DAOPlato.insertarPlato(platoNuevo);
    }

    // Obtiene todos los platos registrados
    public static ArrayList<Plato> listarPlatos() throws Exception {

        // Se solicita la lista de platos al DAO
        return DAOPlato.listarPlatos();
    }

    // Obtiene los ID de todos los platos registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se solicita la lista de ID al DAO
        return DAOPlato.listarIDs();
    }

    // Modifica un plato existente
    public static String modificarPlato(int idPlato, String nombre, String categoria, float precio) throws Exception {

        // Se crea un objeto Plato con los nuevos datos
        Plato platoModificar = new Plato(nombre, categoria, precio);

        // Se envía el ID y el objeto modificado al DAO
        return DAOPlato.modificarPlato(idPlato, platoModificar);
    }

    // Elimina un plato utilizando su ID
    public static String eliminarPlato(int idPlato) throws Exception {

        // Se envía el ID al DAO para eliminarlo de la base de datos
        return DAOPlato.eliminarPlato(idPlato);
    }
}