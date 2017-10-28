
package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JOptionPane;

public final class CrearTablero extends javax.swing.JFrame {
    
    
    //Tamaño de la columna
    int tamanoColumna = 10;
    //Tamaño de la fila
    int tamanoFila = 10;
    Random random = new Random();
    //Tamaño en píxeles del botón
    private static final int tamanoBoton = 50;
    //Si esa el tablero habilitado para darle click mientras se asigna
    private boolean tableroHabilitado = true;    
    //Matríz de botones
    private MyButton[][] mBotones = new MyButton[tamanoColumna][tamanoFila];
    //Matriz de posiciones para usuario
    public String[][] mUsuario = new String[tamanoColumna][tamanoFila];
    //Matriz de posiciones para PC  
    public String[][] mPC = new String[tamanoColumna][tamanoFila];
    
    //Creación de objetos barcos
    Barco portaaviones   = new Barco("Portaaviones", "P", new Color(64, 95, 172), 6);
    Barco destructor     = new Barco("Destructor", "D", new Color(209, 50, 93), 5);
    Barco fragata        = new Barco("Fragata", "F", new Color(178, 125, 70), 3);
    Barco transportador1 = new Barco("Transportador 1", "T", new Color(72, 132, 154), 2);
    Barco transportador2 = new Barco("Transportador 2", "t", new Color(72, 132, 154), 2);
    Barco finalizado     = new Barco("Finalizado", "", Color.BLACK, 0); //Barco para estado finalizado
    //Barco que se está dibujando
    Barco barcoActual  = portaaviones;
    
    /*private enum estadoBarco { PORTAAVIONES, DESTRUCTOR, FRAGATA, TRANSPORTADOR1, TRANSPORTADOR2 };
    estadoBarco barco; */
    
    
    public CrearTablero() {
        //Se dibujan los componentes visuales
        initComponents();
        //Se dibujan los botones 
        dibujarBotones();
        //El botón finalizar no se muestra
        finalizar.setVisible(false);
    }   
    
    //Funcion que recibe la ubicacion del barco y direccion
    public void ponerBarco(int columna, int fila, int direccion){        
        //Si existen espacios en la columna, fila direccion, tamaño y la matriz especificada
        if(existenEspacios(columna, fila, direccion, barcoActual.tamano, mUsuario)){
            
            //For hasta el tamaño del barco actual
            for (int i = 0; i < barcoActual.tamano; i++) {
                //Se pone el inidcador en la matris usuario del barco actual 
                mUsuario[columna][fila] = barcoActual.indicador;
                //Para el botón en esa posición se le pone el color y letra (indicador)
                mBotones[columna][fila].setBackground(barcoActual.color);
                mBotones[columna][fila].setText(barcoActual.indicador);
                
                //Dependiendo la dirección se va restando la fila o la columna
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
            
            //Se camabia el barco actual
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
                //Se le indica que debe crear matriz automáticamente
                crearMatrizPC();
            }
            
            //Al título se le pone el nombre del barco actual
            this.indicador.setText(barcoActual.nombre);
            
        }
        
        //De lo contrario se muestra el mensaje de error
        else{
            JOptionPane.showMessageDialog(rootPane, "No se puede posicionar el barco","ERROR", JOptionPane.ERROR_MESSAGE);
        }
                
        //estadoLogica(mUsuario);
    }
    
    //Función para crear automáticamente la matriz de la computadora
    public void crearMatrizPC(){
        //Barco actual sea diferente de finalizado
        while(barcoActual != finalizado){
            //Se elige en random la fila, columna y dirección
            int columna = getRandom(10);
            int fila = getRandom(10);
            int direccion = getRandom(4);
            
            //Si existen espacios
            if(existenEspacios(columna, fila, direccion, barcoActual.tamano, mPC)){
                
                //For hasta el tamaño del barco actual
                for (int i = 0; i < barcoActual.tamano; i++) {
                    //Se iguala el indicador a la posición acutal
                    mPC[columna][fila] = barcoActual.indicador;

                    //Dependiento la dirección se va restando a la posición
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
                
                ////Se camabia el barco actual
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
                    //Se habilita el botón finalizar
                    finalizar.setVisible(true);
                    //Y el barco actual es finalizado para salir del while
                    barcoActual = finalizado;
                    }    
            }
        }
    }
    
