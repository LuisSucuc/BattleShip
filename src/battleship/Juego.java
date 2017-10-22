
package battleship;

import java.awt.Color;
import java.awt.event.ActionEvent;


public final class Juego extends javax.swing.JFrame {
    
    int tamanoColumna;
    int tamanoFila;
    Barco portaaviones;
    Barco destructor;
    Barco fragata;
    Barco transportador1;
    Barco transportador2;
    boolean turnoPC;
    private final String[][] mPC;
    private final String[][] mUsuario;
    private final MyButton[][] btnPC;
    private final MyButton[][] btnUsuario;
    private static final int tamanoBoton = 45;


    public Juego(String[][] mUsuario,String[][] mPC,Barco portaaviones,Barco destructor,Barco fragata,Barco transportador1,Barco transportador2,int tamanoColumna,int tamanoFila) {
        initComponents();
        this.mUsuario = mUsuario;
        this.mPC = mPC;
        this.portaaviones = portaaviones;
        this.destructor = destructor;
        this.fragata = fragata;
        this.transportador1 = transportador1;
        this.transportador2 = transportador2;
        this.tamanoColumna = tamanoColumna;
        this.tamanoFila = tamanoFila;
        btnPC = new MyButton[tamanoColumna][tamanoFila];
        btnUsuario = new MyButton[tamanoColumna][tamanoFila];
        dibujarBotones();
    }
    
