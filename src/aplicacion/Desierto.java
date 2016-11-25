package aplicacion;
import java.util.*;
import java.awt.*;
import java.io.*;

/**
 * @author ECI 2014
 * Desierto de la aplicación egiptologos
 */
/**
 * @author ECI
 *
 */
public class Desierto implements Serializable{
    public static final int NORTE = 0;
    public static final int ESTE = 1;
    public static final int SUR = 2;
    public static final int OESTE = 3;
    public static final int MAXIMO = 500;
    private static Desierto desierto = null;
    /**
     * @return retorna un desierto
     * Este metodo nos permite crear un desierto en caso de que no haya uno anteriormente, si es asi, lo retorna
     */
    public static Desierto demeDesierto() {
        if (desierto==null){
            desierto=new Desierto();
        }
        return desierto;
    }
    /**
     * 
     * Este metodo se encarga de crear un desierto
     */
    public static void nuevoDesierto() {
        desierto=new Desierto();
    }   
    
    public static void cambieDesierto(Desierto d) {
        desierto=d;
    }       
    
    /*
     * Coleccion de egiptologos en la desierto 
     */
    private ArrayList<Elemento> elementos;
    
    private int tumbaPosX;
    private int tumbaPosY;
    private boolean encontraronTumba;
    
    /**
     * Este metodo inicializa un desierto teniendo en cuenta sus limites
     */
    private Desierto() {
        elementos= new ArrayList<Elemento>();
        tumbaPosX = (int)(Math.random() * MAXIMO);
        tumbaPosY = (int)(Math.random() * MAXIMO);
        encontraronTumba=false;
    }
    
    
    /**
     * Este metodo nos permite agregar personas a el desierto
     */
    public void algunosElementos(){    
        elementos.add(new Egiptologo(this,"Yasay",200,200));
        elementos.add(new Egiptologo(this,"indiana",300,300));
        //elementos.add(new Egiptologo(this,"agente007",100,100));
        //elementos.add(new Rebelde(this,"homer",30,30));
        //elementos.add(new Rebelde(this,"bard",400,40));
        //elementos.add(new Oasis(this,0,0));
        //elementos.add(new Oasis(this,500,500));
        //elementos.add(new Poblador(this,"susanita",150,80));
        //elementos.add(new Poblador(this,"felipito",150,480));
        //elementos.add(new Minucioso(this,"harry"));
        //elementos.add(new Exterminador(this,"Arnold",40,400));
        //elementos.add(new Exterminador(this,"Rambo",400,100));
        //elementos.add(new Mina(this,350,250));
    }  
    /**
     * @return retorna un booleano el cual nos dice si encontraron la tumba
     */
    public boolean encontraronTumba() {
        return encontraronTumba;
    }
    
    /**
     * @param Recibe un numero n el cual representa una posicion en elementos
     * @return El elemento de la lista en la posicion n
     */
    public Elemento demeElemento(int n){
        Elemento h=null;
        if (1<=n && n<=elementos.size()){
            h=elementos.get(n-1);
        }    
        return h; 
    }
    
    
    
    /**
     * @return Numero de egiptologos en la desierto
     */
    public int numeroElementos(){
        return elementos.size();
    }
    
    
    
   /**
    *  @param Numero el cual nos indica la direccion del movimiento.
    *  @param E que es el elemento que vamos a tomar para la verificacion.
    *  @return Un booleano para saber si podemos moverlo o no.
    */
    public boolean puedeMover(int direccion, Elemento e) {
        boolean puede=false;
        int posX=e.getPosX();
        int posY=e.getPosY();
        switch(direccion){
            case NORTE : puede = (posY+1 < MAXIMO);
            break;
            case ESTE : puede = (posX+1 < MAXIMO);
            break;
            case SUR :  puede = (posY-1 >= 0);
            break;
            case OESTE :puede = (posX-1 >= 0);
            break; 
        } 
        return puede;
    }
    /**
     *  @param e es  un elemento
     *  @return retorna un booleano que nos dice si esta en la tumba
     * 
     */
    public boolean estaEnTumba(Elemento e){
        boolean tumba=(tumbaPosX==e.getPosX() && tumbaPosY==e.getPosY());
        encontraronTumba = encontraronTumba || tumba;
        return tumba;   
    } 
    /**
     * @return retorna la lista de elementos
     * 
     */
    public ArrayList<Elemento> getElementos(){
        return elementos;
    }
    
    /**
     * @param NumElemento es el numero de elemento en la lista elementos
     * Este metodo se encarga de mover un elemento en especifico teniendo en cuenta el tipo de elemento que es, ya que cada uno describe un movimiento distinto
     */
    public void seMueve(int numElemento){
        
         if(elementos.get(numElemento) instanceof Oasis){
            ((Oasis)elementos.get(numElemento-1)).muevase();
          }else if(elementos.get(numElemento) instanceof Exterminador){
           ((Exterminador)elementos.get(numElemento-1)).muevase();
             int elegido =((Exterminador)elementos.get(numElemento-1)).getElegido();
             if(elegido<elementos.size())
             elementos.remove(elegido);
            }else if (elementos.get(numElemento) instanceof Egiptologo){
            ((Egiptologo)elementos.get(numElemento-1)).muevase();
         
        }else{
          ((Mina)elementos.get(numElemento-1)).muevase();
            if(((Mina)elementos.get(numElemento-1)).getCrearMal()){
                int x=(int) (Math.random()*500);
                int y=(int) (Math.random()*500);
                elementos.add(new Exterminador(this,"darth vader",x,y));
            }
        }
    }
    
  /**
   * Este metodo se encarga de mover todos los elementos, teniendo en cuenta el movimiento especifico de cada uno de ellos
   * 
   */  
    public void seMueven(){
    for (Elemento i: elementos){
        if(i instanceof Poblador){
            if(((Poblador)i).getSiConvencio()){
                int x=(int) (Math.random()*500);
                int y=(int) (Math.random()*500);
                Egiptologo convencido=new Egiptologo(this,"lugareño",x,y); 
                elementos.add(convencido);
           }
           ((Poblador)i).muevase();
        }else if(i instanceof Exterminador){
           ((Exterminador)i).muevase();
            int elegido =((Exterminador)i).getElegido();
            if(elegido<elementos.size())
        
            elementos.remove(elegido);
        }else if(i instanceof Mina) {
            ((Mina)i).muevase();
            if(((Mina)i).getCrearMal()){
                int x=(int) (Math.random()*500);
                int y=(int) (Math.random()*500);
                elementos.add(new Exterminador(this,"darth vader",x,y));
            }
        }else if (i instanceof Egiptologo){
            ((Egiptologo) i).muevase();
            
        }else{
            ((Oasis) i).muevase();
            }
    }
  }
  public  void reiniciar(){
	elementos.clear();
      algunosElementos();
  }
}
