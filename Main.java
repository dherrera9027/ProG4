import java.awt.Button;


public class Main {
    public static void main(String[] args) {
        
        int cantInventario=20;
        Inventario [] inventario = new Inventario[30];
        CajaRegistradora caja = new CajaRegistradora();
        
        inventario = Inventario.CargarInventario(inventario);
        System.out.println("Bienvenidos al Sistema");
        System.out.println("idProducto Nombre      Precio Valor Total");
        caja.setVisible(true);
    }
}