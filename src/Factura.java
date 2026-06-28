public class Factura {

    // Atributos
    private String numero;
    private String metodoPago;
    private float total;
    private boolean pagada;

    // Constructor
    public Factura(String numero, String metodoPago, float total) {
        this.numero = numero;
        this.metodoPago = metodoPago;
        this.total = total;
        this.pagada = false;
    }

    // Getters
    public String getNumero() {
        return numero;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public float getTotal() {
        return total;
    }

    public boolean isPagada() {
        return pagada;
    }

    // Setter
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    // Métodos
    public void pagarFactura() {
        pagada = true;
    }
}
