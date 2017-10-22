
package battleship;

import java.awt.Color;

public class Barco {
    String nombre;
    String indicador;
    Color color;
    int tamano;
    
    Barco(String nombre, String indicador, Color color, int tamano){
        this.nombre = nombre;
        this.indicador = indicador;
        this.color = color;
        this.tamano = tamano;
    }
}
