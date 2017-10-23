
package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JOptionPane;

public final class CrearTablero extends javax.swing.JFrame {
    
    int tamanoColumna = 10;
    int tamanoFila = 10;
    Random random = new Random();
    //Tamaño en píxeles del botón
    private static final int tamanoBoton = 50;
    //Si esa el tablero habilitado para darle click
    private boolean tableroHabilitado = true;    
    //Matríz de botones
    private MyButton[][] mBotones = new MyButton[tamanoColumna][tamanoFila];
    public String[][] mUsuario = new String[tamanoColumna][tamanoFila];
    public String[][] mPC = new String[tamanoColumna][tamanoFila];
    
    //Creación de objetos barcos
    Barco portaaviones   = new Barco("Portaaviones", "P", new Color(64, 95, 172), 6);
    Barco destructor     = new Barco("Destructor", "D", new Color(209, 50, 93), 5);
    Barco fragata        = new Barco("Fragata", "F", new Color(178, 125, 70), 3);
    Barco transportador1 = new Barco("Transportador 1", "T", new Color(72, 132, 154), 2);
    Barco transportador2 = new Barco("Transportador 2", "T", new Color(72, 132, 154), 2);
    Barco finalizado        = new Barco("Finalizado", "", Color.white, 0); //Barco para estado finalizado
    //Barco que se está dibujando
    Barco barcoActual  = portaaviones;
    
    /*private enum estadoBarco { PORTAAVIONES, DESTRUCTOR, FRAGATA, TRANSPORTADOR1, TRANSPORTADOR2 };
    estadoBarco barco; */
    
    
    public CrearTablero() {
        initComponents();
        dibujarBotones();
        //Al iniciar tiene estado poortaviones
        //barco = estadoBarco.PORTAAVIONES;
        finalizar.setVisible(false);
    }   
    
    
    public void ponerBarco(int columna, int fila, int direccion){        
        
        if(comprobarEspacios(columna, fila, direccion, barcoActual.tamano, mUsuario)){
        
            for (int i = 0; i < barcoActual.tamano; i++) {
                mUsuario[columna][fila] = barcoActual.indicador;
                mBotones[columna][fila].setBackground(barcoActual.color);
                mBotones[columna][fila].setText(barcoActual.indicador);
                
                switch (direccion) {
                    case vars.arriba:       
                        fila--;
                        break;
                    case vars.abajo:
                        fila++;
                        break;
                    case vars.derecha:
                        columna++;
                        break;
                    case vars.izquierda:
                        columna--;
                        break;
                    default:
                        break;
                }
            }
            
            if (barcoActual == portaaviones )
                barcoActual = destructor;
            else if (barcoActual == destructor)
                barcoActual = fragata;
            else if (barcoActual == fragata)
                barcoActual = transportador1;
            else if (barcoActual == transportador1)
                barcoActual = transportador2;
            else{//Si es transportador 2
                barcoActual = portaaviones;
                setPC();
            }
            
            this.indicador.setText(barcoActual.nombre);
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "No se puede posicionar el barco","ERROR", JOptionPane.ERROR_MESSAGE);
        }
                
            
        //estadoLogica(mUsuario);
    }
    
    public void setPC(){
        while(barcoActual != finalizado){
            int c = getRandom(10);
            int f = getRandom(10);
            int direccion = getRandom(4);
            if(comprobarEspacios(c, f, direccion, barcoActual.tamano,mPC)){
                
                for (int i = 0; i < barcoActual.tamano; i++) {
                    mPC[c][f] = barcoActual.indicador;

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
                
                
                if (barcoActual == portaaviones )
                    barcoActual = destructor;
                else if (barcoActual == destructor)
                    barcoActual = fragata;
                else if (barcoActual == fragata)
                    barcoActual = transportador1;
                else if (barcoActual == transportador1)
                    barcoActual = transportador2;
                else{//Si es transportador 2
                    tableroHabilitado = false;
                    finalizar.setVisible(true);
                    barcoActual = finalizado;
                    }    
            }
        }
    }
    
    public boolean comprobarEspacios(int c, int f, int direcion, int espacios, String[][] matris){
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
               
               
                if(matris[c][f] == null){
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
    
    
    public void dibujarBotones(){  
        for (int c= 0; c < tamanoColumna; c++) {
            
            for (int f = 0; f < tamanoFila; f++) {
                
                MyButton actual = mBotones[c][f] = new MyButton(c,f);
                actual.setBounds((c*tamanoBoton)+30 ,(f*tamanoBoton)+60, tamanoBoton, tamanoBoton);
                actual.setBackground(new Color(133, 164, 255));
                actual.setForeground(Color.WHITE);
                
                //Se le pone un escuchador al botón
                actual.addActionListener((ActionEvent e) -> {
                    //Si el botón utlizado es null es decir no esta ocupado y el tablero está habilitado
                    if(mUsuario[actual.columna][actual.fila] == null && tableroHabilitado){
                        //Se obitene la dirección orientada
                        int direccion = getDireccion();
                        //Si se eligió la drección y no solo se cerro el panel
                        if(direccion >=0)
                            //Se trata de poner el Barco
                            ponerBarco(actual.columna, actual.fila, direccion);
                    }
                    
                });
                contenedor.add(actual);
            }
        }
    }    
    
    public int getRandom(int limite){
        return random.nextInt(limite);
    }
    
    
    public void estadoMatriz(String[][] matris){
        for (int c = 0; c < 10; c++) {
                System.out.println(isNull(matris[0][c])+ " "+ isNull(matris[1][c]) + " "+ isNull(matris[2][c]) +" "+  isNull(matris[3][c]) +" "+ isNull(matris[4][c])
                                    + " "+isNull(matris[5][c]) + " "+ isNull(matris[6][c]) +" "+  isNull(matris[7][c]) +" "+ isNull(matris[8][c])+" "+ isNull(matris[9][c]));
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
        new Juego(mUsuario,mPC,portaaviones,destructor,fragata,transportador1,transportador2,finalizado,tamanoColumna,tamanoFila).setVisible(true);
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
            java.util.logging.Logger.getLogger(CrearTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearTablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel indicador;
    // End of variables declaration//GEN-END:variables
}
