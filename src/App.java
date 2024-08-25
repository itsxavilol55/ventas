public class App {
    public static void main(String[] args) throws Exception {
        Archivo arc1 = new Archivo();
        Venta venta1 = new Venta("1","10/10/10");
        venta1.AgregarLinea(1,1,1);
        venta1.AgregarLinea(2,3,4);
        venta1.AgregarLinea(3,5,7);
        venta1.AgregarLinea(4,1,1);
        venta1.AgregarLinea(5,3,4);
        venta1.AgregarLinea(6,5,7);
        arc1.guardar(venta1);
        venta1 = null;
        Venta venta2 = new Venta("2","11/11/11");
        venta2.AgregarLinea(1,1,1);
        venta2.AgregarLinea(2,3,3);
        venta2.AgregarLinea(3,7,6);
        venta2.AgregarLinea(4,2,1);
        venta2.AgregarLinea(5,3,4);
        venta2.AgregarLinea(6,5,7);
        venta2.AgregarLinea(7,3,4);
        venta2.AgregarLinea(8,1,6);
        venta2.AgregarLinea(9,5,2);
        arc1.guardar(venta2);
        venta2 = null;
        venta1 = arc1.recuperar("1");
        venta2 = arc1.recuperar("2");
        arc1.borrar("1");
        System.out.println(venta1);
        System.out.println(venta2);
    }
}
