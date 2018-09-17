public class Canasta {
    private String idProducto;
    private String Producto;
    private double Precio;
    private Integer Cantidad;
    private double Total;
    
    public Canasta(String idProducto, String Producto, double Precio, Integer Cantidad, double Total){
        this.idProducto = idProducto;
        this.Producto = Producto;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.Total = Total;
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
    public void setTotal(double Total){
        this.Total = Total;
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
    public double getTotal(){
        return Total;
    }

    public static Integer registrarCanasta(Canasta[] canasta, int pos,Inventario[] inventario,String Producto, int cantidad){
        double total;
        double precio;
        double iva = 0.19;
        int encontro=0;
        int ifiva;
        for (Inventario inventario1 : inventario) {
            if(inventario1.getProducto().equals(Producto)){
                canasta[pos] = new Canasta(inventario1.getidProducto(),inventario1.getProducto(),inventario1.getPrecio(),cantidad,0);
                precio = canasta[pos].getPrecio();
                cantidad= canasta[pos].getCantidad();
                ifiva=inventario1.getIVA();
                total=precio*cantidad;
                if(ifiva == 1){    
                    total=(total*iva)+(total);  
                    System.out.println(canasta[pos].getidProducto() + "       " + canasta[pos].getProducto()+ "   " + 
                        canasta[pos].getPrecio() + "    " +canasta[pos].getCantidad() + "    " + total + " *");    
                }else{
                    System.out.println(canasta[pos].getidProducto() + "       " + canasta[pos].getProducto()+ "   " + 
                        canasta[pos].getPrecio() + "    " +canasta[pos].getCantidad() + "    " + total);
                }
                canasta[pos].setTotal(total);
                encontro++;
            }
        }
        return encontro;
    }
    public static double Total(Canasta [] canasta, Integer pos){
        double total=0;
        for (int i=0;i<=pos;i++) {
            total= total + canasta[i].getTotal();
            
        }
        return total;
    }
    public static double Cambio(double total, double efectivo){
        double cambio;
        cambio = efectivo-total;
        if(cambio < 0){
            cambio=0;
        }
        return cambio;
    }
    
    public static void RetirarCanasta(String Producto, Canasta[] canasta, int cant){
        int cantAct;
        for (Canasta canasta1 : canasta) {
            if(canasta1.getProducto().equals(Producto)){
                cantAct=canasta1.getCantidad();
                cantAct= cantAct-cant;
                if(cantAct<0){
                    System.out.println("No se pueden retirar esa cantidad de productos de la canasta ya que solo hay "+canasta1.getCantidad());
                }else{
                    canasta1.setCantidad(cantAct);
                }
            }
        }
    }
}