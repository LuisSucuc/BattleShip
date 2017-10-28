
package battleship;

import javax.swing.JButton;

//Hereda de la clase botón
class MyButton extends JButton {
    //Recibe la posicion en columa y fila
    public int columna;
    public int fila;

    //Constructor para inicializar la fila ya columna que corresponde
   MyButton(int columna, int fila){
       this.columna = columna;
       this.fila = fila;
   }
   
   public void imprimirPosicion(){
       System.out.println("Columna: "+ columna +" Fila: "+ fila);
   }
}

