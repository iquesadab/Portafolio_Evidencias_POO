package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.cliente.Cliente;
import cr.ac.ucenfotec.bl.entities.cliente.DAOCliente;

import java.util.ArrayList;

public class GestorCliente {

    // Agrega un cliente a la base de datos
    public static String agregarCliente(String nombre, String apellidos) throws Exception {

        // Se crea un objeto Cliente con los datos recibidos
        Cliente clienteNuevo = new Cliente(nombre, apellidos);

        // Se envía el objeto al DAO para guardarlo en la base de datos
        return DAOCliente.insertarCliente(clienteNuevo);
    }

    // Obtiene todos los clientes registrados
    public static ArrayList<Cliente> listarClientes() throws Exception {

        // Se solicita la lista de clientes al DAO
        return DAOCliente.listarClientes();
    }

    // Obtiene los ID de todos los clientes registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se solicita la lista de ID al DAO
        return DAOCliente.listarIDs();
    }

    // Modifica un cliente existente
    public static String modificarCliente(int idCliente, String nombre, String apellidos) throws Exception {

        // Se crea un objeto Cliente con los nuevos datos
        Cliente clienteModificar = new Cliente(nombre, apellidos);

        // Se envía el ID y el objeto modificado al DAO
        return DAOCliente.modificarCliente(idCliente, clienteModificar);
    }

    // Elimina un cliente utilizando su ID
    public static String eliminarCliente(int idCliente) throws Exception {

        // Se envía el ID al DAO para eliminar el cliente
        return DAOCliente.eliminarCliente(idCliente);
    }
}
