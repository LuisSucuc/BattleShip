
package battleship;

import java.awt.Color;
import javax.swing.JLabel;

//Clase que lleva el control de los tipos de Barcos
public class Barco {
    //Nombre del bacro
    String nombre;
    //Indicador: P,D,F,T,t
    String indicador;
    //Color que le corresponde al barco
    Color color;
    //Tamaño del barco que ocupará
    int tamano;
    //Puntaje del barco actual, al inicio será igual al tamaño
    int puntaje;
    //Label que modificará el barco con el puntaje actual
    public JLabel puntajeVisual;
    
    //Constructor único
    Barco(String nombre, String indicador, Color color, int tamano){
        this.nombre = nombre;
        this.indicador = indicador;
        this.color = color;
        this.tamano = tamano;
        this.puntaje = tamano;
    }
    
    //Recibe el Jlabel para que se visualice el puntaje
    public void setLabelPuntaje(JLabel puntajeVisual){
        this.puntajeVisual = puntajeVisual;
    }
    
    //Actualiza el label
    public void actualizarPuntaje(){
        this.puntajeVisual.setText(String.valueOf(this.puntaje));
    }
    
    //Resta en uno el puntaje
    public void restarPuntaje(){
        puntaje--;
    }
    
}
