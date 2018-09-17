public class Inventario {
    private String idProducto;
    private String Producto;
    private double Precio;
    private Integer Cantidad;
    private Integer IVA;
    
    public Inventario(String idProducto, String Producto, double Precio, Integer Cantidad, Integer IVA){
        this.idProducto = idProducto;
        this.Producto = Producto;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.IVA = IVA;
    }
    public void setidProducto(String idProducto){
        this.idProducto = idProducto;
    }
    
    public void setProducto(String Producto){
        this.Producto = Producto;
    }
    
    public void setPrecio(double Precio){
        this.Precio = Precio;
    }
    
    public void setCantidad(Integer Cantidad){
        this.Cantidad = Cantidad;
    }
    
    public void setIVA(Integer IVA){
        this.IVA = IVA;
    }
    
    public String getidProducto(){
        return idProducto;
    }
    
    public String getProducto(){
        return Producto;
    }
    
    public double getPrecio(){
        return Precio;
    }
    
    public Integer getCantidad(){
        return Cantidad;
    }
    
    public Integer getIVA(){
        return IVA;
    }
    
    public static Inventario[] CargarInventario(Inventario inventario[]){
        inventario[0]= new Inventario("0001", "Chocolate", 2000, 200,0);
        inventario[1]= new Inventario("0002", "Pasta", 2800, 100,0);
        inventario[2]= new Inventario("0003", "Sal", 1000, 300,1);
        inventario[3]= new Inventario("0004", "Azucar", 1900, 400,1);
        inventario[4]= new Inventario("0005", "Harina", 1230, 120,0);
        inventario[5]= new Inventario("0006", "Lentejas", 2300, 210,1);
        inventario[6]= new Inventario("0007", "Frijol", 2560, 140,1);
        inventario[7]= new Inventario("0008", "Arroz", 2200, 20,0);
        inventario[8]= new Inventario("0009", "Papa", 5000, 10,0);
        inventario[9]= new Inventario("0010", "Garbanzo", 2210, 30,1);
        inventario[10]= new Inventario("0011", "Leche", 15000, 90,1);
        inventario[11]= new Inventario("0012", "Kumis", 8000, 130,1);
        inventario[12]= new Inventario("0013", "Cerveza", 2500, 290,0);
        inventario[13]= new Inventario("0014", "Vino", 10000, 94,0);
        inventario[14]= new Inventario("0015", "Crema de Leche", 9000, 131,0);
        inventario[15]= new Inventario("0016", "Queso", 9000, 192,0);
        inventario[16]= new Inventario("0017", "Jamon", 9200, 42,0);
        inventario[17]= new Inventario("0018", "Salsa de Tomate", 7800, 22,1);
        inventario[18]= new Inventario("0019", "Soda", 6000, 232,1);
        inventario[19]= new Inventario("0020", "Tortas", 9920, 59,1);
        inventario[20]= new Inventario("0021", "aaa", 9920, 59,1);
        inventario[21]= new Inventario("0022", "aaa", 9920, 59,1);
        inventario[22]= new Inventario("0023", "aaa", 9920, 59,1);
        inventario[23]= new Inventario("0024", "aaa", 9920, 59,1);
        inventario[24]= new Inventario("0025", "aaa", 9920, 59,1);
        inventario[25]= new Inventario("0026", "aaa", 9920, 59,1);
        inventario[26]= new Inventario("0027", "aaa", 9920, 59,1);
        inventario[27]= new Inventario("0028", "aaa", 9920, 59,1);
        inventario[28]= new Inventario("0029", "aaa", 9920, 59,1);
        inventario[29]= new Inventario("0030", "aaa", 9920, 59,1);
        return inventario;
    }
    
    public static void RetirarInventario(Inventario[] inventario,Canasta[]canasta, int pos){
        Integer cantCanasta;
        Integer cantProducto;
        String idProducto;
        int enc=0;
        for (int i=0;i<pos;i++){
            cantCanasta = canasta[i].getCantidad();
            idProducto = canasta[i].getidProducto();
            for (Inventario inventario1 : inventario) {
                if(inventario1.getidProducto().equals(idProducto)){
                    cantProducto=inventario1.getCantidad();
                    if(cantCanasta>cantProducto){
                        System.out.println("No hay mas productos en el inventario");
                    }else{
                        cantProducto=cantProducto-cantCanasta;
                        inventario1.setCantidad(cantProducto);
                    }
                    enc++;
                }
            }    
        }
        if(enc==0){
            System.out.println("No se encontro el producto en la base de datos");
        }
    }
    
    public static Integer AgregarInventario(String Producto, int cant, Inventario[] inventario){
        int cantAct;
        int enc=0;
        for (Inventario inventario1 : inventario) {
            if(inventario1.getProducto().equals(Producto)){
                cantAct= inventario1.getCantidad();
                CajaRegistradora.LanzarMensaje("El producto "+inventario1.getProducto() + " paso de tener " + cantAct + " a " + (cant+cantAct) + " unidades");
                cantAct= cantAct+cant;
                inventario1.setCantidad(cantAct);
                enc++;
            }      
        }
        
        return enc;
    }
    
    public static void AgregarInventarioNuevo(String Producto, int cant, Inventario[] inventario,int pos, double Precio, int Cantidad,int IVA){
        inventario[pos].setProducto(Producto);
        inventario[pos].setPrecio(Precio);
        inventario[pos].setCantidad(Cantidad);
        inventario[pos].setIVA(IVA);
    }
    
    @Override
    public String toString(){
        return "Id Producto : " + idProducto + " Nombre Producto : " +  Producto +" Precio : " + Precio + " Cantidad : " + Cantidad;
    }
}