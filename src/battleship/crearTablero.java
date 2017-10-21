
package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class crearTablero extends javax.swing.JFrame {
    
    int tamanoColumna = 10;
    int tamanoFila = 10;
    private boolean tableroHabilitado = true;
    //Matriz que llevará la lógica
    
    //Matríz de botones
    private MyButton[][] mGrafica = new MyButton[tamanoColumna][tamanoFila];
    //Tamaño en píxeles del botón
    private static final int tamanoBoton= 50;
    //Tipo barco
    private enum Barco { PORTAAVIONES, DESTRUCTOR, FRAGATA, TRANSPORTADOR1, TRANSPORTADOR2 };
    Barco barco;
    
    public String[][] mLogica = new String[tamanoColumna][tamanoFila];
    
    public crearTablero() {
        initComponents();
        inicializarBotones();
        //Al iniciar tiene estado poortaviones
        barco = Barco.PORTAAVIONES;
        finalizar.setVisible(false);
    }
    
    
    
    public void setBarco(int c, int f, int direccion){
        int espacios = 0;
        String valor = "";
        Color color = null;
        Barco cambiotipo = null;
        String indicador = "";
        
        switch (barco) {
            case PORTAAVIONES:
                valor = vars.portaaviones;
                cambiotipo = Barco.DESTRUCTOR;
                espacios = vars.n_portaaviones;
                color = new Color(64, 95, 172);
                indicador = "DESTRUCTOR";
                break;
            case DESTRUCTOR:
                valor = vars.destructor;
                cambiotipo = Barco.FRAGATA;
                espacios = vars.n_destructor;
                color = new Color(209, 50, 93);
                indicador = "FRAGATA";
                break;
            case FRAGATA:
                valor = vars.fragata;
                cambiotipo = Barco.TRANSPORTADOR1;
                espacios = vars.n_fragata;
                color = new Color(178, 125, 70);
                indicador = "TRANSPORTADOR1";
                break;
            case TRANSPORTADOR1:
                valor = vars.transportador1;
                cambiotipo = Barco.TRANSPORTADOR2;
                espacios = vars.n_transportador1;
                color = new Color(72, 132, 154);
                indicador = "TRANSPORTADOR 2";
                break;
            case TRANSPORTADOR2:
                valor = vars.transportador2;
                cambiotipo = Barco.TRANSPORTADOR2;
                espacios = vars.n_transportador2;
                color = new Color(72, 132, 154);
                indicador = "FINALIZADO";
                tableroHabilitado = false;
                finalizar.setVisible(true);
                break;
            default:
                
                System.out.println("NADA");
                break;
        }
        
        if(comprobarEspacios(c, f, direccion, espacios)){
        
            for (int i = 0; i < espacios; i++) {
                mLogica[c][f] = valor;
                mGrafica[c][f].setBackground(color);
                mGrafica[c][f].setText(valor);
                
                switch (direccion) {
                    case vars.arriba:       
                        f--;
                        break;
                    case vars.abajo:
                        f++;
                        break;
                    case vars.derecha:
                        c++;
                        break;
                    case vars.izquierda:
                        c--;
                        break;
                    default:
                        break;
                }
            }
            barco = cambiotipo;
            this.indicador.setText(indicador);
        } 
        
        estadoLogica();
    }
    
    public boolean comprobarEspacios(int c, int f, int direcion, int espacios){
        int columna= 0;
        int fila = 0;
        int f_resta = 0;
        int c_resta = 0;
        espacios--;
        switch (direcion) {
                case vars.arriba:
                    fila = f - espacios;
                    f_resta = -1;
                    break;
                case vars.abajo:
                    fila = f + espacios;
                    f_resta = + 1;
                    break;
                case vars.derecha:
                    columna = c + espacios;
                    c_resta = +1;
                    break;
                case vars.izquierda:
                    columna = c - espacios;
                    c_resta = -1;
                    break;
                default:
                    break;
            }
        espacios++;
       
       
       if(columna >= 0 && columna <=9 && fila >= 0 && fila <=9  ){
           boolean existeEspacio = true;
           for (int i = 0; i < espacios; i++) {
               
               System.out.println("Columna "+c+" Fila "+f);
                if(mLogica[c][f] == null){
                }
                
                else{
                    existeEspacio = false;
                    break;
                }
                c = c+c_resta;
                f = f+ f_resta;
           }
           
           if(existeEspacio)
               return true;
           else
               return false;
       }
       else
           return false;
       
    }
    
    
    public int getDireccion(){
       String[] options = {"Arriba", "Abajo", "Izquierda", "Derecha"};
       //Esto retorna la posición del la opcion seleccionada
       return JOptionPane.showOptionDialog(null, "Es necesario que seleccione una opcion", "Orientación", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[3]);
    }
    
    
    public void inicializarBotones(){  
        for (int c= 0; c < tamanoColumna; c++) {
            
            for (int f = 0; f < tamanoFila; f++) {
                
                MyButton actual = mGrafica[c][f] = new MyButton(c,f);
                actual.setBounds((c*tamanoBoton)+30 ,(f*tamanoBoton)+60, tamanoBoton, tamanoBoton);
                actual.setBackground(new Color(133, 164, 255));
                actual.setForeground(Color.WHITE);
                
                //Se le pone un escuchador al botón
                actual.addActionListener((ActionEvent e) -> {
                    if(mLogica[actual.columna][actual.fila] == null && tableroHabilitado){
                        int direccion = getDireccion();                    
                        setBarco(actual.columna, actual.fila, direccion);
                    }
                });
                
                contenedor.add(actual);
            }            
        }
    
    }    
    
    
    public void estadoLogica(){
        
        for (int c = 0; c < 10; c++) {
                System.out.println(isNull(mLogica[0][c])+ " "+ isNull(mLogica[1][c]) + " "+ isNull(mLogica[2][c]) +" "+  isNull(mLogica[3][c]) +" "+ isNull(mLogica[4][c])
                                    + " "+isNull( mLogica[5][c]) + " "+ isNull(mLogica[6][c]) +" "+  isNull(mLogica[7][c]) +" "+ isNull(mLogica[8][c])+" "+ isNull(mLogica[9][c]));
        }
        System.out.println("\n");
    }
    
    public String isNull(String str){
        if(str == null)
            return "-";
        else
            return str;
                    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        indicador = new javax.swing.JLabel();
        finalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(580, 650));

        contenedor.setBackground(java.awt.Color.white);
        contenedor.setPreferredSize(new java.awt.Dimension(580, 650));

        indicador.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        indicador.setForeground(new java.awt.Color(115, 181, 254));
        indicador.setText("PORTAAVIONES");

        finalizar.setBackground(java.awt.Color.red);
        finalizar.setForeground(java.awt.Color.white);
        finalizar.setText("FINALIZAR");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(finalizar)
                    .addComponent(indicador))
                .addContainerGap(744, Short.MAX_VALUE))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(indicador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
                .addComponent(finalizar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        dispose();
        new Tablero().setVisible(true);
    }//GEN-LAST:event_finalizarActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(crearTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crearTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crearTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crearTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crearTablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel indicador;
    // End of variables declaration//GEN-END:variables
}