    //Funcion que comprueba si existen espacios
    public boolean existenEspacios(int c, int f, int direcion, int espacios, String[][] matriz){
        int columna= 0;
        int fila = 0;
        
        //Para sumar o restar la columna y no hacer otro switch
        int f_resta = 0;
        int c_resta = 0;
        //Se restan los espacios
        espacios--;
        //Dependiento la dirección
        switch (direcion) {
                case vars.arriba:
                    //se le resta a la fila el numero de espacios necesitados
                    fila = f - espacios;
                    //Si es hacia arriba siempre se le restaría uno
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
       
       //Si está en los límites al ser restados
       if(columna >= 0 && columna <=9 && fila >= 0 && fila <=9  ){
           //Se comprueba ahora si los espacios estan vacios
           boolean espaciosVacios = true;
           //Para cada posición hasta el numero de espacios del barco actual
           for (int i = 0; i < espacios; i++) {
               //Si la matriz es igual a null no hace nada
                if(matriz[c][f] == null){
                }
                //DE lo contrario espacios vacios será false
                else{
                    espaciosVacios = false;
                    //Y se finaliza el for 
                    break;
                }
                //Aquí ses aumentan o se restan las columnas o las filas
                c = c + c_resta;
                f = f + f_resta;
           }
           //Si existen espacios vacíos
           if(espaciosVacios)
               return true;
           //Si algun espacio está lleno
           else
               return false;
       }
       //Si alguno sobrepasa los límites al ser restados
       else
           return false;
       
    } 
    
    //Función que obtiene la dirección que elige el usuario
    public int getDireccion(){
       String[] options = {"Arriba", "Abajo", "Izquierda", "Derecha"};
       //Esto retorna la posición del la opcion seleccionada
       return JOptionPane.showOptionDialog(null, "Es necesario que seleccione una opcion", "Orientación", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[3]);
    }
    
    //Función que dibuja los botones
    public void dibujarBotones(){
        //PAra cada elemento de la columna
        for (int c= 0; c < tamanoColumna; c++) {
            //PAra cada elemento de la fila
            for (int f = 0; f < tamanoFila; f++) {
                //Se utiliza una variable para guardar el botón actual
                MyButton actual = mBotones[c][f] = new MyButton(c,f);
                //SE le da un tamaño
                actual.setBounds((c*tamanoBoton)+30 ,(f*tamanoBoton)+60, tamanoBoton, tamanoBoton);
                //Se le pone el color por defecto
                actual.setBackground(new Color(133, 164, 255));
                //Se le pone el color de letra blaca
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
                //Se añade al contenedor de botones
                contenedor.add(actual);
            }
        }
    }    
    
    //Fucnion para devolver un numero random
    public int getRandom(int limite){
        return random.nextInt(limite);
    }
    
    
    public void imprimirMatriz(String[][] matris){
        for (int c = 0; c < 10; c++) {
                System.out.println(isNull(matris[0][c])+ " "+ isNull(matris[1][c]) + " "+ isNull(matris[2][c]) +" "+  isNull(matris[3][c]) +" "+ isNull(matris[4][c])
                                    + " "+isNull(matris[5][c]) + " "+ isNull(matris[6][c]) +" "+  isNull(matris[7][c]) +" "+ isNull(matris[8][c])+" "+ isNull(matris[9][c]));
        }
        System.out.println("\n");
    }
    
    //PAra comprobar si es null devuelve - si no entonces devuelve el mismo string
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
        indicador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        indicador.setText("Portaaviones");

        finalizar.setBackground(java.awt.Color.red);
        finalizar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
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
                .addGap(201, 201, 201)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(indicador)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(indicador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 532, Short.MAX_VALUE)
                .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        //Cierra la ventana actual
        dispose();
        //Abre el objeto juego y le envia todos los atributos para inicializarlo y se pone visible
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
