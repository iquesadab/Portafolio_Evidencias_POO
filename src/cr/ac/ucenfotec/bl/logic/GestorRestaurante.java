package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.restaurante.DAORestaurante;
import cr.ac.ucenfotec.bl.entities.restaurante.Restaurante;

import java.util.ArrayList;

public class GestorRestaurante {

    // Agrega un restaurante a la base de datos
    public static String agregarRestaurante(String nombre) throws Exception {

        /*
         * Se crea el restaurante.
         * Los tamaños se colocan inicialmente en 0 porque
         * las mesas, meseros y platos se registran mediante
         * sus propios gestores.
         */
        Restaurante restauranteNuevo = new Restaurante(
                nombre,
                (byte) 0,
                (byte) 0,
                (byte) 0
        );

        // Se envía el restaurante al DAO para guardarlo
        return DAORestaurante.insertarRestaurante(restauranteNuevo);
    }

    // Obtiene todos los restaurantes registrados
    public static ArrayList<Restaurante> listarRestaurantes() throws Exception {

        // Se solicita la lista de restaurantes al DAO
        return DAORestaurante.listarRestaurantes();
    }

    // Obtiene los ID de todos los restaurantes registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se solicita la lista de ID al DAO
        return DAORestaurante.listarIDs();
    }

    // Modifica un restaurante existente
    public static String modificarRestaurante(int idRestaurante,
                                              String nombre) throws Exception {

        // Se crea un restaurante con el nuevo nombre
        Restaurante restauranteModificar = new Restaurante(
                nombre,
                (byte) 0,
                (byte) 0,
                (byte) 0
        );

        // Se envía el ID y el objeto al DAO
        return DAORestaurante.modificarRestaurante(
                idRestaurante,
                restauranteModificar
        );
    }

    // Elimina un restaurante utilizando su ID
    public static String eliminarRestaurante(int idRestaurante) throws Exception {

        // Se envía el ID al DAO para eliminarlo
        return DAORestaurante.eliminarRestaurante(idRestaurante);
    }
}
