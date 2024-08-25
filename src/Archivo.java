import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class Archivo {
    FileOutputStream escritura;
    ObjectOutputStream flujosalida;
    public Archivo(){
        try {
            escritura = new FileOutputStream("ventas.txt");
            flujosalida = new ObjectOutputStream(escritura);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void guardar(Venta venta) {
        try {
            flujosalida.writeObject(venta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Venta recuperar(String folio) {
        try {
            FileInputStream lectura = new FileInputStream("ventas.txt");
            ObjectInputStream flujoentrada = new ObjectInputStream(lectura);
            while (true) {
                Venta venta = (Venta) flujoentrada.readObject();
                if (venta.getFolio().equals(folio)) 
                    return venta;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public void borrar(String folio) {
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            FileInputStream lectura = new FileInputStream("ventas.txt");
            ObjectInputStream flujoentrada = new ObjectInputStream(lectura);
            while (true) {
                try {
                    Venta venta = (Venta) flujoentrada.readObject();
                    if (!venta.getFolio().equals(folio)) 
                        ventas.add(venta);
                } catch (Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            escritura = new FileOutputStream("ventas.txt");
            flujosalida = new ObjectOutputStream(escritura);
            for (Venta venta : ventas) {
                guardar(venta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
