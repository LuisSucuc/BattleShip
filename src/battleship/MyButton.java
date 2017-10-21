
package battleship;

import javax.swing.JButton;


class MyButton extends JButton {
    public int columna;
    public int fila;

    
   MyButton(int columna, int fila){
       this.columna = columna;
       this.fila = fila;
   }
   
   public void posicion(){
       System.out.println("Columna:"+columna +"Fila:"+fila);
   }
}

