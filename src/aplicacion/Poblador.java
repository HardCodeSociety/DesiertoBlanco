package aplicacion;
import java.util.*;
import java.awt.Color;
public class Poblador extends Egiptologo
{
    private boolean siConvencio;
    /**
     * Este metodo es el constructor de poblador, no tiene ningun tipo de retorno.
     */ 
    public Poblador(Desierto desierto,String nombre,int x,int y)
    {
      super(desierto,nombre,x,y);
      color=Color.ORANGE;
      siConvencio=false;
    }
    /**
     * Este metodo es el metodo que nos va a permitir mover el poblador, teniendo en cuenta si logro
     * convencer a algun tipo de persona, ademas no retorna nada
     */
    public void muevase()
    {      
       int convencio=(int) (Math.random()*15);
       if(convencio==1){
           siConvencio=true;
        }else{
           siConvencio=false;
        }
        super.muevase();
    }
    /**
     * Este metodo retorna el valor de la variable SiConvencio, la cual nos permite saber si convencio
     * a algun lugareño de ser egiptologo.
     */
    public boolean getSiConvencio(){
        return siConvencio;
    }
    
}
   