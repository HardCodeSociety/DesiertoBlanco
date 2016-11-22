package aplicacion;
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class Minucioso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Minucioso extends Egiptologo
{   
   /**
     * Este metodo es el constructor de la clase Minucioso
     */
   public Minucioso(Desierto desierto,String nombre)
    {
       super(desierto,nombre,0,0);
       color=Color.GREEN;
       posX=0;
       posY=0;
       direccion=1;
    }
   /**
     * Este metodo nos permite movernos en una direccion especifica teniendo en cuenta la direccion
     * @param direccion la cual es un numero entero
     */
   private void muevase(int direccion){
        switch(direccion){
            case Desierto.NORTE : posY++;
            break;
            case Desierto.ESTE : posX++;
            break;
            case Desierto.SUR :  posY--;
            break;
            case Desierto.OESTE :posX--;
            break; 
        }                
    }
    /**
     * Este metodo nos permite movernos de forma especifica para una persona minuciosa
     */
   public void muevase(){
       boolean movio = false;
       while ( ! movio ) {
           if (desierto.puedeMover(direccion,this)){
                muevase(direccion);
                enTumba=desierto.estaEnTumba(this);
                movio = true;
            } else {
                muevase(0);
                if (direccion==1)direccion=3;
                else direccion=1;
                movio=true;
           }    
        }
    }
}