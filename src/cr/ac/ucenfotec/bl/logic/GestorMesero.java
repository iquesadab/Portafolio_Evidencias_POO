package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.mesero.DAOMesero;
import cr.ac.ucenfotec.bl.entities.mesero.Mesero;

import java.util.ArrayList;

public class GestorMesero {

    // Agrega un mesero a la base de datos
    public static String agregarMesero(String nombre, String apellidos, byte experiencia) throws Exception {

        // Se crea un objeto Mesero con los datos recibidos
        Mesero meseroNuevo = new Mesero(nombre, apellidos, experiencia);

        // Se envía el objeto al DAO para guardarlo en la base de datos
        return DAOMesero.insertarMesero(meseroNuevo);
    }

    // Obtiene todos los meseros registrados
    public static ArrayList<Mesero> listarMeseros() throws Exception {

        // Se solicita la lista de meseros al DAO
        return DAOMesero.listarMeseros();
    }

    // Obtiene los ID de todos los meseros registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se solicita la lista de ID al DAO
        return DAOMesero.listarIDs();
    }

    // Modifica un mesero existente
    public static String modificarMesero(int idMesero, String nombre,
                                         String apellidos, byte experiencia) throws Exception {

        // Se crea un objeto Mesero con los nuevos datos
        Mesero meseroModificar = new Mesero(nombre, apellidos, experiencia);

        // Se envía el ID y el objeto modificado al DAO
        return DAOMesero.modificarMesero(idMesero, meseroModificar);
    }

    // Elimina un mesero utilizando su ID
    public static String eliminarMesero(int idMesero) throws Exception {

        // Se envía el ID al DAO para eliminar el mesero
        return DAOMesero.eliminarMesero(idMesero);
    }
}