    public void dibujarBotones(){  
        for (int columna= 0; columna < tamanoColumna; columna++) {
            
            for (int fila = 0; fila < tamanoFila; fila++) {
                
                MyButton actualPC = btnPC[columna][fila] = new MyButton(columna,fila);
                actualPC.setBounds((columna*tamanoBoton + 15),(fila*tamanoBoton)+15, tamanoBoton, tamanoBoton);
                actualPC.setBackground(new Color(255, 178, 255));
                actualPC.setForeground(Color.WHITE);
                actualPC.setBorder(null);
                
                actualPC.addActionListener((ActionEvent e) -> {
                    
                    if(mPC[actualPC.columna][actualPC.fila] == null && turnoPC){
                        
                    }
                    
                });
                panelPC.add(actualPC);
                
                MyButton actualUsu = btnUsuario[columna][fila] = new MyButton(columna,fila);
                actualUsu.setBounds((columna*tamanoBoton + 15),(fila*tamanoBoton)+15, tamanoBoton, tamanoBoton);
                actualUsu.setBackground(new Color(133, 164, 255));
                actualUsu.setForeground(Color.WHITE);
                actualUsu.setBorder(null);
                
                actualUsu.addActionListener((ActionEvent e) -> {
                    
                    if(mUsuario[actualUsu.columna][actualUsu.fila] == null && turnoPC){
                        
                    }
                    
                });
                panelUsu.add(actualUsu);
            }
        }
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

        panelPC = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelUsu = new javax.swing.JPanel();
        puntajeUsu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPortaavionesU = new javax.swing.JLabel();
        lblDestructorU = new javax.swing.JLabel();
        lblTransportador2U = new javax.swing.JLabel();
        lblTransportador1U = new javax.swing.JLabel();
        lblFragataU = new javax.swing.JLabel();
        puntajePC = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblPortaavionesPC = new javax.swing.JLabel();
        lblDestructorPC = new javax.swing.JLabel();
        lblTransportador2PC = new javax.swing.JLabel();
        lblTransportador1PC = new javax.swing.JLabel();
        lblFragataPC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 249, 246));
        setResizable(false);

        panelPC.setBackground(java.awt.Color.white);
        panelPC.setMinimumSize(new java.awt.Dimension(480, 480));

        javax.swing.GroupLayout panelPCLayout = new javax.swing.GroupLayout(panelPC);
        panelPC.setLayout(panelPCLayout);
        panelPCLayout.setHorizontalGroup(
            panelPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        panelPCLayout.setVerticalGroup(
            panelPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TABLERO USUARIO");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TABLERO PC");

        panelUsu.setBackground(java.awt.Color.white);
        panelUsu.setMinimumSize(new java.awt.Dimension(480, 480));

        javax.swing.GroupLayout panelUsuLayout = new javax.swing.GroupLayout(panelUsu);
        panelUsu.setLayout(panelUsuLayout);
        panelUsuLayout.setHorizontalGroup(
            panelUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        panelUsuLayout.setVerticalGroup(
            panelUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        puntajeUsu.setBackground(java.awt.Color.white);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("USUARIO");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setText("Portaaviones");

        jLabel5.setText("Destructor");

        jLabel6.setText("Fragata");

        jLabel7.setText("Transportador 1");

        jLabel8.setText("Transportador 2");

        lblPortaavionesU.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblPortaavionesU.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPortaavionesU.setText("6");

        lblDestructorU.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblDestructorU.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDestructorU.setText("5");

        lblTransportador2U.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblTransportador2U.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTransportador2U.setText("2");

        lblTransportador1U.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblTransportador1U.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTransportador1U.setText("2");

        lblFragataU.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblFragataU.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFragataU.setText("3");

        javax.swing.GroupLayout puntajeUsuLayout = new javax.swing.GroupLayout(puntajeUsu);
        puntajeUsu.setLayout(puntajeUsuLayout);
        puntajeUsuLayout.setHorizontalGroup(
            puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(puntajeUsuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(puntajeUsuLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTransportador1U, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(puntajeUsuLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTransportador2U, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(puntajeUsuLayout.createSequentialGroup()
                            .addGroup(puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(puntajeUsuLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFragataU, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, puntajeUsuLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(85, 85, 85)
                                    .addComponent(lblDestructorU)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(puntajeUsuLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPortaavionesU)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, puntajeUsuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        puntajeUsuLayout.setVerticalGroup(
            puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(puntajeUsuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPortaavionesU))
                .addGap(12, 12, 12)
                .addGroup(puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblDestructorU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblFragataU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTransportador1U))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(puntajeUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblTransportador2U))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        puntajePC.setBackground(java.awt.Color.white);

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("PC");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel16.setText("Portaaviones");

        jLabel17.setText("Destructor");

        jLabel18.setText("Fragata");

        jLabel19.setText("Transportador 1");

        jLabel20.setText("Transportador 2");

        lblPortaavionesPC.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblPortaavionesPC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPortaavionesPC.setText("6");

        lblDestructorPC.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblDestructorPC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDestructorPC.setText("5");

        lblTransportador2PC.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblTransportador2PC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTransportador2PC.setText("2");

        lblTransportador1PC.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblTransportador1PC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTransportador1PC.setText("2");

        lblFragataPC.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblFragataPC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFragataPC.setText("3");

        javax.swing.GroupLayout puntajePCLayout = new javax.swing.GroupLayout(puntajePC);
        puntajePC.setLayout(puntajePCLayout);
        puntajePCLayout.setHorizontalGroup(
            puntajePCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(puntajePCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(puntajePCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(puntajePCLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPortaavionesPC))
                    .addGroup(puntajePCLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDestructorPC))
                    .addGroup(puntajePCLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFragataPC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(puntajePCLayout.createSequentialGroup()
                        .addGroup(puntajePCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(puntajePCLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(lblTransportador2PC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(puntajePCLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(lblTransportador1PC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, puntajePCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        puntajePCLayout.setVerticalGroup(
            puntajePCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(puntajePCLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(puntajePCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblPortaavionesPC))
                .addGap(12, 12, 12)
                .addGroup(puntajePCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblDestructorPC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(puntajePCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblFragataPC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(puntajePCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblTransportador1PC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(puntajePCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblTransportador2PC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puntajePC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntajeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(puntajeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(puntajePC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblDestructorPC;
    private javax.swing.JLabel lblDestructorPC1;
    private javax.swing.JLabel lblDestructorU;
    private javax.swing.JLabel lblFragataPC;
    private javax.swing.JLabel lblFragataPC1;
    private javax.swing.JLabel lblFragataU;
    private javax.swing.JLabel lblPortaavionesPC;
    private javax.swing.JLabel lblPortaavionesPC1;
    private javax.swing.JLabel lblPortaavionesU;
    private javax.swing.JLabel lblTransportador1PC;
    private javax.swing.JLabel lblTransportador1PC1;
    private javax.swing.JLabel lblTransportador1U;
    private javax.swing.JLabel lblTransportador2PC;
    private javax.swing.JLabel lblTransportador2PC1;
    private javax.swing.JLabel lblTransportador2U;
    private javax.swing.JPanel panelPC;
    private javax.swing.JPanel panelUsu;
    private javax.swing.JPanel panelUsu1;
    private javax.swing.JPanel panelUsu2;
    private javax.swing.JPanel panelUsu3;
    private javax.swing.JPanel puntajePC;
    private javax.swing.JPanel puntajeUsu;
    // End of variables declaration//GEN-END:variables
}
