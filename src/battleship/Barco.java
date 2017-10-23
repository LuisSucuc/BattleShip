
package battleship;

import java.awt.Color;
import java.awt.Label;
import javax.swing.JLabel;

public class Barco {
    String nombre;
    String indicador;
    Color color;
    int tamano;
    int puntaje;
    public JLabel puntajeVisual;
    
    Barco(String nombre, String indicador, Color color, int tamano){
        this.nombre = nombre;
        this.indicador = indicador;
        this.color = color;
        this.tamano = tamano;
        this.puntaje = tamano;
    }
    
    public void setLabel(JLabel puntajeVisual){
        this.puntajeVisual = puntajeVisual;
    }

    public void actualizarLabel(){
        this.puntajeVisual.setText(String.valueOf(this.puntaje));
    }
    
    public void restarPuntaje(){
        puntaje--;
    }
    
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
