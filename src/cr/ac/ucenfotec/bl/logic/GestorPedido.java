package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.pedido.DAOPedido;
import cr.ac.ucenfotec.bl.entities.pedido.Pedido;

import java.util.ArrayList;

public class GestorPedido {

    // Agrega un pedido a la base de datos
    public static String agregarPedido(String codigo,
                                       byte cantidadMaximaPlatos,
                                       int idCliente) throws Exception {

        // Se crea un objeto Pedido con los datos recibidos
        Pedido pedidoNuevo = new Pedido(codigo, cantidadMaximaPlatos);

        // Se envía el pedido y el ID del cliente al DAO
        return DAOPedido.insertarPedido(pedidoNuevo, idCliente);
    }

    // Obtiene todos los pedidos registrados
    public static ArrayList<Pedido> listarPedidos() throws Exception {

        // Se solicita la lista de pedidos al DAO
        return DAOPedido.listarPedidos();
    }

    // Obtiene los ID de todos los pedidos registrados
    public static ArrayList<Integer> listarIDs() throws Exception {

        // Se solicita la lista de ID al DAO
        return DAOPedido.listarIDs();
    }

    // Obtiene los ID de los clientes disponibles
    public static ArrayList<Integer> listarIDsClientes() throws Exception {

        // Se solicita al DAO la lista de clientes
        return DAOPedido.listarIDsClientes();
    }

    // Modifica un pedido existente
    public static String modificarPedido(int idPedido,
                                         String codigo,
                                         byte cantidadMaximaPlatos,
                                         int idCliente) throws Exception {

        // Se crea un objeto Pedido con los nuevos datos
        Pedido pedidoModificar = new Pedido(codigo, cantidadMaximaPlatos);

        // Se envían los datos al DAO
        return DAOPedido.modificarPedido(
                idPedido,
                pedidoModificar,
                idCliente
        );
    }

    // Elimina un pedido utilizando su ID
    public static String eliminarPedido(int idPedido) throws Exception {

        // Se envía el ID del pedido al DAO
        return DAOPedido.eliminarPedido(idPedido);
    }
}
