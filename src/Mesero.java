public class Mesero {

    // Atributos
    private String nombre;
    private String apellidos;
    private byte experiencia;

    // Constructor
    public Mesero(String nombre, String apellidos, byte experiencia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.experiencia = experiencia;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public byte getExperiencia() {
        return experiencia;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setExperiencia(byte experiencia) {
        this.experiencia = experiencia;
    }

    // Métodos
    public void servirPedido(Pedido pedido) {
        System.out.println(nombre + " " + apellidos +
                " está sirviendo el pedido " + pedido.getCodigo());
    }
}
