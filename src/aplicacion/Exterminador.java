package aplicacion;
import java.awt.Color;

/**
 * Write a description of class Exterminador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exterminador extends Egiptologo
{
    int elegido;
    Elemento el;
    /**
     * Este es el constructor de esta clase
     */
    public Exterminador(Desierto desierto,String nombre,int x,int y)
    {
        super(desierto,nombre,x,y);
        color=Color.YELLOW;
        elegido=(int) (Math.random()*20);
        if (elegido<(desierto.getElementos()).size()){
            Elemento el=(desierto.getElementos()).get(this.getElegido());
        }
    }
    /**
     * Este metodo permite que el Exterminador se mueva de su forma particular
     * 
     */
    public void muevase(){
        if (this.getElegido()<(desierto.getElementos()).size()){
            el=(desierto.getElementos()).get(this.getElegido());
        }
        super.muevase();
    }
    /**
     * @return eleigido, el cual es el numero de elegido que toma el Exterminador
     * 
     */
    public int getElegido(){
        return elegido;
    }
    /**
     * @return el, el cual es un elemento de la lista elementos
     * 
     */
    public Elemento getElemento(){
        return el;
    }
    }


    