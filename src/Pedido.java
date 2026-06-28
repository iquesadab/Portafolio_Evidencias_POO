public class Pedido {

    // Atributos
    private String codigo;
    private Plato[] platos;
    private Factura factura;
    private byte cantidadPlatos;

    // Constructor
    public Pedido(String codigo, byte cantidadMaximaPlatos) {
        this.codigo = codigo;
        this.platos = new Plato[cantidadMaximaPlatos];
        this.factura = null;
        this.cantidadPlatos = 0;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public Plato[] getPlatos() {
        return platos;
    }

    public Factura getFactura() {
        return factura;
    }

    public byte getCantidadPlatos() {
        return cantidadPlatos;
    }

    // Setter
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Métodos
    public void agregarPlato(Plato plato) {
        if (plato == null) {
            System.out.println("El plato no existe.");
            return;
        }

        if (cantidadPlatos >= platos.length) {
            System.out.println("El pedido ya alcanzó la cantidad máxima de platos.");
            return;
        }

        platos[cantidadPlatos] = plato;
        cantidadPlatos++;

        System.out.println("Se agregó el plato " + plato.getNombre() + " al pedido " + codigo);
    }

    public float calcularTotal() {
        float total = 0;

        for (int i = 0; i < cantidadPlatos; i++) {
            total += platos[i].getPrecio();
        }

        return total;
    }

    public void generarFactura(String numero, String metodoPago) {
        factura = new Factura(numero, metodoPago, calcularTotal());

        System.out.println("Se generó la factura " + numero + " para el pedido " + codigo);
    }
}
