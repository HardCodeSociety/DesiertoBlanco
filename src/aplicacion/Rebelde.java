package aplicacion;
import java.awt.Color;

/**
 * Write a description of class Rebelde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Rebelde extends Egiptologo{
    private int numV;
    /**
     * Es el metodo creador de la clase Rebelde
     */
    public Rebelde (Desierto desierto,String nombre ,int x,int y){
        super(desierto,nombre,x,y);
        color=Color.RED;
        numV=0;
    }
    /**
     * Este metodo nos permite mover el egiptologo acorde a la necesidad
     */
    public void muevase(){
        numV+=1;
        if (numV==3){
            super.muevase();
        }
   }
   /** Este metodo se encarga de mostrar un tipo determinado de mensaje dependiendo de el caso
     * @return Retorna el mensaje que va a mostrar el elemento
     */
   public String mensaje(){
       String mensaje;
       if (enTumba){
            mensaje="¡Encontre la tumba! Soy" + nombre;
        }
       else if(numV==3){
           numV=0;
           mensaje=nombre +" Estoy buscando";
        }else{
        mensaje=nombre+" No estoy buscando";
        }
       return mensaje;
    }
   }
