package aplicacion;
import java.awt.Color;
import java.util.*;
import java.io.*;
/**
 * Write a description of class Mina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mina implements Elemento,Serializable
{
    private Desierto desierto;
    private Color color;
    private int posX;
    private int posY;
    private boolean crearMal;
    /**
     * Este es el metodo constructor de esta clase
     */
    public Mina(Desierto desierto,int x,int y)
    {
        this.desierto= desierto;
        posX=x;
        posY=y;
        color=Color.BLACK;
        crearMal=false;
    }
    /**
     * @return Retorna la posicion en x del elemento
     */
    public int getPosX(){return posX; }
    /**
     * @return Retorna la posicion en y del elemento
     */
    public int getPosY(){return posY;}
    /**
     * @return Retorna el valor de verdad de si es humano o no
     */
    public final boolean esHumano(){return false;}
    /**
     * @return Retorna el color del elemento
     */
    public Color getColor(){return color;}
    /**
     * @return Retorna el mensaje que debe dar el elemento
     */
    public String mensaje(){
        String mensaje;
        mensaje="Lado oscuro de la fuerza";
        return mensaje;
    }
    /**
     * Este metodo hace que la mina se mueva de forma particular
     */
     public void muevase(){
        int a=(int) (Math.random()*4);  
        if (a==3){
            color=Color.RED;
            crearMal=true;
       }else{
        crearMal=false;
        color=Color.BLACK;
        }
    }
    /**
     * @return Retorna el valor de verdad acerca de que si puede crear el mal
     */
    public boolean getCrearMal(){return crearMal;}
    /**
     * @return Retorna el valor a del elemento
     */
    //public int getA()return a;}
    }
