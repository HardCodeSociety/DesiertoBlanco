package aplicacion;
import java.awt.Color;
import java.io.*;

/**
 * Write a description of class Oasis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oasis implements Elemento,Serializable{
    private boolean isClaro;
    private Desierto desierto; 
    private Color color;    
    private int posX;
    private int posY;        
    /**
     * Este metodo es el creador de la clase Oasis
     */
    public Oasis(Desierto desierto,int x,int y)
    {
        this.desierto=desierto;
        isClaro=false;
        posX=x;
        posY=y;
        color=Color.BLUE;
    }
    /**
     * Este metodo nos permite mover el egiptologo acorde a la necesidad
     */
    public void muevase(){
        if (!isClaro){
            color=Color.CYAN;
            isClaro=true;
        }else{
            color=Color.BLUE;
            isClaro=false;
        }
    }
     /** Este metodo se encarga de mostrar un tipo determinado de mensaje dependiendo de el caso
     * @return Retorna el mensaje que va a mostrar el elemento
     */
    public String mensaje() {
        String mensaje="";
        return mensaje;
    }
    /**
     * @return Retorna la posicion en x del oasis
     */
    public final  int getPosX(){
        return posX;
    }    
    /**
     * @return Retorna la posicion en y del oasis
     */    
    public final int getPosY(){
        return posY;
    }    
    /**
     * @return Retorna el color del oasis
     */    
    public final Color getColor(){
        return color;
    }    
      /**
     * @return Retorna el valor de verdad acerca de que si es humano
     */
    public final boolean esHumano(){
        return false;
    }    
    }
