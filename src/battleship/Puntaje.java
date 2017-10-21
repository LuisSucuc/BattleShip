package battleship;

public class Puntaje {
    public int portaaviones = 6;
    public int destructor = 5;
    public int fragata = 3;
    public int transportador1 = 2;
    public int transportador2 = 2;
    
    void puntaje(){}
    
    public boolean perdio(){
        return portaaviones    == 0 && 
               destructor     == 0 && 
               fragata         == 0 && 
               transportador1 == 0 && 
               transportador2 == 0;
    }
    
    
   
}
