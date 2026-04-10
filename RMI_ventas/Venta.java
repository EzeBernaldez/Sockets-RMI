import java.io.Serializable;

public class Venta implements Serializable {
    private String nombre;
    private String documento;
    private String tipoEntrada;
    private double precio;

    public Venta(String nombre, String documento, String tipoEntrada, double precio) {
        this.nombre = nombre;
        this.documento = documento;
        this.tipoEntrada = tipoEntrada;
        this.precio = precio;
    }

    public String toString() {
        return nombre + " - " + documento + " - " + tipoEntrada + " - $" + precio;
    }
}