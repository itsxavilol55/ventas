import java.io.Serializable;
public class LineaVenta implements Serializable{
    private int prod, unidades, precio;
    public String toString() {
        return  "\nProducto: " + prod +
                "\nCantidad: " + unidades +
                "\nPrecio: " + precio +
                "\nTotal:" + (unidades * precio);
    }
    public int getProd() {
        return prod;
    }
    public void setProd(int prod) {
        this.prod = prod;
    }
    public int getUnidades() {
        return unidades;
    }
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public LineaVenta(int prod, int unidades, int precio) {
        this.prod = prod;
        this.unidades = unidades;
        this.precio = precio;
    }
}
