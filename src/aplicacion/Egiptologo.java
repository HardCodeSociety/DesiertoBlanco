package aplicacion;

import java.awt.Color;

public class Egiptologo implements Elemento{
    
    
    
    protected Desierto desierto; 
    protected String nombre;
    protected Color color;
    
    protected int posX;
    protected int posY;
    protected boolean enTumba;
    protected int direccion;
    
    
    
    
    /**Crea un buescador en un desierto dando su nombre
     * @param nombre
     */
    public Egiptologo(Desierto desierto, String nombre,int x, int y) {
        this.nombre = nombre;
        this.desierto=desierto;
        posX=x;
        posY=y;
        color=Color.BLACK;
        enTumba=desierto.estaEnTumba(this);
        direccion=(int)(Math.random()*4);
    }
    
    /** Este metodo se encarga de mostrar un tipo determinado de mensaje dependiendo de el caso
     * @return Retorna el mensaje que va a mostrar el elemento
     */
    public String mensaje() {
        String mensaje;
        if (enTumba){
            mensaje="¡Encontre la tumba! Soy" + nombre;
        } else {
            mensaje= nombre+": sigo buscando";
        }
        return mensaje;
    }
    /**
     * @return Retorna la posicion en x del elemento
     */
    public final  int getPosX(){
        return posX;
    }    
    /**
     * @return Retorna la posicion en y del elemento
     */
    public final int getPosY(){
        return posY;
    }    
    /**
     * @return Retorna el color del elemento
     */
    public final Color getColor(){
        return color;
    }    
    
    /**
     * @return Retorna el valor de verdad acerca de que si esta en la tumba
     */
    public final boolean enTumba(){
        return enTumba;
    }    
    /**
     * @return Retorna el valor de verdad acerca de que si es humano
     */
    public final boolean esHumano(){
        return true;
    }
    /**
     * Este metodo mueve el egiptologo de acuerdo a una direccion especiica
     * @param direccion que es de tipo entero
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
     * Este metodo nos permite mover el egiptologo acorde a la necesidad
     */
    public void muevase() {
        boolean movio = false;
        while (! enTumba && ! movio ) {
            if (desierto.puedeMover(direccion,this)){
                muevase(direccion);
                enTumba=desierto.estaEnTumba(this);
                movio = true;
            } else {
                direccion= (direccion + 1) % 4;
            }    
        }
 
    }

   
}
    