import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
public class Archivo {
    private FileOutputStream escritura;
    private ObjectOutputStream flujosalida;
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
                if (venta.getFolio().equals(folio)) {
                    lectura.close();
                    flujoentrada.close();
                    return venta;
                }
            }
        } catch (Exception e) {
            return null;
        }
    }
    public void borrar(String folio) {
        File archivo = new File("ventas.txt");
        File archivoAux = new File("ventasAux.txt");
        try {
            FileInputStream lectura = new FileInputStream(archivo);
            ObjectInputStream flujoentrada = new ObjectInputStream(lectura);
            FileOutputStream escrituraAux = new FileOutputStream(archivoAux);
            ObjectOutputStream flujosalidaAux = new ObjectOutputStream(escrituraAux);
            while (true) {
                try {
                    Venta venta = (Venta) flujoentrada.readObject();
                    if (!venta.getFolio().equals(folio)) 
                        flujosalidaAux.writeObject(venta);
                } catch (Exception e) {
                    break;
                }
            }
            lectura.close();
            flujoentrada.close();
            escritura.close();
            flujosalida.close();
            escrituraAux.close();
            flujosalidaAux.close();
            Files.move(archivoAux.toPath(), archivo.toPath(),StandardCopyOption.REPLACE_EXISTING);
            escritura = new FileOutputStream("ventas.txt",true);
            flujosalida = new MyOOS(escritura);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Venta> obtenerVentas() {
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            FileInputStream lectura = new FileInputStream("ventas.txt");
            ObjectInputStream flujoentrada = new ObjectInputStream(lectura);
            while (true) {
                try {
                    Venta venta = (Venta) flujoentrada.readObject();
                    ventas.add(venta);
                } catch (Exception e) {
                    break;
                }
            }
            lectura.close();
            flujoentrada.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ventas;
    }
}