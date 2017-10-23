
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
    public JLabel PC;
    public JLabel Usuario;
    
    Barco(String nombre, String indicador, Color color, int tamano){
        this.nombre = nombre;
        this.indicador = indicador;
        this.color = color;
        this.tamano = tamano;
        this.puntaje = tamano;
    }
    
    public void setLabels(JLabel PC, JLabel Usuario){
        this.PC = PC;
        this.Usuario = Usuario;
    }


}
