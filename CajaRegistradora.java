import java.awt.HeadlessException;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;

public class CajaRegistradora extends javax.swing.JFrame {
    public CajaRegistradora() {
        initComponents();
        inventario = Inventario.CargarInventario(inventario);
    }                        
    public void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblText = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TipoTransaccion = new javax.swing.JComboBox<>();
        bntContinuar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenidos al Sistema");

        lblText.setText("Nombre del Producto:");

        jLabel3.setText("Total :");

        jLabel4.setText("Tipo de Transaccion:");

        TipoTransaccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agregar a la canasta", "Retirar de la canasta","Agregar al Inventario" }));

        bntContinuar.setText("Aceptar");
        bntContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bntContinuarActionPerformed(evt,inventario,canasta);
                
            }
        });

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnPagarActionPerformed(evt,inventario,canasta,pos);
                
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TipoTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblText)
                                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(bntContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TipoTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntContinuar))
                .addGap(72, 72, 72))
        );

        pack();
    }                

    private void bntContinuarActionPerformed(java.awt.event.ActionEvent evt, Inventario[] inventario,Canasta[] canasta) {
        String value = TipoTransaccion.getSelectedItem().toString();
        if(value.equals("Agregar a la canasta")){
            if(i==0){
                try{
                    Producto = txtValor.getText();
                    lblText.setText("Ingrese la Cantidad del Producto " + Producto + " : ");
                    txtValor.setText("");
                    i++;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Ingreso mal la informacion","Error",JOptionPane.ERROR_MESSAGE);
                } 
            }else{
                try{
                    Cantidad= Integer.parseInt(txtValor.getText());
                    lblText.setText("Nombre del Producto:");
                    txtValor.setText("");
                    enc=Canasta.registrarCanasta(canasta, pos, inventario, Producto, Cantidad);
                    if(enc>0){
                        total=Canasta.Total(canasta,pos);
                        txtTotal.setText(Double.toString(total));
                        pos++;
                    }else{
                        JOptionPane.showMessageDialog(this, "El Producto no existe","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    i=0;
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(this, "Ingreso mal la informacion","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }if(value.equals("Retirar de la canasta")){
            if(pos==0){
                JOptionPane.showMessageDialog(this, "No Existe Ningun Producto en la Canasta","Error",JOptionPane.ERROR_MESSAGE);
            }
            if(i==0){
                try{
                    Producto = txtValor.getText();
                    lblText.setText("Ingrese la Cantidad del Producto " + Producto + " : ");
                    txtValor.setText("");
                    i++;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Ingreso mal la informacion","Error",JOptionPane.ERROR_MESSAGE);
                } 
            }else{
                try{
                    Cantidad= Integer.parseInt(txtValor.getText());
                    CajaRegistradora.LanzarMensaje("Se Retiró el Producto Con Exito");
                    lblText.setText("Nombre del Producto:");
                    txtValor.setText("");
                    Canasta.RetirarCanasta(Producto, canasta, Cantidad);
                    i=0;
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(this, "Ingreso mal la informacion","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(value.equals("Agregar al Inventario")){
            if(i==0){
                try{
                    Producto = txtValor.getText();
                    lblText.setText("Ingrese la Cantidad del Producto " + Producto + " : ");
                    txtValor.setText("");
                    i++;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Ingreso mal la informacion ","Error",JOptionPane.ERROR_MESSAGE);
                } 
            }else{
                try{
                    if(i==1){
                        Cantidad= Integer.parseInt(txtValor.getText());
                        enc=Inventario.AgregarInventario(Producto, Cantidad, inventario);
                        System.out.println("enc = " + enc);
                        enc++;
                    }
                    if(enc != 0){
                        lblText.setText("Nombre del Producto:");
                        txtValor.setText("");
                        i=0;
                        enc=0;
                    }
                    if(i == 2 && enc == 2){
                      lblText.setText("Ingrese el Valor del Producto a Agregar al Inventario : ");
                      Precio=1;
                      i++;
                    }
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(this, "Ingreso mal la informacion","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }   
    }                                            

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt, Inventario[] inventario, Canasta[]canasta, Integer pos) {
        double Cambio;
        
        if(x==0){
            lblText.setText("Ingrese el Efectivo a Pagar el Total de la Compra : ");
            txtValor.setText("");
            x++;
        }else{
            try{
                Efectivo= Double.parseDouble(txtValor.getText());
                Cambio = Canasta.Cambio(total, Efectivo);
                lblText.setText("Su cambio es : ");
                txtValor.setText(Double.toString(Cambio));
                Inventario.RetirarInventario(inventario, canasta, pos);
                System.out.println("_____________________________________________________");
                System.out.println("El total de la compra es: "+total);
                System.out.println("Su cambio es : " + Cambio);
                CajaRegistradora.LanzarMensaje("El total de la compra es: " + total + "\n" + "Su cambio es : " + Cambio);
                pos=0;
                total=0;
                Efectivo=0;
                x++;
                if(Cambio<0){
                    JOptionPane.showMessageDialog(this, "No se alcanza a pagar con el efectivo ingresado","Error",JOptionPane.ERROR_MESSAGE);
                    x=0;
                }
                }catch(HeadlessException | NumberFormatException e){
                    JOptionPane.showMessageDialog(this, "Ingreso de valor incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        if(x==2){
            lblText.setText("Nombre del Producto:");
            x=0;
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CajaRegistradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CajaRegistradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CajaRegistradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CajaRegistradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CajaRegistradora().setVisible(true);
            }
        });
    }
    
    public static void LanzarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
                   
    private javax.swing.JComboBox<String> TipoTransaccion;
    private javax.swing.JButton bntContinuar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblText;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValor;
    int cantInventario=20;
    Canasta[] canasta = new Canasta[cantInventario];
    Inventario[] inventario = new Inventario[30];
    int i =0;
    int pos=0;
    String Producto=null;
    int x=0;
    double total;
    double Efectivo=0;
    int enc=0;
    Integer Cantidad=0;
    double Precio=0;
    Integer IVA=0;               
}