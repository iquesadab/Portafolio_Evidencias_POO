public class Mesa {

    // Atributos
    private byte numero;
    private byte capacidad;
    private boolean disponible;

    // Constructor
    public Mesa(byte numero, byte capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.disponible = true;
    }

    // Getters
    public byte getNumero() {
        return numero;
    }

    public byte getCapacidad() {
        return capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setters
    public void setNumero(byte numero) {
        this.numero = numero;
    }

    public void setCapacidad(byte capacidad) {
        this.capacidad = capacidad;
    }

    // Métodos
    public void ocuparMesa() {
        disponible = false;
    }

    public void liberarMesa() {
        disponible = true;
    }
}