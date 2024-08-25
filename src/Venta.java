import java.util.ArrayList;
import java.io.Serializable;
public class Venta implements Serializable {
    private String folio;
    private String fecha;
    private ArrayList<LineaVenta> lineas;

    public Venta(String folio, String fecha) {
        this.folio = folio;
        this.fecha = fecha;
        lineas = new ArrayList<>();
    }

    public void AgregarLinea(int prod, int unidades, int precio) {
        lineas.add(new LineaVenta(prod, unidades, precio));
    }

    public String toString() {
        String lineas = "";
        for (LineaVenta lineaVenta : this.lineas) 
            lineas += "\n" + lineaVenta;
        return "Folio: "+folio + " Fecha: " + fecha + lineas;
    }

    // getters y setters
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<LineaVenta> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaVenta> lineas) {
        this.lineas = lineas;
    }
}
