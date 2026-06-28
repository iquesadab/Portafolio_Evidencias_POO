public class Cliente {

    // Atributos
    private String nombre;
    private String apellidos;
    private Pedido pedido;

    // Constructor
    public Cliente(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pedido = null;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Métodos
    public void crearPedido(String codigo, byte cantidadMaximaPlatos) {
        pedido = new Pedido(codigo, cantidadMaximaPlatos);

        System.out.println(nombre + " " + apellidos + " creó el pedido " + codigo);
    }

    public void ocuparMesa(Mesa mesa) {
        if (mesa.isDisponible()) {
            mesa.ocuparMesa();
            System.out.println(nombre + " " + apellidos + " ocupó la mesa número " + mesa.getNumero());
        } else {
            System.out.println("La mesa número " + mesa.getNumero() + " no está disponible.");
        }
    }
}
