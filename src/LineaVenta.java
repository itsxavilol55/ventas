import java.io.Serializable;
public class LineaVenta implements Serializable{
    private int prod, unidades, precio;
    public LineaVenta(int prod, int unidades, int precio) {
        this.prod = prod;
        this.unidades = unidades;
        this.precio = precio;
    }
    public String toString() {
        return  "\nProducto: " + prod +
                "\nCantidad: " + unidades +
                "\nPrecio: " + precio +
                "\nTotal:" + (unidades * precio);
    }
}
