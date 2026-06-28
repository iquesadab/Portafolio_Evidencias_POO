public class Restaurante {

    // Atributos
    private String nombre;
    private Mesa[] mesas;
    private Mesero[] meseros;
    private Plato[] platos;

    private byte cantidadMesas;
    private byte cantidadMeseros;
    private byte cantidadPlatos;

    // Constructor
    public Restaurante(String nombre, byte cantidadMaximaMesas, byte cantidadMaximaMeseros, byte cantidadMaximaPlatos) {
        this.nombre = nombre;
        this.mesas = new Mesa[cantidadMaximaMesas];
        this.meseros = new Mesero[cantidadMaximaMeseros];
        this.platos = new Plato[cantidadMaximaPlatos];

        this.cantidadMesas = 0;
        this.cantidadMeseros = 0;
        this.cantidadPlatos = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Mesa[] getMesas() {
        return mesas;
    }

    public Mesero[] getMeseros() {
        return meseros;
    }

    public Plato[] getPlatos() {
        return platos;
    }

    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos
    public void registrarMesa(Mesa mesa) {
        if (mesa == null) {
            System.out.println("La mesa no existe.");
            return;
        }
        if (cantidadMesas >= mesas.length) {
            System.out.println("No se pueden registrar más mesas.");
            return;
        }

        mesas[cantidadMesas] = mesa;
        cantidadMesas++;

        System.out.println("Se registró la mesa número " + mesa.getNumero());
    }

    public void registrarMesero(Mesero mesero) {
        if (mesero == null) {
            System.out.println("El mesero no existe.");
            return;
        }
        if (cantidadMeseros >= meseros.length) {
            System.out.println("No se pueden registrar más meseros.");
            return;
        }

        meseros[cantidadMeseros] = mesero;
        cantidadMeseros++;

        System.out.println("Se registró el mesero " + mesero.getNombre() + " " + mesero.getApellidos());
    }

    public void registrarPlato(Plato plato) {
        if (plato == null) {
            System.out.println("El plato no existe.");
            return;
        }

        if (cantidadPlatos >= platos.length) {
            System.out.println("No se pueden registrar más platos.");
            return;
        }

        platos[cantidadPlatos] = plato;
        cantidadPlatos++;

        System.out.println("Se registró el plato " + plato.getNombre());
    }

    public void mostrarMenu() {
        System.out.println("\n MENÚ DEL RESTAURANTE");

        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.println((i + 1) + ". " +
                    platos[i].getNombre() +
                    " - ₡" + platos[i].getPrecio());
        }
    }
}
